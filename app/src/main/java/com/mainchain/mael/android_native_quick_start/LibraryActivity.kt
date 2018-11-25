package com.mainchain.mael.android_native_quick_start

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.mainchain.mael.android_native_quick_start.entities.Book
import com.mainchain.mael.android_native_quick_start.fragment.BookFragment
import com.mainchain.mael.android_native_quick_start.fragment.BooksFragment
import com.mainchain.mael.android_native_quick_start.fragment.EmptyFragment

/**
 * Main activity
 * Handle the three fragments and when to switch between each other.
 * @author Mael MAINCHAIN
 */
class LibraryActivity  : AppCompatActivity(), BooksFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Get "right" frame layout
        var element: FrameLayout = findViewById(R.id.containerFrameLayout2)

        // Getting orientation
        val landscape = resources.getBoolean(R.bool.landscape)

        // Add List of books fragment to the activity (left part)
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, BooksFragment())
                .commit()

        // Make the "right" frame invisible
        element.visibility = View.GONE

        // If orientation is landscape
        if (landscape) {
            // Split the screen and add EmptyFragment to right part
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout2, EmptyFragment())
                    .commit()
            element.visibility = View.VISIBLE
        }
    }

    /**
     * When a Book is selected on the list
     */
    override fun onListFragmentInteraction(book: Book?) {
        // If orientation is portrait
        if (!resources.getBoolean(R.bool.landscape)) {
            // Make the list disappear to show book view
            showElement()
        }
        // Create new BookFragment to show selected book
        val b = BookFragment()
        // Add it the required book
        b.setBook(book)
        // Add it to the right part of the screen
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout2, b)
                .commit()
    }

    /**
     * When the back button is pressed
     */
    override fun onBackPressed() {
        // Getting BookView (right part)
        var element: FrameLayout = findViewById(R.id.containerFrameLayout2)
        // If orientation is portrait and bookview is visible
        if(!resources.getBoolean(R.bool.landscape) &&
                element.visibility == View.VISIBLE) {
            // Hide BookView and show only List
            showList()
        } else {
            // Else normal behaviour
            super.onBackPressed()
        }
    }

    /**
     * Hide Book view and show List
     */
    fun showList() {
        var list: FrameLayout = findViewById<FrameLayout>(R.id.containerFrameLayout)
        var element: FrameLayout = findViewById<FrameLayout>(R.id.containerFrameLayout2)
        list.visibility = View.VISIBLE
        element.visibility = View.GONE
    }

    /**
     * Hide List and show Book view
     */
    fun showElement() {
        var list: FrameLayout = findViewById<FrameLayout>(R.id.containerFrameLayout)
        var element: FrameLayout = findViewById<FrameLayout>(R.id.containerFrameLayout2)
        list.visibility = View.GONE
        element.visibility = View.VISIBLE
    }
}