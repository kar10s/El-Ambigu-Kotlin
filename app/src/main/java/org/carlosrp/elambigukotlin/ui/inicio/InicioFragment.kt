package org.carlosrp.elambigukotlin.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.carlosrp.elambigukotlin.databinding.FragmentInicioBinding

@AndroidEntryPoint
class InicioFragment : Fragment() {
    private var _binding:FragmentInicioBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}