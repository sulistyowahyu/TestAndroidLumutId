package com.sulistyo.testandroidlumutid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulistyo.testandroidlumutid.adapter.MainAdapter
import com.sulistyo.testandroidlumutid.model.MainModel
import com.sulistyo.testandroidlumutid.network.ApiCall
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val apicall = ApiCall.create()
        apicall.getData().enqueue(object : Callback<List<MainModel>> {
            override fun onResponse(
                call: Call<List<MainModel>>,
                response: Response<List<MainModel>>
            ) {
                if (response.isSuccessful) {
                    val mData = response.body()
                    mAdapter = MainAdapter(this@MainActivity, mData!!)
                    rvMain.apply {
                        adapter = mAdapter
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

        })
    }

}