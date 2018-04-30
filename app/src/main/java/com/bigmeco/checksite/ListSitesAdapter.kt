package com.bigmeco.checksite

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_lista.view.*

class ListSitesAdapter(val items: List<MyUrl>, val listener: () -> Unit) : RecyclerView.Adapter<ListSitesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_lista, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position],holder, listener)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MyUrl,holder: ViewHolder, listener: () -> Unit) = with(itemView) {
            Url.text = item.url
            holder.itemView.WebUrl.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    println("hello")
                    return true
                }
            }
            //holder.webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)
            holder.itemView.WebUrl.loadUrl(item.url)


        }

    }


}