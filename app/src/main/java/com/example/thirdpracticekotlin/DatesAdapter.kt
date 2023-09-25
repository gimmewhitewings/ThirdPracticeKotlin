package com.example.thirdpracticekotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DatesAdapter(private val datesList: List<String>) :
    RecyclerView.Adapter<DatesAdapter.DateViewHolder>() {


    class DateViewHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        fun bind(date: String) {
            val textView = itemView.findViewById<TextView>(R.id.dateTextView)
            textView.text = date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.date_item, parent, false)

        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datesList.size
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(datesList[position])
    }
}