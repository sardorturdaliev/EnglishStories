package com.englishstories.screens.mainScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.englishstories.R
import com.englishstories.adapter.BookSetAdapter
import com.englishstories.databinding.FragmentMainBinding
import com.englishstories.db.MyDadatabe
import com.englishstories.model.BookData
import com.englishstories.objects.GetObjects


class MainFragment : Fragment(), BookSetAdapter.ClickItemListener {
    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private lateinit var database: MyDadatabe
    private lateinit var bookadapter: BookSetAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initData()




        return binding.root
    }

    private fun initData() {
        database = MyDadatabe.getInstance()
        val cursor = database.getAllBooks()
        bookadapter = BookSetAdapter(cursor, requireContext(), this)

        binding.rv.apply {
            adapter = bookadapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    override fun clickItem(bookData: BookData) {

        GetObjects.bookData = bookData
        findNavController().navigate(R.id.chapterFragment)
    }


}