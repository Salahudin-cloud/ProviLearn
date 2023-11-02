package com.example.provilearn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.provilearn.data.Provinsi
import com.example.provilearn.databinding.CardListBinding

class ProvinceAdapter(private val listProvince: ArrayList<Provinsi>): RecyclerView.Adapter<ProvinceAdapter.ListViewHolder> () {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Provinsi)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(val binding : CardListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = CardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listProvince.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (  setLogoProvinsi, setNamaProvinsi ) = listProvince[position]
        //set logo provinsi
        Glide.with(holder.itemView.context)
            .load(setLogoProvinsi)
            .into(holder.binding.logoProvinsi)
        //set nama provinsi
        holder.binding.namaProvinsi.text =  setNamaProvinsi

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listProvince[holder.adapterPosition]) }
    }

}