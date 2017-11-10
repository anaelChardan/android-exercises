package fr.android.androidexercises

import retrofit2.Call
import retrofit2.http.GET

interface HenriPotierService {
    @GET("books")
    fun getBooks(): Call<List<Book>>
}