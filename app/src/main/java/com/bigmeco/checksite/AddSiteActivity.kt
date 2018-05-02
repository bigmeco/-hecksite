package com.bigmeco.checksite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_site.*
import io.realm.RealmResults
import io.realm.kotlin.createObject
import android.provider.ContactsContract.CommonDataKinds.Email
import java.util.*


class AddSiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_site)
        val realm: Realm = Realm.getDefaultInstance()

        okButton.setOnClickListener{
            val newUrl = MyUrl()

            newUrl.url = urlText.text.toString()
           // newUrl.timeStatus.to() = urlText.text.toString()
            realm.executeTransaction { realm ->

                //val myUrl = realm.createObject(MyUrl::class.java, urlText.text.toString())
//                for (j in 0 .. 4) {
//                    val timeStatus = realm.createObject<TimeStatus>()
//                    timeStatus.time= "time $j"
//                    timeStatus.status= 200
//                    myUrl.timeStatus!!.add(timeStatus)
//                    Log.d("dd", "ОБьект адреса")
//                    Log.d("dd", myUrl.toString())
//                    Log.d("dd", "Статусы обьекта")
//
//                }
                //realm.insert(newUrl)

                val myUrl = realm.where(MyUrl::class.java).equalTo("url","hh.ru").findAll()[0]
                val timeStatus = realm.createObject(TimeStatus::class.java)
                timeStatus.status= 404
                timeStatus.time= Calendar.getInstance().getTime().toString()
                myUrl!!.timeStatus!!.add(timeStatus)


                Log.d("dd", "Получение обьекта")
                for (j in 0 until myUrl.timeStatus!!.size) {
                    Log.d("dd", myUrl!!.timeStatus!!.get(j).toString() +j)
                }
                //Log.d("dd",timeStatus.toString() )
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
