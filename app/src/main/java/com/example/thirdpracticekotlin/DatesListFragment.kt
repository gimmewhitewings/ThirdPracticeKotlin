package com.example.thirdpracticekotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdpracticekotlin.databinding.FragmentDatesListBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

class DatesListFragment : Fragment() {

    private lateinit var binding: FragmentDatesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDatesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.datesRecycler.apply {
            adapter = DatesAdapter(getDatesList())
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.navigationButton.setOnClickListener { findNavController().popBackStack() }
    }

    private fun getDatesList(): List<String> {
        val dir = requireContext().getDir("photos", Context.MODE_PRIVATE)
        val file = File(dir, "date.txt")
        return if (file.exists()) file.readLines() else emptyList()
    }
}