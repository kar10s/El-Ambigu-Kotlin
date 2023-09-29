package org.carlosrp.elambigukotlin.ui.newspaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.carlosrp.elambigukotlin.databinding.FragmentNewspaperBinding
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.ABC
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.As
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.BBCMundo
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.ElConfidencial
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.ElEspanol
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.ElImparcial
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.ElIndependiente
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.ElMundo
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.EuropaPress
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.LaRazon
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.LibertadDigital
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.OkDiario
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.PeriodistaDigital
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.VozPopuli
import org.carlosrp.elambigukotlin.domain.model.NewspaperModel
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
        newspaperAdapter = NewspaperAdapter(onItemSelected = {
            val type = when(it){
                ABC -> NewspaperModel.ABC
                ElEspanol -> NewspaperModel.Elespanol
                ElImparcial -> NewspaperModel.Elimparcial
                ElIndependiente -> NewspaperModel.Elindependiente
                ElMundo -> NewspaperModel.Elmundo
                LaRazon -> NewspaperModel.Larazon
                OkDiario -> NewspaperModel.Okdiario
                As -> NewspaperModel.As
                BBCMundo -> NewspaperModel.BBCMundo
                ElConfidencial -> NewspaperModel.ElConfidencial
                EuropaPress -> NewspaperModel.EuropaPress
                LibertadDigital -> NewspaperModel.LibertadDigital
                PeriodistaDigital -> NewspaperModel.PeriodistaDigital
                VozPopuli -> NewspaperModel.VozPopuli
            }

            findNavController().navigate(
                NewspaperFragmentDirections.actionNewspaperFragmentToNewspaperDetailActivity(type=type)
            )

            Toast.makeText(context,getString(it.name),Toast.LENGTH_SHORT).show()
        })
        binding.rvPediodicos.apply {
            layoutManager = LinearLayoutManager(context)
            //layoutManager = GridLayoutManager(context,2)
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