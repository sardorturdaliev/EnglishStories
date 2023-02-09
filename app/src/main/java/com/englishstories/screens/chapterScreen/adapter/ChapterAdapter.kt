package com.englishstories.screens.chapterScreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.englishstories.databinding.CardChapterItemBinding
import com.englishstories.model.ChapterData

class ChapterAdapter(
    val context: Context,
    val arrayList: ArrayList<ChapterData>,
    val listener: ClickItemListenerChapter
) :
    RecyclerView.Adapter<ChapterAdapter.Holder>() {
    inner class Holder(val binding: CardChapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onbind(chapterData: ChapterData) {
            binding.tvChapterstitle.text = chapterData.chaptorname


            itemView.setOnClickListener {
                listener.clickItem(chapterData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        CardChapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return arrayList.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.onbind(arrayList[position])
    }


    interface ClickItemListenerChapter {
        fun clickItem(chapterData: ChapterData)
    }

//    object diff : DiffUtil.ItemCallback<ChapterData>() {
//        override fun areItemsTheSame(oldItem: ChapterData, newItem: ChapterData): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: ChapterData, newItem: ChapterData): Boolean {
//            return oldItem == newItem
//        }
//
//    }
}