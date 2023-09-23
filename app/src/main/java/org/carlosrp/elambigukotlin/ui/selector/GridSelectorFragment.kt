package org.carlosrp.elambigukotlin.ui.selector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import org.carlosrp.elambigukotlin.databinding.FragmentGridSelectorBinding
@AndroidEntryPoint
class GridSelectorFragment : Fragment() {
    private var _binding:FragmentGridSelectorBinding? = null
    private val binding  get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGridSelectorBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}