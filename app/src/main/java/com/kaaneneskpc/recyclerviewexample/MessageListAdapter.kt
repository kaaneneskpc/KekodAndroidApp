package com.kaaneneskpc.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaaneneskpc.R

class MessageListAdapter(
    private val messageList: List<MessageUIModel>,
    // private val onClickListener: (MessageModel) -> Unit
) :
    RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_message_list, parent, false)
        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(messageModel: MessageUIModel) {
            itemView.findViewById<ImageView>(R.id.imgIcon).setImageResource(messageModel.image)
            itemView.findViewById<TextView>(R.id.tvTitle).text = messageModel.title
            itemView.findViewById<TextView>(R.id.tvDescription).text = messageModel.description

            itemView.setOnClickListener {
                messageModel.onClickListener.invoke(messageModel)
            }
        }
    }
}