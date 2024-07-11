package com.kaaneneskpc.kekodandroidexample.navigation.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.kaaneneskpc.kekodandroidexample.R

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr) {

    private var textViewTitle: TextView
    private var textViewDesc: TextView

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.view_some_custom, this, false)

        textViewTitle = findViewById(R.id.textViewTitle)
        textViewDesc = findViewById(R.id.textViewDesc)

        //Default values
        textViewTitle.text = "Custom View Title"
        textViewDesc.text =  "Custom View Description"

        // if you want to make it customizable with attrs
        attrs?.let {
            /* val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomView, 0 ,0)
            val title = typedArray.getString(R.styleable.CustomView_titleText)
            val description = typedArray.getString(R.styleable.CustomView_descText)

            title?.let { textViewTitle.text = it }
            description?.let { textViewDesc.text = it }

            typedArray.recycle() */
        }

        // val controller = findNavController()

    }

}