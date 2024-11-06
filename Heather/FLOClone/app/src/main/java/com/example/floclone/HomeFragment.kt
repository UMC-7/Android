package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.floclone.databinding.FragmentHomeBinding
import me.relex.circleindicator.CircleIndicator3
import android.os.Handler
import android.os.Looper

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var handler: Handler
    lateinit var runnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImgIv1.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, AlbumFragment()).commitAllowingStateLoss()
        }

        // ViewPager 설정
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val panelAdpater = PanelVPAdapter(this)
        panelAdpater.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdpater.addFragment(PanelFragment(R.drawable.img_first_album_default))
        binding.homePanelBackgroundVp.adapter = panelAdpater
        binding.homePanelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Indicator 설정
        val indicator: CircleIndicator3 = binding.homePanelIndicator
        indicator.setViewPager(binding.homeBannerVp)

        // 자동 슬라이드 구현
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                if (binding.homePanelBackgroundVp.currentItem == bannerAdapter.itemCount - 1) {
                    binding.homePanelBackgroundVp.currentItem = 0
                } else {
                    binding.homePanelBackgroundVp.currentItem = binding.homePanelBackgroundVp.currentItem + 1
                }
                handler.postDelayed(this, 3000) // 3초마다 슬라이드
            }
        }
        handler.postDelayed(runnable, 3000) // 최초 실행


        return binding.root
    }

}