package com.example.heroiki

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class HeroesAdapter(private val itemsList: List<ItemViewModel>) :
    RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

        @SuppressLint("CutPasteId")
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val image: ImageView
            val title: TextView
            val description: TextView

            init {
                image = view.findViewById(R.id.itemImageView)
                title = view.findViewById(R.id.titleTv)
                description = view.findViewById(R.id.descriptionTv)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.all_heroes_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(itemsList[position].image)
        holder.title.text = itemsList[position].title
        holder.description.text = itemsList[position].description
    }

    override fun getItemCount() = itemsList.size
}