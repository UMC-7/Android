package com.example.umc7th_flo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.umc7th_flo.databinding.FragmentHomeBinding
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImgIv1.setOnClickListener {
            transferData(
                binding.homeAlbumTitleTv1.text.toString(),
                binding.homeAlbumSingerTv1.text.toString(),
                R.drawable.img_album_exp2
            )
        }

        binding.homeAlbumImgIv2.setOnClickListener {
            transferData(
                binding.homeAlbumTitleTv2.text.toString(),
                binding.homeAlbumSingerTv2.text.toString(),
                R.drawable.img_album_exp
            )
        }

        binding.homeAlbumImgIv3.setOnClickListener {
            transferData(
                binding.homeAlbumTitleTv3.text.toString(),
                binding.homeAlbumSingerTv3.text.toString(),
                R.drawable.img_album_exp3
            )
        }

        // 홈화면 배너 어댑터
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 홈화면 백 패널 어댑터
        val backpannelAdapter = BackpannelVPAdapter(this)
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        backpannelAdapter.addFragment(BackpannelFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = backpannelAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Indicator에 ViewPager 설정
        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)
        val topBannerAdapter = BackpannelVPAdapter(this)
        startAutoSlide(topBannerAdapter)

        return binding.root
    }

    // Fragment 전환하면서 데이터 전달
    fun transferData(title : String, singer : String, imageResId: Int) {
        val bundle = Bundle()

        bundle.putString("title", title)
        bundle.putString("singer", singer)
        bundle.putInt("imageResId", imageResId)

        val fragment = AlbumFragment()
        fragment.arguments = bundle

        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }

    // 백 패널 시간지나면 자동으로 이동
    private fun startAutoSlide(adapter: BackpannelVPAdapter){
        timer.scheduleAtFixedRate(3000, 3000) {
            handler.post{
                val nextItem = binding.homePannelBackgroundVp.currentItem + 1

                if(nextItem == 7)
                    binding.homePannelBackgroundVp.currentItem = 0
                else
                    binding.homePannelBackgroundVp.currentItem = nextItem
            }
        }
    }
}