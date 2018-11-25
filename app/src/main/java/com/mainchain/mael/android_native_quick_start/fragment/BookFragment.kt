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

class BookFragment : Fragment() {

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
        val bookCover = view.findViewById<ImageView>(R.id.book_cover)
        val bookTitle = view.findViewById<TextView>(R.id.book_title)
        val bookPrice = view.findViewById<TextView>(R.id.book_price)
        val bookSynopsis = view.findViewById<TextView>(R.id.book_synopsis)
        bookTitle.text = "Sélectionnez un livre dans l'écran de gauche"

        if (book !== null) {
            bookTitle.text = this.book?.title
            Picasso.get().load(this.book?.cover).into(bookCover)
            bookPrice.text = "Prix : " + this.book?.price + "€"
            var synopsis = ""
            this.book?.synopsis?.forEach { part -> synopsis += part }
            bookSynopsis.text = synopsis
        }
    }

    fun setBook(book: Book?) {
        this.book = book
    }
}