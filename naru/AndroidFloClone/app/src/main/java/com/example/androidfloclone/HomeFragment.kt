package com.example.androidfloclone

import android.os.Bundle
import android.os.DeadObjectException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.androidfloclone.databinding.FragmentHomeBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var job: Job? = null // 자동 슬라이드 Job을 nullable로 변경
    private var albumDatas = ArrayList<Album>()  // 앨범 데이터를 저장할 ArrayList
    private lateinit var songDB: SongDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        songDB = SongDatabase.getInstance(requireContext())!!
        albumDatas.addAll(songDB.albumDao().getAlbums())

        inputDummyAlbums()

        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
/*
        // 앨범 아이템 클릭 리스너 설정
        albumRVAdapter.setMyItemCLickListener(object: AlbumRVAdapter.MyItemClickListener {
            // 앨범 아이템 클릭 시 AlbunFragment로 데이터 전달
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }
            // 앨범 재생 아이콘 클릭 시 미니 플레이어 업데이트
            override fun onPlayImgClick(album: Album) {
                changeMiniPlayer(album)
            }
            // 앨범 아이템 삭제
            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }
        })
*/

        // 배너 ViewPager 어댑터 설정
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp4))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp4))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 패널 ViewPager 어댑터 설정
        val panelAdapter = PanelVPAdapter(this)
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = panelAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 패널 뷰페이저와 인디케이터 연결
        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)

        return binding.root
    }

    private fun inputDummyAlbums() {
        val songDB = SongDatabase.getInstance(requireActivity())!!
        val songs = songDB.albumDao().getAlbums()

        if (songs.isNotEmpty()) return

        songDB.albumDao().insert(
            Album(1, "The Volunteers", "The Volunteers (더 발룬티어스)", R.drawable.img_album_exp2)
        )
        songDB.albumDao().insert(
            Album(2, "OO-LI", "WOODZ", R.drawable.img_album_exp4)
        )
        songDB.albumDao().insert(
            Album(3,"SUPER REAL ME", "아일릿 (ILLIT)", R.drawable.img_album_exp5)
        )
        songDB.albumDao().insert(
            Album(4, "Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp)
        )
        songDB.albumDao().insert(
            Album(5, "Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3)
        )
        songDB.albumDao().insert(
            Album(6, "Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6)
        )
    }

/*
    // 앨범 클릭 시 AlbumFragment로 데이터 전달하는 메소드
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
    // 미니 플레이어를 선택한 앨범 정보로 업데이트하는 메소드
    private fun changeMiniPlayer(album: Album) {
        (context as MainActivity).updateMiniPlayer(album)
    }
*/

    // 자동 슬라이드 기능
    private fun startAutoScroll() {
        // 기존 job이 있으면 중단
        stopAutoScroll()

        job = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                delay(5000)
                val nextItem = (binding.homePannelBackgroundVp.currentItem + 1) %
                        (binding.homePannelBackgroundVp.adapter?.itemCount ?: 1)
                binding.homePannelBackgroundVp.setCurrentItem(nextItem, true)
            }
        }
    }

    private fun stopAutoScroll() {
        job?.cancel()
        job = null
    }

    override fun onResume() {
        super.onResume()
        startAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        stopAutoScroll()
    }
}
