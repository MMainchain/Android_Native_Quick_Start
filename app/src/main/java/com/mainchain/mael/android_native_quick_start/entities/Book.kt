package com.mainchain.mael.android_native_quick_start.entities

/**
 * Book entity
 * Handle   title
 *          isbn
 *          price
 *          synopsis
 * @author Mael MAINCHAIN
 */
data class Book(val isbn: String, val title: String, val price: String, val cover: String, val synopsis: Array<String>)