package com.bigmeco.checksite

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MyUrl : RealmObject() {

    @PrimaryKey
    var url: String? = null
    var workingBg: Boolean? = null



}