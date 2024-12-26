package com.example.week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week6.databinding.FragmentProductBinding
import com.google.gson.Gson

class ProductFragment : Fragment() {
    lateinit var binding: FragmentProductBinding
    private var gson: Gson = Gson()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)

        val productJson = arguments?.getString("product")
        val product = gson.fromJson(productJson, Product::class.java)
        setInit(product)

        binding.backBtnIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }

    private fun setInit(product: Product) {
        binding.productNameTv.text = product.name
        binding.productBrandTv.text = product.brand
        binding.productImgIv.setImageResource(product.productImg!!)
        binding.productPriceTv.text = product.price
    }
}