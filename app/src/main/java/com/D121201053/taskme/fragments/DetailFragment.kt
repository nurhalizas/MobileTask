package com.D121201053.taskme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.D121201053.taskme.R
import com.D121201053.taskme.adapter.TugasAdapter
import com.D121201053.taskme.databinding.FragmentDetailBinding
import com.D121201053.taskme.databinding.FragmentListBinding
import com.D121201053.taskme.viewmodel.TugasViewModel

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private lateinit var tugasViewModel : TugasViewModel
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root

        tugasViewModel = ViewModelProvider(this)[TugasViewModel::class.java]

        binding.mataKuliah.text = args.currentTask.judul_tugas
        binding.kategoriTugas.text = args.currentTask.kategori_tugas
        binding.isiTugas.text = args.currentTask.isi_tugas

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }



        return view
    }
}