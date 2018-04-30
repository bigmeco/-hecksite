package com.bigmeco.checksite

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lista.*
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient





class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_lista)

        // указываем страницу загрузки
        WebUrl.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url);
                println("hello")
                return true
            }
        }
        WebUrl.loadUrl("http://google.com")
  // указываем страницу загрузки


//        UrlListView.layoutManager = LinearLayoutManager(this)
//        UrlListView.adapter = MyFilmAdapter(realm.where(MyFilm::class.java).findAll(), {
//            topFilmList!!.adapter.notifyDataSetChanged()
//        })
    }
}
