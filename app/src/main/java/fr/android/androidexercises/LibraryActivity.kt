package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LibraryActivity : AppCompatActivity(), Step0Fragment.OnNextStep0Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, Step0Fragment(), Step0Fragment::class.java.simpleName)
                .commit()
    }

    override fun onNext() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, Step1Fragment(), Step1Fragment::class.java.simpleName)
                .addToBackStack("coucou")
                .commit()
    }

}
