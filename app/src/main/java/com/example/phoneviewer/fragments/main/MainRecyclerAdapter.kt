package com.example.phoneviewer.fragments.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.phoneviewer.R
import com.example.phoneviewer.fragments.main.model.Model

class MainRecyclerAdapter(
    private val item: List<Model>,
    private val onItemClickListener: (Model) -> Unit,
): RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_phone, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var titleView: TextView
        lateinit var posterView: ImageView
        lateinit var itemViewGroup: RelativeLayout

        fun bind(item: Model) {
            titleView = itemView.findViewById(R.id.titleView)
            posterView = itemView.findViewById(R.id.posterView)
            itemViewGroup = itemView.findViewById(R.id.itemPopViewGroup)

            titleView.text = item.title

            val radius = 24
            Glide
                .with(itemView)
                .load(item.photos)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .apply(RequestOptions().transforms(RoundedCorners(radius)))
                .into(posterView)

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)
            }
        }
    }
}