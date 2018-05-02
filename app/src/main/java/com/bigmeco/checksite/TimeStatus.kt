package com.bigmeco.checksite

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TimeStatus : RealmObject() {

    var time: String? = null
    var status: Int? = null



}