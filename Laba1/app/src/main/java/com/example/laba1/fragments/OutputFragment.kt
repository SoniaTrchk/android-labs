package com.example.laba1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.laba1.R

class OutputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_output, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val selectedItems = arguments?.getString("selectedItems")
        val textView: TextView = view?.findViewById(R.id.textView) as TextView
        val btnClear: Button = view?.findViewById(R.id.btnClear) as Button

        textView.text = selectedItems

        btnClear.setOnClickListener {
            textView.text = ""
        }
    }

}