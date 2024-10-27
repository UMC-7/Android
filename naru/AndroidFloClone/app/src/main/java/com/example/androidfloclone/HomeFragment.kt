package com.example.androidfloclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.androidfloclone.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private lateinit var job: Job // 자동 슬라이드

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 앨범 이미지 클릭 시 AlbumFragment로 이동하며 데이터 전달
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

        // 배너 ViewPager 어댑터 설정
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp4))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp4))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 패널 Viewpager 어댑터 설정
        val panelAdapter = PanelVPAdapter(this)
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = panelAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 패널 뷰페이저와 인디케이터 연결
        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)

        // 자동 슬라이드 시작
        startAutoScroll()

        return binding.root
    }

    // 자동 슬라이드 기능
    private fun startAutoScroll() {
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                delay(5000)
                val nextItem = (binding.homePannelBackgroundVp.currentItem + 1) %
                        (binding.homePannelBackgroundVp.adapter?.itemCount ?: 1)
                binding.homePannelBackgroundVp.setCurrentItem(nextItem, true)
            }
        }
    }

    // 프래그먼트가 파괴될 때 코루틴 작업 취소
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}