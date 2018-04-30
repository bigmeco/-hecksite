package com.bigmeco.checksite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_site.*

class AddSiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_site)
        val realm: Realm = Realm.getDefaultInstance()

        okButton.setOnClickListener{
            val newUrl = MyUrl()

            newUrl.url = urlText.text.toString()
            newUrl.workingBg = checkBox.isChecked
            realm.executeTransaction { realm ->
                realm.insert(newUrl)
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
