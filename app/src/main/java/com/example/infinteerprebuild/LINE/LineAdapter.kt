package com.example.infinteerprebuild.LINE

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infinteerprebuild.RESPONSE.ListOrderLine
import com.example.infinteerprebuild.R


class LineAdapter(val dataHeader: List<ListOrderLine>, val context: Context) :
    RecyclerView.Adapter<LineAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bussinessPartner = view.findViewById<TextView>(R.id.tv_bussinespartner_line)
        val docNo = view.findViewById<TextView>(R.id.tv_document_line)
        val totalNet = view.findViewById<TextView>(R.id.tv_totalnet_line)
        //        val btnHeader = view.findViewById<TextView>(R.id.btnL)
        val btnDetail = view.findViewById<TextView>(R.id.btn_detailline)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_line, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.docNo.text = dataHeader?.get(position)?.lineNo

        holder.bussinessPartner.text = dataHeader?.get(position)?.lineNetAmount

        holder.totalNet.text = dataHeader?.get(position)?.product


        holder.btnDetail.setOnClickListener {
            val intent = Intent(context, DetailLineActivity::class.java)
            intent.putExtra("id", dataHeader?.get(position))
            context.startActivity(intent)
        }

//        holder.btnHeader.setOnClickListener {
//            val intent = Intent(context, DetailLineActivity::class.java)
//            intent.putExtra("idHeader", dataHeader?.get(position))
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        if (dataHeader != null) {
            return dataHeader.size
        }
        return 0
    }
}