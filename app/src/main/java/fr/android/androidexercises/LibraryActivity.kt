package fr.android.androidexercises

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class LibraryActivity : AppCompatActivity(), Step0Fragment.OnNextStep0Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        startService(Intent(this, JobService::class.java))
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

//    class JobService: IntentService("coucou") {
//        override fun onHandleIntent(intent: Intent?) {
//            val endTime = System.currentTimeMillis() + 5 * 1000
//            try {
//                java.lang.Object().wait(endTime - System.currentTimeMillis())
//            } catch (ignored: Exception) {}
//
//            Toast.makeText(this, "It's finish", Toast.LENGTH_LONG).show();
//        }
//
//    }

}
