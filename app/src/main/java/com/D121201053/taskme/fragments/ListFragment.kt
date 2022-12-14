package com.D121201053.taskme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.D121201053.taskme.R
import com.D121201053.taskme.adapter.TugasAdapter
import com.D121201053.taskme.databinding.FragmentListBinding
import com.D121201053.taskme.viewmodel.TugasViewModel


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding?=null
    private val binding get() = _binding!!
    private lateinit var tugasViewModel : TugasViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListBinding.inflate(inflater,container,false)
        val view = binding.root

        tugasViewModel = ViewModelProvider(this)[TugasViewModel::class.java]
        val adapter = TugasAdapter()
        binding.recyceTugas.adapter = adapter
        binding.recyceTugas.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        tugasViewModel = ViewModelProvider(this)[TugasViewModel::class.java]
        tugasViewModel.readAllDataHome.observe(viewLifecycleOwner){ tugas->
            adapter.setData(tugas)
        }



        binding.addTugas.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_tambahTugasFragment)
        }

        return view
    }
}