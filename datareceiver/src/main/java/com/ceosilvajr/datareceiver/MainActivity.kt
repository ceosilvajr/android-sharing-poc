package com.ceosilvajr.datareceiver

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

/**
 * @author ceosilvajr@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        handleIntentDataFromSender()
    }

    private fun handleIntentDataFromSender() {
        if (intent?.action == Intent.ACTION_SEND) {
            val bundle = intent.extras
            bundle?.let {
                val type = it.getString("type") ?: "Not found"
                val data = it.getSerializable("data") as HashMap<*, *>
                val builder = StringBuilder(type)
                builder.append(data.entries)
                tv_data.text = builder.toString()
            }
        }
    }
}
