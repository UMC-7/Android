package com.example.androidfloclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.androidfloclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImgIv1.setOnClickListener {
            val singer = binding.homeAlbumSingerTv.text.toString()
            val albumName = binding.homeAlbumNameTv.text.toString()

            val albumFragment = AlbumFragment().apply {
                arguments = Bundle().apply {
                    putString("singer", singer)
                    putString("albumName", albumName)
                }
            }

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm,albumFragment)
                .commitAllowingStateLoss()
        }

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp4))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp4))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        val pannelAdpater = PannelVPAdapter(this)
        pannelAdpater.addFragment(PannelFragment(R.drawable.img_first_album_default))
        pannelAdpater.addFragment(PannelFragment(R.drawable.img_first_album_default))
        pannelAdpater.addFragment(PannelFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = pannelAdpater
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        return binding.root
    }
}