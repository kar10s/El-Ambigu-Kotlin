package org.carlosrp.elambigukotlin.ui.portada

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.carlosrp.elambigukotlin.databinding.FragmentPortadaBinding

class PortadaFragment : Fragment() {
    private var _binding:FragmentPortadaBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPortadaBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}