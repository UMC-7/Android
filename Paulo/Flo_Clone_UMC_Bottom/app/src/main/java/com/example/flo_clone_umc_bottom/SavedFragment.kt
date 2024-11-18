package com.example.flo_clone_umc_bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flo_clone_umc_bottom.databinding.FragmentSavedBinding

class SavedFragment:Fragment() {
    lateinit var binding : FragmentSavedBinding
    private var savedDatas = ArrayList<LockerAlbum>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedBinding.inflate(inflater,container,false)

        savedDatas.apply{
            add(LockerAlbum("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(LockerAlbum("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(LockerAlbum("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(LockerAlbum("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
            add(LockerAlbum("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
            add(LockerAlbum("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
            add(LockerAlbum("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(LockerAlbum("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(LockerAlbum("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(LockerAlbum("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
            add(LockerAlbum("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
            add(LockerAlbum("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
            add(LockerAlbum("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(LockerAlbum("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(LockerAlbum("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(LockerAlbum("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
            add(LockerAlbum("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
            add(LockerAlbum("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
        }
        //6주차 locker에 recyclerView 내용 추가

        val lockerAlbumRVAdapter = LockerAlbumRVAdapter(savedDatas)
        binding.savedAlbumInfoRv.adapter = lockerAlbumRVAdapter
        binding.savedAlbumInfoRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        //6주차 recyclerView에 추가

        lockerAlbumRVAdapter.setMyItemClickListener(object: LockerAlbumRVAdapter.MyItemClickListener{
            override fun onRemoveAlbum(position: Int) {
                lockerAlbumRVAdapter.removeItem(position)
            }
        })
        //6주차 ... 누르면 없어지기

        return binding.root
    }
}