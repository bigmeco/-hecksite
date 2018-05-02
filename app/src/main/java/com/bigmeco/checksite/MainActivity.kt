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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_site.*


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
       var f =ArrayList<MyUrl>()
//        Service.getSite("http://${item.url}").getSatys()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ result ->
//                }, { error ->
//                    error.printStackTrace()
//                })
        plusButton.setOnClickListener {
            dialog.visibility = View.VISIBLE

        }
        okButton.setOnClickListener {
            dialog.visibility = View.INVISIBLE

        }
        fonButton.setOnClickListener {
            dialog.visibility = View.INVISIBLE

        }
    }


}
