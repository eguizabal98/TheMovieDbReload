package com.eem.themoviedbreload

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TheMovieDb : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
