package com.kaaneneskpc.recyclerviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaaneneskpc.R

class RecyclerViewExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_example)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val messageList: ArrayList<MessageModel> = arrayListOf()

        repeat(20) { position ->
            val message = MessageModel(
                position + 1,
                R.drawable.baseline_message_24,
                "Message Title",
                "Message Description"
            )
            messageList.add(message)
        }

        val messageUIList: ArrayList<MessageUIModel> = messageList.map { model ->
            MessageUIModel(
                id = model.id,
                image = model.image,
                title = model.title,
                description = model.description,
                onClickListener = { messageModel ->
                    Toast.makeText(this, "Message ${messageModel.id} clicked", Toast.LENGTH_SHORT).show()
                }
            )
        } as ArrayList<MessageUIModel>

        val rvMessageList = findViewById<RecyclerView>(R.id.rvMessageList)
        rvMessageList.layoutManager = LinearLayoutManager(this)
        /* rvMessageList.adapter = MessageListAdapter(messageList) {
            Toast.makeText(this, "Message ${it.id} clicked", Toast.LENGTH_SHORT).show()
        } */
        rvMessageList.adapter = MessageListAdapter(messageUIList)


    }
}