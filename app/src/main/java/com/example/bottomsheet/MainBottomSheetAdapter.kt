package com.example.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.MainCherryItemBinding

class MainBottomSheetAdapter : RecyclerView.Adapter<MainBottomSheetAdapter.MainViewHolder>(){
    var data = mutableListOf<CherryData>()

    class MainViewHolder(private val binding : MainCherryItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(testData : CherryData){
            binding.mainUserName.text = testData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : MainCherryItemBinding = MainCherryItemBinding.inflate(layoutInflater,parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}