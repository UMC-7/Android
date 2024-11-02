package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings.Global.putInt
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator2
import com.example.flo_clone_umc_bottom.databinding.FragmentHomeBinding
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment() {

    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())
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
        binding.homePannelBackgroundVp.adapter = homeBannerAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.homeCircleCi.setViewPager(binding.homePannelBackgroundVp)
        startAutoSlide(homeBannerAdapter)

        return binding.root
    }

    private fun startAutoSlide(adapter: HomeBannerVPAdapter) {
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                handler.post {
                    val nextItem = binding.homePannelBackgroundVp.currentItem + 1
                    if (nextItem < adapter.itemCount) {
                        binding.homePannelBackgroundVp.currentItem = nextItem
                    } else {
                        binding.homePannelBackgroundVp.currentItem = 0
                    }
                }
            }
        }, 3000, 3000)
    }

//    private fun startAutoSlide(adpater : BannerVPAdapter) {
//        // 일정 간격으로 슬라이드 변경 (3초마다)
//        timer.scheduleAtFixedRate(3000, 3000) {
//            handler.post {
//                val nextItem = binding.homePannelBackgroundVp.currentItem + 1
//                if (nextItem < adpater.itemCount) {
//                    binding.homePannelBackgroundVp.currentItem = nextItem
//                } else {
//                    binding.homePannelBackgroundVp.currentItem = 0 // 마지막 페이지에서 첫 페이지로 순환
//                }
//            }
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}