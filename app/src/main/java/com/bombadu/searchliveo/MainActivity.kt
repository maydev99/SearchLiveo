package com.bombadu.searchliveo



import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.liveo.searchliveo.SearchLiveo
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),SearchLiveo.OnSearchListener {

    private lateinit var mSearchLiveo: SearchLiveo



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mSearchLiveo = findViewById(R.id.search_liveo)
        mSearchLiveo.with(this).build()
        mSearchLiveo.with(this).hideSearch { }.build()


        val myToolbar = findViewById<Toolbar>(R.id.toolbar)
        myToolbar.title = "Hello World"
        myToolbar.inflateMenu(R.menu.main_menu)
        myToolbar.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->
            val id = item.itemId
            if (id == R.id.action_search) {
                mSearchLiveo.show()
                Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
                return@OnMenuItemClickListener true
            }

            if (id == R.id.settings) {
                Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
            }
            false
        })






    }

    override fun changedSearch(p0: CharSequence?) {

    }


   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}