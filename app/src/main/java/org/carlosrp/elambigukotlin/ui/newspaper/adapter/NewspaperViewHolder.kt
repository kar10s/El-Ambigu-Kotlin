package org.carlosrp.elambigukotlin.ui.newspaper.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import org.carlosrp.elambigukotlin.databinding.ItemNewspaperBinding
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo

class NewspaperViewHolder (view: View):RecyclerView.ViewHolder(view){

    private val binding = ItemNewspaperBinding.bind(view)
    fun render(newspaperInfo: NewspaperInfo, onItemSelected: (NewspaperInfo) -> Unit){
        val context = binding.tvNombrePeriodico.context
        binding.ivLogoPortada.setImageResource(newspaperInfo.img)
        binding.tvNombrePeriodico.text = context.getString(newspaperInfo.name)
        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivLogoPortada,newLambda={onItemSelected(newspaperInfo)})
 //           onItemSelected(newspaperInfo)
        }

    }

    private fun startRotationAnimation(view: View, newLambda:()->Unit){
        view.animate().apply {
            duration = 150
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {newLambda() }
            start()
        }


    }
}