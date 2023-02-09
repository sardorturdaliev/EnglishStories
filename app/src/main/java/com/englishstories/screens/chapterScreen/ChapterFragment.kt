package com.englishstories.screens.chapterScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.englishstories.R
import com.englishstories.databinding.FragmentChapterBinding
import com.englishstories.db.MyDadatabe
import com.englishstories.model.ChapterData
import com.englishstories.objects.GetObjects
import com.englishstories.screens.chapterScreen.adapter.ChapterAdapter


class ChapterFragment : Fragment(), ChapterAdapter.ClickItemListenerChapter {
    private val binding by lazy { FragmentChapterBinding.inflate(layoutInflater) }
    private lateinit var myDadatabe: MyDadatabe
    lateinit var chapterAdapter: ChapterAdapter

    //    private lateinit var chapterAdapter: ChapterAdapter
    private lateinit var arrayListChapter: ArrayList<ChapterData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        settingData()

        initData()



        return binding.root
    }


    private fun initData() {
        val arrayList = ArrayList<ChapterData>()
        myDadatabe = MyDadatabe.getInstance()
        arrayListChapter = myDadatabe.getChapters()

        Log.d("UUU", arrayListChapter.toString())

        for (i in arrayListChapter) {
            if (i.bookid?.id == GetObjects.bookData.id) {
                arrayList.add(i)
            }
        }

        arrayListChapter = arrayList
        chapterAdapter = ChapterAdapter(requireContext(), arrayListChapter, this)
        binding.rvChapter.adapter = chapterAdapter
        binding.rvChapter.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun settingData() {
        binding.tvBookName.text = GetObjects.bookData.bookName
    }

    override fun clickItem(chapterData: ChapterData) {
        GetObjects.chapterData = chapterData
        findNavController().navigate(R.id.aboutFragment)
    }


}