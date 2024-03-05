package com.example.pagabus2v.ui.BuscarRuta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pagabus2v.databinding.FragmentBuscarRutaBinding
class BuscarRutaFragment : Fragment() {

    private var _binding: FragmentBuscarRutaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val buscarRutaViewModel =
            ViewModelProvider(this).get(BuscarRutaViewModel::class.java)

        _binding = FragmentBuscarRutaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        buscarRutaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}