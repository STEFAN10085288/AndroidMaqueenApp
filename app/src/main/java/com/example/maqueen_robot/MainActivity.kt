package com.example.maqueen_robot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var btnForward: Button
    private lateinit var btnBackward: Button
    private lateinit var btnStop: Button
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var btnPlayMusic: Button
    private lateinit var btnAutoPilot: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnForward = findViewById(R.id.btnForward)
        btnBackward = findViewById(R.id.btnBackward)
        btnStop = findViewById(R.id.btnStop)
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        btnPlayMusic = findViewById(R.id.btnPlayMusic)
        btnAutoPilot = findViewById(R.id.btnAutoPilot)

        btnPlayMusic.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/PlayMusic")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("Music api call", "Play music : ${temp}")
                } else {
                    Log.i("Music api call", "Play music : ${temp}")
                }
            }
        }

        btnAutoPilot.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/AutoPilot")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("AutoPilot api call", "AutoPilot:  ${temp}")
                } else {
                    Log.i("AutoPilot api call", "AutoPilot: ${temp}")
                }
            }
        }


        btnForward.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/Forward")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("Api CALL", "Call was null and invalid ${temp}")
                } else {
                    Log.i("Valid", "API call was valid ${temp}")
                }
            }
        }

        btnBackward.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/Backward")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("Api CALL", "Call was null and invalid")
                } else {
                    Log.i("Valid", "API call was valid")
                }
            }
        }



        btnStop.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/Stop")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("Api CALL", "Call was null and invalid")
                } else {
                    Log.i("Valid", "API call was valid")
                }
            }
        }



        btnLeft.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/TurnLeft")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("Api CALL", "Call was null and invalid")
                } else {
                    Log.i("Valid", "API call was valid")
                }
            }
        }

        btnRight.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            val job = scope.launch {
                var temp: Boolean = Robot_calls.switch("http://192.168.4.1/TurnRight")
                Log.i("Switch", "THE API CALL WAS HIT")

                if (temp == null) {
                    Log.i("Api CALL", "Call was null and invalid")
                } else {
                    Log.i("Valid", "API call was valid")
                }
            }
        }
    }
}