package com.example.homeworke

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

import java.util.Locale

class RecAdapter(var items: MutableList<Item>) : RecyclerView.Adapter<RecAdapter.MyViewHolder>() {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(old: Item, new: Item) = old.throwDise == new.throwDise
            override fun areContentsTheSame(old: Item, new: Item) = old == new
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.trow_dise)
        private val diseSum:TextView = itemView.findViewById(R.id.dise_sum)
        val counter: TextView = itemView.findViewById(R.id.item_text)
        val dataTime: TextView = itemView.findViewById(R.id.tv_time)
        fun bind(item: Item) {
            titleView.text = item.throwDise.toString()
            diseSum.text = item.diseNumber.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
        val cocounter = position + 1
        holder.counter.text = cocounter.toString()
        val time = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        holder.dataTime.text = time.format(System.currentTimeMillis())

    }



    override fun getItemCount(): Int = items.size

    fun addItem(item: Item) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
    }

}




