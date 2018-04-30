package com.bigmeco.checksite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_lista)

//        UrlListView.layoutManager = LinearLayoutManager(this)
//        UrlListView.adapter = MyFilmAdapter(realm.where(MyFilm::class.java).findAll(), {
//            topFilmList!!.adapter.notifyDataSetChanged()
//        })
    }
}
