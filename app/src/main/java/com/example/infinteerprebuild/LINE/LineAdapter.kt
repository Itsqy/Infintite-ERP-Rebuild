package com.example.infinteerprebuild.LINE

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infiniteerp.data.remote.response.ListOrderLine
import com.example.infinteerprebuild.R


class LineAdapter(val dataLine: List<ListOrderLine?>?, val context: Context) :
    RecyclerView.Adapter<LineAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bussinessPartner = view.findViewById<TextView>(R.id.tv_bussinespartner_line)
        val docNo = view.findViewById<TextView>(R.id.tv_document_line)
        val totalNet = view.findViewById<TextView>(R.id.tv_totalnet_line)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_line, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.docNo.text = dataLine?.get(position)?.lineNo
        holder.bussinessPartner.text = dataLine?.get(position)?.bussinesPartner
        holder.totalNet.text = dataLine?.get(position)?.lineNetAmount


        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailLineActivity::class.java)
            intent.putExtra("lineNo", dataLine?.get(position))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        if (dataLine != null) {
            return dataLine.size
        }
        return 0
    }
}