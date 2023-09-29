package org.carlosrp.elambigukotlin.domain.model

import org.carlosrp.elambigukotlin.R

sealed class NewspaperInfo(val img:Int,val name:Int){
    data object ABC:NewspaperInfo(R.drawable.abc50,R.string.abc)
    data object ElEspanol:NewspaperInfo(R.drawable.elespanol50,R.string.elespanol)
    data object ElImparcial:NewspaperInfo(R.drawable.elimparcial50,R.string.elimparcial)
    data object ElIndependiente:NewspaperInfo(R.drawable.elindependiente50,R.string.elindependiente)
    data object LaRazon:NewspaperInfo(R.drawable.larazon50,R.string.larazon)
    data object OkDiario:NewspaperInfo(R.drawable.okdiario50,R.string.okdiario)
    data object ElMundo:NewspaperInfo(R.drawable.elmundo50,R.string.elmundo)
    data object As:NewspaperInfo(R.drawable.as50,R.string.`as`)
    data object ElConfidencial:NewspaperInfo(R.drawable.elconfidencial50,R.string.elconfidencial)
    data object EuropaPress:NewspaperInfo(R.drawable.europapress50,R.string.europapress)
    data object LibertadDigital:NewspaperInfo(R.drawable.libertaddigital50,R.string.libertaddigital)
    data object BBCMundo:NewspaperInfo(R.drawable.bbcmundo50,R.string.bbcmundo)
    data object PeriodistaDigital:NewspaperInfo(R.drawable.periodistadigital50,R.string.periodistadigital)
    data object VozPopuli:NewspaperInfo(R.drawable.vozpopuli50,R.string.vozpopuli)


}