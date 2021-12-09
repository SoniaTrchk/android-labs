package com.example.laba1.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.laba1.R
import java.lang.ClassCastException

class InputFragment : Fragment() {

    private lateinit var onTextSentListener: OnTextSent

    interface OnTextSent {
        fun sendData(
            selectedItems: String,
            companyIsSelected: Boolean,
            productIsSelected: Boolean
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onTextSentListener = context as OnTextSent
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement onTextSent"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val selectCompany:RadioGroup = view?.findViewById(R.id.companiesNames) as RadioGroup
        val selectProduct:RadioGroup = view?.findViewById(R.id.productTypes) as RadioGroup
        val btnOk:Button = view?.findViewById(R.id.btnOk) as Button
        val btnCancel:Button = view?.findViewById(R.id.btnCancel) as Button

        var selectedItems:String = ""
        var companyIsSelected = false
        var productIsSelected = false

        btnOk.setOnClickListener {

            if (selectCompany.checkedRadioButtonId != -1 && selectProduct.checkedRadioButtonId != -1) {
                val selectedCompanyId: Int = selectCompany.checkedRadioButtonId
                val selectedCompany: RadioButton = view?.findViewById(selectedCompanyId) as RadioButton
                val selectedProductId: Int = selectProduct.checkedRadioButtonId
                val selectedProduct: RadioButton = view?.findViewById(selectedProductId) as RadioButton
                companyIsSelected = true
                productIsSelected = true
                selectedItems = "Company: " + selectedCompany.text as String? +
                        "\nProduct type: " + selectedProduct.text as String?
            }
            passData(
                selectedItems, companyIsSelected, productIsSelected
            )
        }

        btnCancel.setOnClickListener {
            selectCompany.clearCheck()
            selectProduct.clearCheck()
        }
    }

    private fun passData(
        selectedItems: String,
        companyIsSelected: Boolean,
        productIsSelected: Boolean
    ) {
        onTextSentListener.sendData(
            selectedItems, companyIsSelected, productIsSelected
        )
    }

}