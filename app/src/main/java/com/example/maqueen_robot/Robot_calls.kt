package com.example.maqueen_robot

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class Robot_calls {

    companion object {

        suspend fun switch(url: String): Boolean {
            return withContext(Dispatchers.IO) {
                try {
                    val connection = URL(url).openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"
                    connection.connectTimeout = 5000 // Set your desired timeout
                    connection.readTimeout = 5000 // Set your desired timeout

                    // Get the HTTP response code
                    val responseCode = connection.responseCode

                    // Log the response code for debugging
                    Log.i("Response code", "$responseCode")

                    // Check if the response code is 200 (OK)
                    if (responseCode == 200) {
                        return@withContext true
                    } else {
                        // Handle other response codes if needed
                        return@withContext false
                    }
                } catch (e: Exception) {
                    // Handle exceptions such as network errors
                    Log.e("Error", "Exception during HTTP request: ${e.message}")
                    return@withContext false
                }
            }
        }


    }


}