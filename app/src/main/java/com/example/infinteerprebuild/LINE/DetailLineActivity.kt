package com.example.infinteerprebuild.LINE


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.infiniteerp.data.remote.response.ListOrderLine
import com.example.infinteerprebuild.databinding.ActivityDetailLineBinding

class DetailLineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailLineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailLineBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        add null check in vall idLine


        val idLine = intent.getParcelableExtra<ListOrderLine>("lineNo") as ListOrderLine

        Log.d("lineActivty", "${idLine.toString()})")
        binding.tbLine.title = idLine?.lineNo
        binding.tvLine.text = idLine?.lineNo

    }
}