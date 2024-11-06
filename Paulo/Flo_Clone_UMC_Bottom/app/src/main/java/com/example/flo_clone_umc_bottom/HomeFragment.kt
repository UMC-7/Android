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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator2
import com.example.flo_clone_umc_bottom.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment() {

    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())
    lateinit var binding: FragmentHomeBinding
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        albumDatas.apply {
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(Album("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
            add(Album("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
        }
//        binding.homeAlbumImgIv1.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putInt("ALBUM_IMAGE", R.drawable.img_album_exp2)
//            bundle.putString("ALBUM_TITLE", "LILAC")
//            bundle.putString("ALBUM_ARTIST", "아이유 (IU)")
//            val fragment = AlbumFragment()
//            fragment.arguments = bundle
//
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, fragment)
//                .commitAllowingStateLoss()
//        }
//
//        binding.homeAlbumImgIv2.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putInt("ALBUM_IMAGE", R.drawable.img_album_exp1)
//            bundle.putString("ALBUM_TITLE", "My NINJAS")
//            bundle.putString("ALBUM_ARTIST", "플리키뱅")
//            val fragment = AlbumFragment()
//            fragment.arguments = bundle
//
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, fragment)
//                .commitAllowingStateLoss()
//        }
//
//        binding.homeAlbumImgIv3.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putInt("ALBUM_IMAGE", R.drawable.img_album_exp)
//            bundle.putString("ALBUM_TITLE", "Butter")
//            bundle.putString("ALBUM_ARTIST", "BTS")
//            val fragment = AlbumFragment()
//            fragment.arguments = bundle
//
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, fragment)
//                .commitAllowingStateLoss()
//        }


//        binding.homeAlbumImgIv1.setOnClickListener {
//            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
//        }

        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        albumRVAdapter.setMyItemClickListener(object: AlbumRVAdapter.MyItemClickListener{
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }
        })

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

    private fun changeAlbumFragment(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            })
            .commitAllowingStateLoss()
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