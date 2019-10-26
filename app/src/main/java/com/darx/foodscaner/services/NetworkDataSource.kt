package com.darx.foodscaner.services

import android.util.Log
import androidx.lifecycle.LiveData
import com.darx.foodscaner.database.ScannedProductModel

interface NetworkDataSource {
    val product: LiveData<ScannedProductModel>

    suspend fun fetchProductByBarcode(barcode: Long, callback: Callback = DefaultCallback())

    interface Callback {
        fun onNoConnectivityException()
        fun onHttpException()
    }

    class DefaultCallback: Callback {
        override fun onNoConnectivityException() {
            Log.e("Connectivity", "No internet connection.")
        }
        override fun onHttpException() {
            Log.e("HTTP", "Wrong answer.")
        }
    }

}