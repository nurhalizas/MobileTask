package com.D121201053.taskme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.D121201053.taskme.R
import com.D121201053.taskme.databinding.FragmentListBinding
import com.D121201053.taskme.databinding.FragmentTambahTugasBinding
import com.D121201053.taskme.model.Tugas
import com.D121201053.taskme.viewmodel.TugasViewModel
import kotlinx.coroutines.launch


class TambahTugasFragment : Fragment() {
    private var _binding: FragmentTambahTugasBinding?=null
    private val binding get() = _binding!!
    private lateinit var tugasViewModel : TugasViewModel
    lateinit var kategoriTugas: ArrayAdapter<CharSequence>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTambahTugasBinding.inflate(inflater,container,false)
        val view = binding.root

        tugasViewModel = ViewModelProvider(this)[TugasViewModel::class.java]
        kategoriTugas = ArrayAdapter.createFromResource(requireContext(),R.array.kategori_tugas, android.R.layout.simple_list_item_1)
        binding.dropdownMenu.setAdapter(kategoriTugas)

        binding.btnAdd.setOnClickListener {
            binding.apply {
                val kategori = dropdownMenu.text.toString()
                val judul = mataKuliah.text.toString()
                val isi = isiTugas.text.toString()
                if(kategori.isEmpty()){
                    Toast.makeText(requireContext(),"Kategori Tugas kosong",
                        Toast.LENGTH_SHORT).show()
                    dropdownMenu.requestFocus()
                    return@setOnClickListener
                }
                if(judul.isEmpty()){
                    mataKuliah.error = "Tidak boleh kosong"
                    mataKuliah.requestFocus()
                    return@setOnClickListener
                }
                if(isi.isEmpty()){
                    isiTugas.error = "Tidak boleh kosong"
                    isiTugas.requestFocus()
                    return@setOnClickListener
                }

                lifecycleScope.launch{
                    val tugas = Tugas(0,judul,isi,kategori, "Belum Selesai")
                    tugasViewModel.addTugas(tugas)
                    findNavController().navigate(R.id.action_tambahTugasFragment_to_listFragment)
                 }
            }
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_tambahTugasFragment_to_listFragment)
        }



        return view
    }
}