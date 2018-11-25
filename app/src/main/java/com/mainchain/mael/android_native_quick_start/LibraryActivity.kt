package com.mainchain.mael.android_native_quick_start

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.mainchain.mael.android_native_quick_start.entities.Book
import com.mainchain.mael.android_native_quick_start.fragment.BookFragment
import com.mainchain.mael.android_native_quick_start.fragment.BooksFragment

class LibraryActivity  : AppCompatActivity(), BooksFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val landscape = resources.getBoolean(R.bool.landscape)

        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, BooksFragment())
                .commit()

        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.GONE

        if (landscape) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout2, BookFragment())
                    .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }
    }

    override fun onListFragmentInteraction(book: Book?) {
        if (!resources.getBoolean(R.bool.landscape)) {
            showElement()
        }
        val b = BookFragment()
        b.setBook(book)
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, b)
                .commit()
    }

    override fun onBackPressed() {
        if(!resources.getBoolean(R.bool.landscape) &&
                findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility == View.VISIBLE) {
            showList()
        } else {
            super.onBackPressed()
        }
    }

    fun showList() {
        var list = findViewById<FrameLayout>(R.id.containerFrameLayout)
        var element = findViewById<FrameLayout>(R.id.containerFrameLayout2)
        list.visibility = View.VISIBLE
        element.visibility = View.GONE
    }

    fun showElement() {
        var list = findViewById<FrameLayout>(R.id.containerFrameLayout)
        var element = findViewById<FrameLayout>(R.id.containerFrameLayout2)
        list.visibility = View.GONE
        element.visibility = View.VISIBLE
    }
}