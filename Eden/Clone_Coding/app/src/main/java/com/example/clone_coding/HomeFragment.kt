package com.example.clone_coding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.clone_coding.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())
    private var albumDatas = ArrayList<Album>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //ViewPager2 어댑터 설정
        val panelAdapter = PannerVPAdapter(this)
        binding.homePannelBackgroundVp.adapter = panelAdapter
        //ViewPager2와 인디케이터 연결
        binding.homePannelBackgroundIndi.setViewPager(binding.homePannelBackgroundVp)
        //자동 전환
        startAutoSlide(panelAdapter)

//        //특정 정보를 담을 AlbumFragment을 생성
//        var lilacFragment = AlbumFragment()
//        //bundle 이용해 정보 전달
//        var lilacBundle = Bundle()
//        lilacBundle.putString("albumTitle", "IU 5th Album 'LILAC'")
//        lilacBundle.putString("singer", "IU")
//        lilacBundle.putString("info", "2021.03.25 | 정규 | 댄스 팝")
//        lilacBundle.putInt("img", R.drawable.img_album_exp2)
//        lilacFragment.arguments = lilacBundle
//
//        var butterFragment = AlbumFragment()
//
//        var butterBundle = Bundle()
//        butterBundle.putString("albumTitle", "Butter (feat. Megan Thee Stallion)")
//        butterBundle.putString("singer", "방탄소년단")
//        butterBundle.putString("info", "2021.08.27 | 싱글 | 국내 댄스/일렉")
//        butterBundle.putInt("img", R.drawable.img_album_exp)
//        butterFragment.arguments = butterBundle

        //더미 데이터
        albumDatas.apply {
            add(Album("라일락", "아이유(IU)", R.drawable.img_album_exp2,
                ArrayList<Song>().apply{add(Song("라일락", "아이유", 0, 215, false, "music_lilac"))}, false))
            add(Album("엄", "헌준타워", R.drawable.img_album_phj,
                ArrayList<Song>().apply{add(Song("한 페이지가 될 수 있게", "두둥탁", 0, 206, false, "music_page"))}, false))
            add(Album("Next Level", "에스파", R.drawable.img_album_exp3,null,false))
            add(Album("Boy with Luv", "방탄소년단(BTS)", R.drawable.img_album_exp4,null,false))
            add(Album("Weekend", "태연", R.drawable.img_album_exp6,null,false))
        }

        var albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        albumRVAdapter.setMyItemClickListener(object:AlbumRVAdapter.MyItemClickListener{
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }

            override fun onPlayClick(album: Album) {
                playAlbum(album)
            }
        })

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))    //이미지 리소스 id값 넘기기
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }

    private fun playAlbum(album: Album) {
        val mainActivity = requireActivity() as MainActivity

        mainActivity.setNewSong(album.songs?.get(0) ?: Song("Unknown", "Unknown Artist"))
        mainActivity.setAlbumcover(album.coverimg!!)
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

    private fun startAutoSlide(adapter : PannerVPAdapter){
        //3초마다 전환
        timer.scheduleAtFixedRate(3000, 3000){
            handler.post{
                val nextItem = binding.homePannelBackgroundVp.currentItem + 1
                if(nextItem < adapter.itemCount ){
                    //다음 페이지 있을 경우
                    binding.homePannelBackgroundVp.currentItem = nextItem
                }
                else{
                    //마지막 페이지일 경우 첫 페이지로
                    binding.homePannelBackgroundVp.currentItem = 0
                }
            }
        }

    }
}