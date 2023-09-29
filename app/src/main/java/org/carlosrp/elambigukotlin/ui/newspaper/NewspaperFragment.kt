package org.carlosrp.elambigukotlin.ui.newspaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.carlosrp.elambigukotlin.databinding.FragmentNewspaperBinding
import org.carlosrp.elambigukotlin.ui.newspaper.adapter.NewspaperAdapter

@AndroidEntryPoint
class NewspaperFragment : Fragment() {
    // conexion fragment a viewmodel
    private val newspaperViewModel by viewModels<NewspaperViewModel>()
    private lateinit var newspaperAdapter: NewspaperAdapter

    private var _binding: FragmentNewspaperBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewspaperBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initRecycler()
    }

    private fun initRecycler() {
        newspaperAdapter = NewspaperAdapter()
        binding.rvPediodicos.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newspaperAdapter
        }
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                newspaperViewModel.periodicos.collect {
                    newspaperAdapter.updateList(it)
                }
            }
        }
    }
}