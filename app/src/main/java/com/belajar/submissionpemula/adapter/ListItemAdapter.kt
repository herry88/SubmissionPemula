package com.belajar.submissionpemula.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belajar.submissionpemula.R
import com.belajar.submissionpemula.model.Item

class ListItemAdapter(
    private val listItem: ArrayList<Item>,
    private val onClick: (Item) -> Unit
) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPhoto: ImageView = view.findViewById(R.id.imgPhoto)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvShortDesc: TextView = view.findViewById(R.id.tvShortDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.imgPhoto.setImageResource(item.photo)
        holder.tvName.text = item.name
        holder.tvShortDesc.text = item.shortDesc

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }
}