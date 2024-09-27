package com.kaaneneskpc.manuelpagination

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaaneneskpc.manuelpagination.adapter.ProductListAdapter
import com.kaaneneskpc.manuelpagination.databinding.ActivityManuelPaginationBinding

class ManuelPaginationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManuelPaginationBinding
    var currentPage: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityManuelPaginationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dummyList = getProductList(currentPage)
        val productListAdapter = ProductListAdapter()
        binding.apply {
            rvProducts.adapter = productListAdapter
            productListAdapter.addItems(dummyList)
            rvProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as? LinearLayoutManager
                    val totalItemCount = layoutManager?.itemCount ?: 0
                    val lastVisibleItem = layoutManager?.findLastVisibleItemPosition() ?: 0
                    if (!productListAdapter.isLoadingAdded && totalItemCount <= (lastVisibleItem + 1)) {
                        currentPage++
                        productListAdapter.showLoading()

                        Handler(Looper.getMainLooper()).postDelayed({
                            val dummyProductList = getProductList(currentPage)
                            productListAdapter.addItems(dummyProductList)
                            productListAdapter.hideLoading()
                        }, 2000)
                    }
                }
            })
        }
    }

    private fun getProductList(page: Int): List<String> {
        val start = (page - 1) * PAGE_SIZE + 1
        val end = minOf(page * PAGE_SIZE, TOTAL_LIST_SIZE)
        return (start..end).map { "Product $it" }
    }

    companion object {
        private const val PAGE_SIZE = 20
        private const val TOTAL_LIST_SIZE = 100
    }
}

// Pagination yapmamız bizim için memory management açısından daha iyi olacaktır.
// Aynı zamanda be'ye gereksiz istek çıkmasını engelleyerek büyük çaplı projelerde servis trafiğini azaltmaya ve
// performansı artırmaya yardımcı olacaktır.(Örnek kredi kartı ekstresindeki harcamalar)

// Pagination liste size'nın memorydeki yeri ile ilgilidir.
// Ekrandaki item sayısı +2 -2 mantığı rv'nin kendi içindeki item sayısını belirler.