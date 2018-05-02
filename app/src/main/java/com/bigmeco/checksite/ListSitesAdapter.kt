package com.bigmeco.checksite

import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_lista.view.*
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class ListSitesAdapter(val items: List<MyUrl>, val listener: () -> Unit) : RecyclerView.Adapter<ListSitesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_lista, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MyUrl, listener: () -> Unit) = with(itemView) {
            Url.text = item.url
           // statusView.text = item.timeStatus.get(0)
            WebUrl.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    println("hello")
                    return true
                }
            }
                WebUrl.loadUrl("http://${item.url}")






        }


}

}

