package com.mainchain.mael.android_native_quick_start

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mainchain.mael.android_native_quick_start.entities.Book

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
        val textView = view.findViewById<TextView>(R.id.book_number)
        textView.text = "Hello world"

        if (book !== null) {
            textView.text = this.book?.title
            // view.findViewById<TextView>(R.id.book_content).text = "Je suis là"
        }
    }

    fun setBook(book: Book?) {
        this.book = book
    }
}