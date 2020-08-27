package com.sulistyo.testandroidlumutid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sulistyo.testandroidlumutid.model.MainModel
import com.sulistyo.testandroidlumutid.network.ApiCall
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val data = intent.getStringExtra("data")
        val title = intent.getStringExtra("titel")
        tvDetail.text = title


    }

    //untuk mengambil data detail dari server
    private fun initView(id:String){
        val apicall = ApiCall.create()
        apicall.getDetail("data").enqueue(object : Callback<List<MainModel>> {
            override fun onResponse(
                call: Call<List<MainModel>>,
                response: Response<List<MainModel>>
            ) {
                if (response.isSuccessful) {
                    tvDetail.text = response.body()?.get(0)?.title
                }

            }

            override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

        })
    }

}