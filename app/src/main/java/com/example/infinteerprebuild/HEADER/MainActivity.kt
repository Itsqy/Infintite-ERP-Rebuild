package com.example.infinteerprebuild.HEADER

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infinteerprebuild.RESPONSE.ListOrder
import com.example.infinteerprebuild.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var headerViewModel: HeaderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//      show header
        headerViewModel = HeaderViewModel(this)
        showLoading()
        headerViewModel.showHeader("DR")

    }

    fun showLoading() {
        headerViewModel.isLoading.observe(this) {
            binding?.apply {
                if (it) {
                    pbRelease.visibility = View.VISIBLE
                    rvHeader.visibility = View.INVISIBLE
                } else {
                    pbRelease.visibility = View.GONE
                    rvHeader.visibility = View.VISIBLE
                }
            }
        }
    }

    fun showDataHeader(dataHeader: List<ListOrder?>?) {
        val adapterHeader = HeaderAdapter(dataHeader, this)
        binding.rvHeader.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapterHeader
        }
    }
}