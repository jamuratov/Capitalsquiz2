package com.example.capitalsquiz2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import androidx.core.widget.addTextChangedListener
import com.example.capitalsquiz2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("CapitalsSettings", Context.MODE_PRIVATE)

        binding.etName.addTextChangedListener {
            binding.tilName.isErrorEnabled = false
        }


        binding.btnStart.setOnClickListener{
            val name = binding.etName.text.toString()

            if(name.isEmpty() || name.isBlank()){
                binding.tilName.error = getString(R.string.error_required)
            }else{
                sharedPreferences.edit().putString("username" , name).apply()
                val intent = Intent(this , GameActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
    private fun getName(): String {
        return binding.etName.text.toString()
    }
}