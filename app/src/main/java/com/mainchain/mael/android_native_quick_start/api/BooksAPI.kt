package com.mainchain.mael.android_native_quick_start.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import com.mainchain.mael.android_native_quick_start.entities.Book

public class BooksAPI {

    companion object {

        val BASE_URI = "http://henri-potier.xebia.fr/"

        @JvmStatic
        fun getBooks(callback: (Array<Book>?) -> Unit) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URI)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val api = retrofit.create(Api::class.java)

            api.listBooks().enqueue(object : Callback<Array<Book>> {
                override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                    Log.e("APPLICATION", t.message);
                }

                override fun onResponse(call: Call<Array<Book>>,
                                        response: Response<Array<Book>>) {

                    Log.e("APPLICATION", "Data dowloaded");
                    callback(response.body())
                }
            })
        }
    }

}