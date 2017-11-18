package fr.android.achardan.book.infrastructure.processor

import android.os.Parcel
import android.os.Parcelable
import fr.android.achardan.book.domain.model.Book
import fr.android.achardan.book.domain.processor.BookProcessor
import fr.android.achardan.generic.processor.ItemProcessor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitItemProcessor() : BookProcessor, ItemProcessor<Book>, Parcelable {
    override fun process(processFunction: (List<Book>) -> Unit, onError: (Throwable) -> Unit) {
        val retrofit =
                Retrofit
                        .Builder()
                        .baseUrl("http://henri-potier.xebia.fr/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        val service = retrofit.create(HenriPotierService::class.java)

        service.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                response.body()?.let {
                    processFunction(it)
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                onError(t)
            }
        })
    }

    //todo JUST TO AVOID DEPENDENCY INJECTION AND STATIC
    constructor(parcel: Parcel) : this()

    override fun writeToParcel(dest: Parcel?, flags: Int) {}

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RetrofitItemProcessor> {
        override fun createFromParcel(parcel: Parcel): RetrofitItemProcessor {
            return RetrofitItemProcessor(parcel)
        }

        override fun newArray(size: Int): Array<RetrofitItemProcessor?> {
            return arrayOfNulls(size)
        }
    }
}