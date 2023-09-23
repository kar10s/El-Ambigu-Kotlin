package org.carlosrp.elambigukotlin.ui.newspaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.carlosrp.elambigukotlin.databinding.FragmentNewspaperBinding

@AndroidEntryPoint
class NewspaperFragment : Fragment() {
    private var _binding:FragmentNewspaperBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewspaperBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}