package com.mainchain.mael.android_native_quick_start

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import com.mainchain.mael.android_native_quick_start.entities.Book

class LibraryActivity  : AppCompatActivity(), BooksFragment.OnListFragmentInteractionListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val landscape = resources.getBoolean(R.bool.landscape)

        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, BooksFragment())
                .commit()

        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.INVISIBLE

        if (landscape) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout2, BookFragment())
                    .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }
    }

    override fun onListFragmentInteraction(book: Book?) {
        val b = BookFragment()
        b.setBook(book);
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, b)
                .commit()
    }
}