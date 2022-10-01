package com.maddeveloper.kmmkit.android

import android.app.Application
import android.content.Context

import com.maddeveloper.kmmkit.android.screens.MainVm
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module


class MainApplication : Application() {
    companion object {
        private var mContext: Context? = null
        val appContext: Context?
            get() = mContext
    }

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext



        val mainActivityVM = module {
            factory {
                MainVm()
            }
        }




        startKoin {
            androidLogger()
            //inject Android context
            androidContext(this@MainApplication)
            // use modules

            modules(
                listOf(
                  mainActivityVM,
                )
            )

        }


    }
}
