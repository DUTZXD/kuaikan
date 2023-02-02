package com.kuaikan.zxd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.manhuaRv)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.kuaikanmanhua.com/v2/pweb/daily/topics")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val manhuaService = retrofit.create(ManhuaService::class.java)
        val call = manhuaService.getDailyUpdate(0)
        call.enqueue(object : Callback<ManhuaBean?> {
            override fun onResponse(call: Call<ManhuaBean?>, response: Response<ManhuaBean?>) {
                val bean = response.body()
                if (bean != null) {
                    val data = bean.data
                    //                    data.optJSONArray();
                    runOnUiThread {
                        val adapter = recyclerView.getAdapter() as ManHuaAdapter?
                        adapter!!.setData()
                    }
                }
            }

            override fun onFailure(call: Call<ManhuaBean?>, t: Throwable) {}
        })
        val adapter = ManHuaAdapter()
    }
}