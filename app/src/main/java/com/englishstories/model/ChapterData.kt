package com.englishstories.model

class ChapterData {
    var id: Int? = null
    var chaptorname: String? = null
    var chapterabout: String? = null
    var bookid: BookData? = null


    constructor(id: Int?, chaptorname: String?, chapterabout: String?, bookid: BookData?)  {
        this.id = id
        this.chaptorname = chaptorname
        this.chapterabout = chapterabout
        this.bookid = bookid
    }
    constructor()
}
