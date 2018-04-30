package com.bigmeco.checksite

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        Realm.init(this)


        val realm: Realm = Realm.getDefaultInstance()
        urlListView.layoutManager = LinearLayoutManager(this)
        urlListView.adapter = ListSitesAdapter(realm.where(MyUrl::class.java).findAll(), {
            urlListView!!.adapter.notifyDataSetChanged()
        })


        plusButton.setOnClickListener {
            val intent = Intent(this, AddSiteActivity::class.java)
            startActivity(intent)
        }
    }


}
