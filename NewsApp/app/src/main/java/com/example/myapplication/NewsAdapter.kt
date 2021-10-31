package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter( private val listener: MainActivity):RecyclerView.Adapter<NewsView>(){

    private val items:ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsitem,parent,false)
        val viewHolder = NewsView(view)
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsView, position: Int) {
        val currItem = items[position]
        holder.titleview.text=currItem.title
        holder.author.text=currItem.author
        Glide.with(holder.itemView.context).load(currItem.imageUrl).into(holder.image)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(UpdatedItems:ArrayList<News>){
        items.clear()
        items.addAll(UpdatedItems)
        notifyDataSetChanged()
    }

}



class NewsView (itemView: View): RecyclerView.ViewHolder(itemView){

    val titleview:TextView=itemView.findViewById(R.id.title)
    val image:ImageView=itemView.findViewById(R.id.image)
    val author:TextView = itemView.findViewById(R.id.author)

}

interface ItemClicked{
    fun onItemClicked(item:News)
}