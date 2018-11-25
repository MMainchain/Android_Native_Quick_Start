package com.mainchain.mael.android_native_quick_start.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mainchain.mael.android_native_quick_start.R
import com.mainchain.mael.android_native_quick_start.entities.Book
import com.squareup.picasso.Picasso

/**
 * Fragment for book object
 * Handle a single Book object and show its properties
 * @author Mael MAINCHAIN
 */
class BookFragment : Fragment() {

    /**
     * The book object
     */
    private var book: Book? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book,
                container,
                false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Getting all part of the view to fill
        val bookCover = view.findViewById<ImageView>(R.id.book_cover)
        val bookTitle = view.findViewById<TextView>(R.id.book_title)
        val bookPrice = view.findViewById<TextView>(R.id.book_price)
        val bookSynopsis = view.findViewById<TextView>(R.id.book_synopsis)

        // If the book is present in the object
        if (book !== null) {
            // Add the title to the view
            bookTitle.text = this.book?.title
            // And request for the image, show it on the view as well
            Picasso.get().load(this.book?.cover).into(bookCover)
            // Add price
            bookPrice.text = "Prix : " + this.book?.price + "€"
            // Concatenate all synopsis...
            var synopsis = ""
            this.book?.synopsis?.forEach { part -> synopsis += part }
            // And show it
            bookSynopsis.text = synopsis
        }
    }

    /**
     * Setter for the Book object
     */
    fun setBook(book: Book?) {
        this.book = book
    }
}