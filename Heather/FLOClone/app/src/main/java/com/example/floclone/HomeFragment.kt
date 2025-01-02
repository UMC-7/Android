package com.example.floclone

import android.content.Context
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var handler: Handler
    lateinit var runnable: Runnable
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        binding.homeAlbumImgIv1.setOnClickListener {
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, AlbumFragment()).commitAllowingStateLoss()
//        }

        // 데이터 리스트 생성 더미 데이터
//        albumDatas.apply {
//            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
//            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
//            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
//            add(Album("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
//            add(Album("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
//            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
//        }

        // 노래 목록이 있어야 그 중 첫 번째 곡을 재생할 수 있기 때문에 songs 배열 추가
        albumDatas.apply {
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp,
                songs = arrayListOf(
                    Song("Butter", "방탄소년단 (BTS)", 0, 180, false, "butter"),
                    Song("Butter(Hotter Remix)", "방탄소년단 (BTS)", 0, 180, false, "butterHotter")
                )
            ))
            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2,
                songs = arrayListOf(
                    Song("Lilac", "아이유 (IU)", 0, 180, false, "lilac"),
                    Song("Flu", "아이유 (IU)", 0, 180, false, "flu")
                )
            ))
            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3,
                songs = arrayListOf(
                    Song("Next Level", "에스파 (AESPA)", 0, 180, false, "nextlevel"),
                    Song("Black Mamba", "에스파 (AESPA)", 0, 180, false, "blackmamba")
                )
            ))
            add(Album("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4,
                songs = arrayListOf(
                    Song("Boy with Luv", "방탄소년단 (BTS)", 0, 180, false, "boywithluv"),
                    Song("Dynamite", "방탄소년단 (BTS)", 0, 180, false, "dynamite")
                )
            ))
            add(Album("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5,
                songs = arrayListOf(
                    Song("BBoom BBoom", "모모랜드 (MOMOLAND)", 0, 180, false, "bboombboom"),
                    Song("BAAM", "모모랜드 (MOMOLAND)", 0, 180, false, "baam")
                )
            ))
            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6,
                songs = arrayListOf(
                    Song("Weekend", "태연 (Tae Yeon)", 0, 180, false, "weekend"),
                    Song("Rain", "태연 (Tae Yeon)", 0, 180, false, "rain")
                )
            ))
        }

        // 레이아웃 매니저 설정
        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        albumRVAdapter.setMyItemClickListener(object: AlbumRVAdapter.MyItemClickListener {
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }

            override fun onPlayAlbum(album: Album) {
                // 앨범의 첫 번째 곡 가져옴
                album.songs?.let { songs ->
                    if (songs.isNotEmpty()) {
                        val firstSong = songs[0]

                        // SharedPreferences로 노래 정보 저장
                        val sharedPreferences = requireActivity().getSharedPreferences("song", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()

                        // Song 객체를 JSON으로 변환
                        val gson = Gson()
                        val songJson = gson.toJson(firstSong)

                        editor.putString("songData", songJson)
                        editor.apply()
                    }
                }
            }
        })

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

}