package com.englishstories.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.englishstories.databinding.CardItemBinding
import com.englishstories.model.BookData

class BookSetAdapter(var cursor: Cursor, val context: Context, val listener: ClickItemListener) :
    RecyclerView.Adapter<BookSetAdapter.Holder>() {

    inner class Holder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bookData: BookData) {
            Glide.with(context).load(bookData.img).into(binding.imgBook)

            itemView.setOnClickListener {
                listener.clickItem(bookData)
            }



        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    @SuppressLint("Range")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        cursor.moveToPosition(position)
        val data = BookData(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2)
        )
        holder.bind(data)
    }


    override fun getItemCount(): Int {
        return cursor.count
    }


    interface ClickItemListener {
        fun clickItem(bookData: BookData)
    }

}