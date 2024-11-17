package com.example.week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week6.databinding.FragmentRankingBinding

class RankingFragment : Fragment() {

    private lateinit var binding: FragmentRankingBinding
    private lateinit var productRVAdapter: ProductRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRankingBinding.inflate(inflater, container, false)

        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        val products = listOf(
            Product("노스페이스", "NJ3NQ53A 남성 눕시 온볼 자켓_BLACK", R.drawable.product_1, "224,000원", "1.1천명이 보는 중"),
            Product("뉴발란스", "NBNPE4W102 / WOMEN 액티브 숏 구스다운 (6컬러)", R.drawable.product_2, "299,000원", "1.2천명이 보는 중"),
            Product("디스이즈내버댓", "PERTEX® T Down Jacket Black", R.drawable.product_3, "215,100원", "694명이 보는 중"),
            Product("노스페이스", "NC1DQ50J 화이트라벨 액션 프리 RDS 다운 코트_BLACK", R.drawable.product_4, "358,000원", "312명이 보는 중"),
            Product("나이키", "P-6000 M - 메탈릭 실버:세일:블랙:메탈릭 실버 / CN0149-001", R.drawable.product_5, "129,000원", "153명이 보는 중"),
            Product("라퍼지스토어", "유니온 빅 오버 패딩 파카_Midnight blue", R.drawable.product_6, "118,000원", "680명이 보는 중"),
            Product("아디다스", "핸드볼 스페지알 - 원더베이지:블랙 / IE3698", R.drawable.product_7, "113,000원", "532명이 보는 중"),
            Product("캑터스도넛마켓", "CDM Basic Logo Sweater - Black", R.drawable.product_8, "31,600원", "482명이 보는 중"),
            Product("내셔널지오그래픽", "N244UDW920 헤론 U넥 경량 다운 점퍼 CARBON BLACK", R.drawable.product_9, "149,000원", "197명이 보는 중"),
            Product("노스페이스", "NJ3NQ53A 남성 눕시 온볼 자켓_BLACK", R.drawable.product_1, "224,000원", "1.1천명이 보는 중"),
            Product("뉴발란스", "NBNPE4W102 / WOMEN 액티브 숏 구스다운 (6컬러)", R.drawable.product_2, "299,000원", "1.2천명이 보는 중"),
            Product("디스이즈내버댓", "PERTEX® T Down Jacket Black", R.drawable.product_3, "215,100원", "694명이 보는 중"),
            Product("노스페이스", "NC1DQ50J 화이트라벨 액션 프리 RDS 다운 코트_BLACK", R.drawable.product_4, "358,000원", "312명이 보는 중"),
            Product("나이키", "P-6000 M - 메탈릭 실버:세일:블랙:메탈릭 실버 / CN0149-001", R.drawable.product_5, "129,000원", "153명이 보는 중"),
            Product("라퍼지스토어", "유니온 빅 오버 패딩 파카_Midnight blue", R.drawable.product_6, "118,000원", "680명이 보는 중"),
            Product("아디다스", "핸드볼 스페지알 - 원더베이지:블랙 / IE3698", R.drawable.product_7, "113,000원", "532명이 보는 중"),
            Product("캑터스도넛마켓", "CDM Basic Logo Sweater - Black", R.drawable.product_8, "31,600원", "482명이 보는 중"),
            Product("내셔널지오그래픽", "N244UDW920 헤론 U넥 경량 다운 점퍼 CARBON BLACK", R.drawable.product_9, "149,000원", "197명이 보는 중")

        )

        productRVAdapter = ProductRVAdapter(products)
        binding.productRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 3) // 3열 레이아웃
            adapter = productRVAdapter
        }
    }
}
