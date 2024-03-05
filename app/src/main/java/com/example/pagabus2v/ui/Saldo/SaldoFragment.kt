package com.example.pagabus2v.ui.Saldo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagabus2v.R

class SaldoFragment : Fragment() {

    companion object {
        fun newInstance() = SaldoFragment()
    }

    private lateinit var viewModel: SaldoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saldo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SaldoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}