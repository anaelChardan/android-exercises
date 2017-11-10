package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_library.*
import android.view.LayoutInflater
import android.support.v7.widget.GridLayoutManager
import java.util.*


class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        bookListView.layoutManager = GridLayoutManager(this, 2)
        bookListView.adapter = RecyclerAdapter(
                LayoutInflater.from(this),
                (0..99).map { Book("Garry Potier Tom $it", Random().nextFloat()) },
                R.layout.custom_view_item_book
        )
    }
}
