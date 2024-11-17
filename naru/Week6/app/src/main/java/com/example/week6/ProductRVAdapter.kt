package com.example.week6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week6.databinding.ItemProductBinding

class ProductRVAdapter(private val productList: List<Product>): RecyclerView.Adapter<ProductRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductRVAdapter.ViewHolder {
        val binding: ItemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductRVAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    inner class ViewHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.itemProductTv.text = product.name
            binding.itemBrandTv.text = product.brand
            binding.itemProductImgIv.setImageResource(product.productImg!!)
            binding.itemProductPriceTv.text = product.price
            binding.itemDescribeTv.text = product.describe
        }
    }
}