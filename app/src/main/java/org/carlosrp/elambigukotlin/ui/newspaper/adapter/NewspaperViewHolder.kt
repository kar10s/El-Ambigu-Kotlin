package org.carlosrp.elambigukotlin.ui.newspaper.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.carlosrp.elambigukotlin.databinding.ItemNewspaperBinding
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo

class NewspaperViewHolder (view: View):RecyclerView.ViewHolder(view){

    private val binding = ItemNewspaperBinding.bind(view)
    fun render(newspaperInfo: NewspaperInfo){
        val context = binding.tvNombrePeriodico.context
        binding.ivLogoPortada.setImageResource(newspaperInfo.img)
        binding.tvNombrePeriodico.text = context.getString(newspaperInfo.name)

    }
}