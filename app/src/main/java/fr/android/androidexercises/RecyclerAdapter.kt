package fr.android.androidexercises

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class RecyclerAdapter(private val inflater: LayoutInflater, private val collection: List<Book>, private val resource: Int) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder!!.itemView as BookItemView).bind(this.collection[position])    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(this.resource, parent, false))
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}