package com.sulistyo.testandroidlumutid.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulistyo.testandroidlumutid.DetailActivity
import com.sulistyo.testandroidlumutid.R
import com.sulistyo.testandroidlumutid.model.MainModel
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter(private val context: Context, private val mData: List<MainModel>) :
    RecyclerView.Adapter<MainAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyHolder, position: Int) =
        holder.bind(mData[position], context)

    override fun getItemCount() = mData.size

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: MainModel, context: Context) {
            itemView.tvId.text = data.userId.toString()
            itemView.tvTitle.text = data.title
            itemView.cvMain.setOnClickListener {
                val i = Intent(context, DetailActivity::class.java)
                i.putExtra("data", data.id.toString())
                i.putExtra("titel", data.title.toString())
                context.startActivity(i)
            }

        }
    }

}