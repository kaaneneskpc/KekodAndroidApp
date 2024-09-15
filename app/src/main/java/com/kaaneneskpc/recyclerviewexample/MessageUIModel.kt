package com.kaaneneskpc.recyclerviewexample

data class MessageUIModel(
    val id:Int,
    val image:Int,
    val title:String,
    val description:String,
    val onClickListener: (MessageUIModel) -> Unit
)