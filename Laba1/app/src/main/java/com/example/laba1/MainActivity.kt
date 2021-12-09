package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.laba1.R
import com.example.laba1.fragments.InputFragment
import com.example.laba1.fragments.OutputFragment

class MainActivity : AppCompatActivity(), InputFragment.OnTextSent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, inputFragment)
            .commit()
    }

    override fun sendData(selectedItems: String, companyIsSelected: Boolean,
                          productIsSelected: Boolean) {
        val outputFragment = OutputFragment()
        val bundle = Bundle()

        if (companyIsSelected && productIsSelected){
            bundle.putString("selectedItems", selectedItems)
            outputFragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, outputFragment).addToBackStack(null).commit()
        }else{
            Toast.makeText(
                applicationContext,
                "Company name and product type must be selected",Toast.LENGTH_LONG)
                .show();
        }
    }
}