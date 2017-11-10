package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import timber.log.Timber

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Plant logger cf. Android Timber
        Timber.plant(Timber.DebugTree())

        // TODO build Retrofit
        val retrofit =
                Retrofit
                        .Builder()
                        .baseUrl("http://henri-potier.xebia.fr/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        // TODO create a service
        val service = retrofit.create(HenriPotierService::class.java)


        service.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                response.body()?.forEach { Timber.d(it.title) }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Timber.e(t)
            }
        })
    }

}
