package com.makendzi.shoppinglist.activities

import android.app.Application
import com.makendzi.shoppinglist.db.MainDataBase

class MainApp : Application() {
    val dataBase by lazy { MainDataBase.getDataBase(this) }
}