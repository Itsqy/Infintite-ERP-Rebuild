package com.example.infinteerprebuild.LINE

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infiniteerp.data.remote.response.ListOrder
import com.example.infiniteerp.data.remote.response.ListOrderLine
import com.example.infinteerprebuild.databinding.ActivityLineBinding

class LineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLineBinding
    private lateinit var lineViewModel: LineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLineBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val idHeader = intent.getParcelableExtra<ListOrder>("id")
        lineViewModel = LineViewModel(this)

        if (idHeader != null) {
            lineViewModel.showListLine(idHeader.id)
//            binding.tvTest.text = idHeader.id
        }


    }

    fun showDataLine(dataLine: List<ListOrderLine?>?) {
        val adapterLine = LineAdapter(dataLine, this)
        binding.rvLine.apply {
            layoutManager = LinearLayoutManager(this@LineActivity)
            setHasFixedSize(true)
            adapter = adapterLine
        }

//        binding.tvTest.text = dataLine?.get(0)?.lineNo
    }
}