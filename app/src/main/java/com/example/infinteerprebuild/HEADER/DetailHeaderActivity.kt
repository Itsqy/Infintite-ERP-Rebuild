package com.example.infinteerprebuild.HEADER

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.infinteerprebuild.LINE.LineActivity
import com.example.infinteerprebuild.RESPONSE.ListOrder
import com.example.infinteerprebuild.databinding.ActivityDetailHeaderBinding

class DetailHeaderActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailHeaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbApproval)
        showDetail()


    }

    private fun showDetail() {
        val idHeader = intent.getParcelableExtra<ListOrder>("idHeader")
        if (idHeader != null) {
            binding.buttonToLine.text = idHeader.id
            val netAmount = idHeader.grandTotalAmount
            binding.tvDocumentRelease.text = idHeader.documentNo
            binding.tbApproval.title = "Header ${idHeader.documentNo}"
            binding.tvOrderDate.text = idHeader.orderDate
            binding.tvBusinessPartner.text = idHeader.bussinesPartner
            binding.tvDeliveryDate.text = idHeader.scheduledDeliveryDate
            binding.tvTotalNet.text = "Rp. $netAmount"
            binding.tvDocStatus.text = idHeader.documentStatus
        } else {
            binding.buttonToLine.text = "tidak ada line"

        }

        binding.buttonToLine.setOnClickListener {
            val intent = Intent(this, LineActivity::class.java)
            intent.putExtra("id", idHeader)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}