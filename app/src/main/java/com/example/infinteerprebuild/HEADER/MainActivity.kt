package com.example.infinteerprebuild.HEADER

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infiniteerp.data.remote.response.ListOrder
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
        headerViewModel.showHeader()

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