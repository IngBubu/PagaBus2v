package com.example.pagabus2v.ui.SobreNosotros

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagabus2v.R

class SobreNosotrosFragment : Fragment() {

    companion object {
        fun newInstance() = SobreNosotrosFragment()
    }

    private lateinit var viewModel: SobreNosotrosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sobre_nosotros, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SobreNosotrosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}