package org.carlosrp.elambigukotlin.data.providers

import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo.*

import javax.inject.Inject

class NewspaperProvider @Inject constructor() {
    fun getNewspaper():List<NewspaperInfo>{
        return listOf(
            ABC,
            ElMundo,
            ElImparcial,
            OkDiario,
            ElEspanol,
            LaRazon,
            ElIndependiente,
            As,
            ElConfidencial,
            EuropaPress,
            LibertadDigital,
            BBCMundo,
            PeriodistaDigital,
            VozPopuli
        )
    }
}