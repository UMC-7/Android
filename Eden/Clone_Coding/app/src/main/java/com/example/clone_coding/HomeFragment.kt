package com.example.clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.clone_coding.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //특정 정보를 담을 AlbumFragment을 생성
        var lilacFragment = AlbumFragment()
        //bundle 이용해 정보 전달
        var lilacBundle = Bundle()
        lilacBundle.putString("albumTitle", "IU 5th Album 'LILAC'")
        lilacBundle.putString("singer", "IU")
        lilacBundle.putString("info", "2021.03.25 | 정규 | 댄스 팝")
        lilacBundle.putInt("img", R.drawable.img_album_exp2)
        lilacFragment.arguments = lilacBundle

        //클릭한 엘범과 동일한 엘범이 나타나도록 전환
        binding.homeAlbumImgIv1.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm , lilacFragment)
                .commitAllowingStateLoss()
        }

        var butterFragment = AlbumFragment()

        var butterBundle = Bundle()
        butterBundle.putString("albumTitle", "Butter (feat. Megan Thee Stallion)")
        butterBundle.putString("singer", "방탄소년단")
        butterBundle.putString("info", "2021.08.27 | 싱글 | 국내 댄스/일렉")
        butterBundle.putInt("img", R.drawable.img_album_exp)
        butterFragment.arguments = butterBundle

        binding.homeAlbumImgIv2.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm , butterFragment)
                .commitAllowingStateLoss()
        }

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))    //이미지 리소스 id값 넘기기
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }
}