package com.akaerlanda.recyclerviewsepakbola.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akaerlanda.recyclerview.databinding.ListItemPemainBinding
import com.akaerlanda.recyclerviewsepakbola.model.Pemain

class AdapterTeamBola (private val context : Context,
                       private var data : List<Pemain>?,
                       private val itemclick : OnClickListener)
              : RecyclerView.Adapter<AdapterTeamBola.viewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTeamBola.viewHolder {
        val binding = ListItemPemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  viewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterTeamBola.viewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
           itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class viewHolder(val binding : ListItemPemainBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama

    }
    interface OnClickListener {
        fun detailData(item : Pemain?)
    }


}