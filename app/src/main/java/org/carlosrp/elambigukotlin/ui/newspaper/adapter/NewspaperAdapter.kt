package org.carlosrp.elambigukotlin.ui.newspaper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.carlosrp.elambigukotlin.R
import org.carlosrp.elambigukotlin.domain.model.NewspaperInfo

class NewspaperAdapter(private var newspaperInfoList: List<NewspaperInfo> = emptyList()):
    RecyclerView.Adapter<NewspaperViewHolder> (){

    fun updateList(list:List<NewspaperInfo>){
        newspaperInfoList = list
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewspaperViewHolder {
        return NewspaperViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_newspaper,parent,false)
        )
    }

    override fun getItemCount(): Int = newspaperInfoList.size
    override fun onBindViewHolder(holder: NewspaperViewHolder, position: Int) {
        holder.render(newspaperInfoList[position])
    }

}