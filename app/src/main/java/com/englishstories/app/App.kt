package com.englishstories.app

import android.app.Application
import com.englishstories.db.MyDadatabe

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MyDadatabe.init(this)
    }
}