package com.ceosilvajr.datasender

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author ceosilvajr@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_send.setOnClickListener { sendData() }
    }

    private fun sendData() {
        val bundle = Bundle().apply {
            val arrayString = hashMapOf(
                    Pair("cashier", "cashier data"),
                    Pair("releasing", "cashier data"),
                    Pair("customer", "cashier data")
            )
            putSerializable("data", arrayString)
            putString("type", "final")
            putString("order", Gson().toJson(OrderModel("It works!")))
        }
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            setPackage("com.ceosilvajr.datareceiver")
            putExtras(bundle)
        }
        startActivity(intent)
    }

}
