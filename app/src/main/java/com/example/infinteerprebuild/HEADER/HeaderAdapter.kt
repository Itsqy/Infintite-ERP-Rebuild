package com.example.infinteerprebuild.HEADER

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infinteerprebuild.RESPONSE.ListOrder
import com.example.infinteerprebuild.LINE.LineActivity
import com.example.infinteerprebuild.R


class HeaderAdapter(val dataHeader: List<ListOrder?>?, val context: Context) :
    RecyclerView.Adapter<HeaderAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bussinessPartner = view.findViewById<TextView>(R.id.tv_bussinespartner_release)
        val docNo = view.findViewById<TextView>(R.id.tv_document_release)
        val totalNet = view.findViewById<TextView>(R.id.tv_totalnet_release)
        val btnHeader = view.findViewById<TextView>(R.id.btn_header)
        val btnLine = view.findViewById<TextView>(R.id.btn_line)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_header, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.docNo.text = dataHeader?.get(position)?.id
        holder.bussinessPartner.text = dataHeader?.get(position)?.bussinesPartner
        holder.totalNet.text = dataHeader?.get(position)?.grandTotalAmount


        holder.btnLine.setOnClickListener {
            val intent = Intent(context, LineActivity::class.java)
            intent.putExtra("id", dataHeader?.get(position))
            context.startActivity(intent)
        }

        holder.btnHeader.setOnClickListener {
            val intent = Intent(context, DetailHeaderActivity::class.java)
            intent.putExtra("idHeader", dataHeader?.get(position))
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        if (dataHeader != null) {
            return dataHeader.size
        }
        return 0
    }
}