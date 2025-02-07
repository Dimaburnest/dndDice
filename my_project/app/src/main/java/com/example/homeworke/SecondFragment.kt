package com.example.homeworke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecAdapter
    private var dataList : MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        adapter = RecAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }
    fun addItem(sum: ArrayList<Int>) {
        val newItem = "элемент ${dataList.size + 1}  $sum"
        adapter.addData(newItem)
    }


//    private fun remove (){
//        dataList.removeAll(
//            elements = TODO()
//        )
//    }

}