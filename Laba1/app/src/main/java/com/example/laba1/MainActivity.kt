package com.example.laba1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoText:TextView = findViewById(R.id.selectedInfo)
        val selectCompany:RadioGroup = findViewById(R.id.companiesNames)
        val selectProduct:RadioGroup = findViewById(R.id.productTypes)
        val btnOk:Button = findViewById(R.id.btnOk)
        val btnCancel:Button = findViewById(R.id.btnCancel)

         btnOk.setOnClickListener {
             if (selectCompany.checkedRadioButtonId != -1 && selectProduct.checkedRadioButtonId != -1){
                 val selectedCompanyId:Int = selectCompany.checkedRadioButtonId
                 val selectedCompany:RadioButton = findViewById(selectedCompanyId)
                 val selectedProductId:Int = selectProduct.checkedRadioButtonId
                 val selectedProduct:RadioButton = findViewById(selectedProductId)
                 infoText.text = "Company: " + selectedCompany.text +
                         "\nProduct type: " + selectedProduct.text
             }else{
                 Toast.makeText(
                     applicationContext,
                     "Company name and product type must be selected",Toast.LENGTH_LONG)
                     .show();
             }
         }

        btnCancel.setOnClickListener {
            selectCompany.clearCheck()
            selectProduct.clearCheck()
            infoText.text = "Select company name and product type."
        }

    }
}