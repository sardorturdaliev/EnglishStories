package com.englishstories.model

class BookData {
    var id: Int? = null
    var bookName: String? = null
    var img: String? = null

    constructor(id: Int?, bookName: String?, img: String?) {
        this.id = id
        this.bookName = bookName
        this.img = img
    }

    constructor( bookName: String?, img: String?) {
        this.bookName = bookName
        this.img = img
    }

    constructor()
}