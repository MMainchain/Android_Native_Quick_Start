package com.mainchain.mael.android_native_quick_start.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import com.mainchain.mael.android_native_quick_start.entities.Book

/**
 * API class to request Henri Potier API
 * Expose static functions to gain code simplicity
 * @author Mael MAINCHAIN
 */
class BooksAPI {

    companion object {

        /**
         * Base URI for Henri Potier API
         */
        val BASE_URI = "http://henri-potier.xebia.fr/"

        /**
         * Request book from Henri Potier API
         * @param callback : Function : (Array<Book>?) -> void
         */
        @JvmStatic
        fun getBooks(callback: (Array<Book>?) -> Unit) {
            // Use retrofit
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URI)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val api = retrofit.create(Api::class.java)

            // Request here
            api.listBooks().enqueue(object : Callback<Array<Book>> {
                // If error
                override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                    Log.e("APPLICATION", t.message);
                }

                // If success call callback function given in parameters
                override fun onResponse(call: Call<Array<Book>>,
                                        response: Response<Array<Book>>) {

                    Log.e("APPLICATION", "Data dowloaded");
                    callback(response.body())
                }
            })
        }
    }

}