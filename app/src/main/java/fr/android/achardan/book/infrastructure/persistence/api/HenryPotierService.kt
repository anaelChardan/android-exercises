package fr.android.achardan.book.infrastructure.persistence.api

import fr.android.achardan.book.domain.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface HenriPotierService {
    @GET("books")
    fun getBooks(): Call<List<Book>>
}