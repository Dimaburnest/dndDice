package com.example.homeworke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworke.databinding.SecondFragmentBinding



class SecondFragment : Fragment(R.layout.second_fragment) {
val dataItem: MutableList<Item> = arrayListOf()
val shareVM : SharedViewModel by activityViewModels()
    var previousSize = 0
    private lateinit var adapter: RecAdapter


    private var _binding: SecondFragmentBinding? = null
    private val binding get() = _binding!!
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            _binding = SecondFragmentBinding.inflate(inflater, container, false)
            adapter = RecAdapter(dataItem)
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = adapter
            shareVM.items.observe(viewLifecycleOwner) { list ->
                if (list.size > previousSize) {
                    list.lastOrNull()?.let { newItem ->
                        adapter.addItem(newItem)
                    }
                } else if (list.size < previousSize) {
                        adapter.clearItem()
                }

                previousSize = list.size
            }


                return binding.root }

    }