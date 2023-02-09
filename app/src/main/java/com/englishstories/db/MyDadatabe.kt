package com.englishstories.db

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import com.englishstories.model.BookData
import com.englishstories.model.ChapterData

class MyDadatabe private constructor(context: Context) : CopyHelper(context, "chaptersbooks.db") {

    companion object {
        private var database: MyDadatabe? = null

        fun init(context: Context) {
            database = MyDadatabe(context)
        }

        fun getInstance(): MyDadatabe = database!!

        private const val CHAPTERID = "id"
        private const val CHAPTERTABLE = "chaptertable"
        private const val CHAPTERNAME_COL = "chaptorname"
        private const val CHAPTER_ABOUT_COL = "chaptorabout"

        private const val BOOKTABLE = "booktable"
        private const val BOOKNAME = "bookname"
        private const val IMG = "img"
        private const val BOOKID = "id"

    }


    //get Data from booktable

    fun getAllBooks(): Cursor {
        return getDatabase().rawQuery("select * from $BOOKTABLE", null)
    }


    fun getChapters(): ArrayList<ChapterData> {
        val arrayList = ArrayList<ChapterData>()
        val db = this.readableDatabase
        val query = "select * from $CHAPTERTABLE"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val chapterData = ChapterData(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    getBookId(cursor.getInt(3))
                )
                arrayList.add(chapterData)
            } while (cursor.moveToNext())
        }
        return arrayList
    }


    fun getBookId(id: Int): BookData {
        val db = this.readableDatabase
        var bookData = BookData()
        val cursor = db.query(
            "$BOOKTABLE",
            arrayOf(BOOKID, BOOKNAME, IMG),
            "id = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        if (cursor != null && cursor.moveToFirst()) {
            bookData = BookData(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            )
            cursor.close()
        }
        return bookData
    }

}