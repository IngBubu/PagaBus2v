package com.example.pagabus2v.ui.Descuento

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagabus2v.R

class DescuentoFragment : Fragment() {

    companion object {
        fun newInstance() = DescuentoFragment()
    }

    private lateinit var viewModel: DescuentoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_descuento, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescuentoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}