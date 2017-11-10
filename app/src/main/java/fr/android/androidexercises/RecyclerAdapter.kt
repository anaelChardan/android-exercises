package fr.android.androidexercises

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class RecyclerAdapter<T>(private val inflater: LayoutInflater, private val collection: List<T>, private val resource: Int) : RecyclerView.Adapter<RecyclerAdapter<T>.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder?.itemView as ItemView<T>).bind(this.collection[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(inflater.inflate(this.resource, parent, false))


    override fun getItemCount(): Int = collection.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}