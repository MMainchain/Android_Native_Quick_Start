package com.mainchain.mael.android_native_quick_start

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mainchain.mael.android_native_quick_start.BooksFragment.OnListFragmentInteractionListener
import com.mainchain.mael.android_native_quick_start.entities.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_book_element.view.*

class MyBookRecyclerViewAdapter(
        private val mValues: List<Book>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyBookRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Book
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_book_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.itemTitle.text = item.title
        Picasso.get().load(item.cover).into(holder.itemCover)
        holder.itemPrice.text = "Prix : " + item.price + "€"

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val itemTitle: TextView = mView.item_title
        val itemCover: ImageView = mView.item_cover
        val itemPrice: TextView = mView.item_price

        override fun toString(): String {
            return super.toString() + " '"+"'"
        }
    }
}
