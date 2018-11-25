package com.mainchain.mael.android_native_quick_start.api

import com.mainchain.mael.android_native_quick_start.entities.Book
import retrofit2.Call
import retrofit2.http.GET

/**
 * API part for retrofit
 * Handle the routes
 * @author Mael MAINCHAIN
 */
interface Api {
    /**
     * Route for Books
     */
    @GET("books")
    fun listBooks(): Call<Array<Book>>
}