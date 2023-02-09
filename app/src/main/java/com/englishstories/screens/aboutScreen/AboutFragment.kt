package com.englishstories.screens.aboutScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.englishstories.R
import com.englishstories.databinding.FragmentAboutBinding
import com.englishstories.objects.GetObjects

class AboutFragment : Fragment() {
    private val binding by lazy { FragmentAboutBinding.inflate(layoutInflater) }
    private var counter: Float = 18f
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.tvBooknameAbout.text = GetObjects.chapterData.chaptorname
        binding.tvAboutChapter.text = GetObjects.chapterData.chapterabout



        binding.imgplus.setOnClickListener {
            counter++
            binding.tvAboutChapter.setTextSize(counter)
        }
        binding.imgMinus.setOnClickListener {
            counter--
            binding.tvAboutChapter.setTextSize(counter)
        }


        return binding.root
    }
}