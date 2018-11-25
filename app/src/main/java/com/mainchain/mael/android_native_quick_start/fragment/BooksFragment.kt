package com.mainchain.mael.android_native_quick_start.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mainchain.mael.android_native_quick_start.adapter.MyBookRecyclerViewAdapter
import com.mainchain.mael.android_native_quick_start.R
import com.mainchain.mael.android_native_quick_start.api.BooksAPI
import com.mainchain.mael.android_native_quick_start.entities.Book

/**
 * Fragment for book list
 * Handle a list of books
 * @author Mael MAINCHAIN
 */
class BooksFragment : Fragment() {

    /**
     * Number of column of the list
     */
    private var columnCount = 1

    /**
     * Listener for the action to an element of the list
     */
    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                // Request all books
                BooksAPI.getBooks { apibooks: Array<Book>? -> run {
                    // Transform the Array into required List
                    var books: MutableList<Book> = mutableListOf()
                    apibooks?.forEach { book -> books.add(book) }
                    // Instantiate the adapter
                    adapter = MyBookRecyclerViewAdapter(books, listener)
                } }
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * Interface to be implemented in activity
     */
    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(item: Book?)
    }

    /**
     * Companion object
     */
    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
                BooksFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
