package com.van133.my_gs

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        var body: ResultBarcode?
        val btn_event = findViewById<Button>(R.id.Camera)
        val add_bar = findViewById<Button>(R.id.Add_barcode)
        val barcode = findViewById<TextView>(R.id.barcode)
        val name = findViewById<TextView>(R.id.name)
        val Where = findViewById<TextView>(R.id.Where)
        var temp : String
        var qrCodeScan = QRCodeScan(this)
        var retrofit = Retrofit.Builder()
            .baseUrl("http://172.30.48.1:8080")//"http://ec2-18-223-106-78.us-east-2.compute.amazonaws.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        btn_event.setOnClickListener{
            qrCodeScan.startQRScan()
            println("==========================================")
            temp = qrCodeScan.getBar()
            println()
            val api = retrofit.create(Search_Barcode::class.java)
            val callSearch_Barcode = api.getSearchBarcode(temp,"1")
            callSearch_Barcode.enqueue(object : Callback<ResultBarcode> {
                override fun onResponse(
                    call: Call<ResultBarcode>,
                    response: Response<ResultBarcode>
                ) {
                    println("결과"+"성공 : ${response.body()}")
                    body = response.body()
                    barcode.text = body!!.bar_CD
                    name.text = body!!.prdlst_NM
                    Where.text = temp
                }

                override fun onFailure(call: Call<ResultBarcode>, t: Throwable) {
                    println("결과:"+ "실패 : $t")
                }
            })

            println("==========================================")
        }
        add_bar.setOnClickListener{
            qrCodeScan.startQRScan()
            println("==========================================")
            temp = qrCodeScan.getBar()
            setContentView(R.layout.input)
            val name = findViewById<EditText>(R.id.name)
            val SaveEvent = findViewById<Button>(R.id.save_button)
            SaveEvent.setOnClickListener {
                val api = retrofit.create(Search_Barcode::class.java)
                setContentView(R.layout.main_layout)
                val callAddBarcode= api.getAddBarcode(temp,name.toString())
                callAddBarcode.enqueue(object : Callback<ResultBarcode> {
                    override fun onResponse(
                        call: Call<ResultBarcode>,
                        response: Response<ResultBarcode>
                    ) {
                        println("결과"+"성공 : ${response.body()}")
                        body = response.body()
                    }

                    override fun onFailure(call: Call<ResultBarcode>, t: Throwable) {
                        println("결과:"+ "실패 : $t")
                    }
                })
            }
            //val api = retrofit.create(Search_Barcode::class.java)

        }
    }
}
