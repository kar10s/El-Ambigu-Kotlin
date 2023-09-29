package org.carlosrp.elambigukotlin.ui.newspaper

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.carlosrp.elambigukotlin.data.providers.NewspaperProvider
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo
import javax.inject.Inject

@HiltViewModel
class NewspaperViewModel @Inject constructor(newspaperProvider: NewspaperProvider): ViewModel() {

    private var _periodicos = MutableStateFlow<List<NewspaperInfo>>(emptyList())
    val periodicos:StateFlow<List<NewspaperInfo>> = _periodicos

    init {
        _periodicos.value = newspaperProvider.getNewspaper()
    }

}