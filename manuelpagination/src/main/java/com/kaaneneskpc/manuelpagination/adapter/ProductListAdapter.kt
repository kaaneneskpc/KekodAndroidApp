package com.kaaneneskpc.manuelpagination.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaaneneskpc.manuelpagination.ViewType
import com.kaaneneskpc.manuelpagination.databinding.AdapterItemLoadingBinding
import com.kaaneneskpc.manuelpagination.databinding.AdapterItemProductBinding

class ProductListAdapter:
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val productList: ArrayList<String> = arrayListOf()
    var isLoadingAdded = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.PRODUCT_VIEW.ordinal -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = AdapterItemProductBinding.inflate(inflater, parent, false)
                ProductViewHolder(binding)
            }

            ViewType.LOADING.ordinal -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = AdapterItemLoadingBinding.inflate(inflater, parent, false)
                LoadingViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                holder.bind(productList[position])
            }

            is LoadingViewHolder -> {
                // Do nothing
            }

            else -> throw IllegalArgumentException("Invalid holder type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == productList.size && isLoadingAdded) ViewType.LOADING.ordinal else ViewType.PRODUCT_VIEW.ordinal
    }

    override fun getItemCount(): Int =
        if (isLoadingAdded) productList.size + 1 else productList.size

     fun addItems(newProductList: List<String>) {
        productList.addAll(newProductList)
        notifyItemInserted(productList.size)
    }

    fun showLoading() {
        isLoadingAdded = true
        notifyItemInserted(productList.size)
    }

    fun hideLoading() {
        isLoadingAdded = false
        notifyItemRemoved(productList.size)
    }

    inner class ProductViewHolder(private val binding: AdapterItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.tvProductName.text = item
        }
    }

    inner class LoadingViewHolder(private val binding: AdapterItemLoadingBinding) : RecyclerView.ViewHolder(binding.root)
}