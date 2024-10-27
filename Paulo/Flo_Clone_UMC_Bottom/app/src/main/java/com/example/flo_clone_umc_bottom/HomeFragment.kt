package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator2
import com.example.flo_clone_umc_bottom.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImgIv1.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("ALBUM_IMAGE", R.drawable.img_album_exp2)
            bundle.putString("ALBUM_TITLE", "LILAC")
            bundle.putString("ALBUM_ARTIST", "아이유 (IU)")
            val fragment = AlbumFragment()
            fragment.arguments = bundle

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, fragment)
                .commitAllowingStateLoss()
        }

        binding.homeAlbumImgIv2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("ALBUM_IMAGE", R.drawable.img_album_exp1)
            bundle.putString("ALBUM_TITLE", "My NINJAS")
            bundle.putString("ALBUM_ARTIST", "플리키뱅")
            val fragment = AlbumFragment()
            fragment.arguments = bundle

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, fragment)
                .commitAllowingStateLoss()
        }

        binding.homeAlbumImgIv3.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("ALBUM_IMAGE", R.drawable.img_album_exp)
            bundle.putString("ALBUM_TITLE", "Butter")
            bundle.putString("ALBUM_ARTIST", "BTS")
            val fragment = AlbumFragment()
            fragment.arguments = bundle

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, fragment)
                .commitAllowingStateLoss()
        }


//        binding.homeAlbumImgIv1.setOnClickListener {
//            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
//        }

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val homeBannerAdapter = HomeBannerVPAdapter(this)
        homeBannerAdapter.addFragment(BannerFragment(R.drawable.img_first_album_default))
        homeBannerAdapter.addFragment(BannerFragment(R.drawable.img_first_album_default))
        homeBannerAdapter.addFragment(BannerFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundIv.adapter = homeBannerAdapter
        binding.homePannelBackgroundIv.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.homeCircleCi.setViewPager(binding.homePannelBackgroundIv)

        return binding.root
    }
}