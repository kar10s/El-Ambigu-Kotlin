package org.carlosrp.elambigukotlin.domain.model

import org.carlosrp.elambigukotlin.R

sealed class NewspaperInfo(val img:Int,val name:Int){
    object ABC:NewspaperInfo(R.drawable.abc50,R.string.abc)
    object ElEspanol:NewspaperInfo(R.drawable.elespanol50,R.string.elespanol)
    object ElImparcial:NewspaperInfo(R.drawable.elimparcial50,R.string.elimparcial)
    object ElIndependiente:NewspaperInfo(R.drawable.elindependiente50,R.string.elindependiente)
    object LaRazon:NewspaperInfo(R.drawable.larazon50,R.string.larazon)
    object OkDiario:NewspaperInfo(R.drawable.okdiario50,R.string.okdiario)
    object ElMundo:NewspaperInfo(R.drawable.elmundo50,R.string.elmundo)

}