package com.kaaneneskpc.manuelpagination

import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kaaneneskpc.manuelpagination.adapter.ProductListAdapter
import com.kaaneneskpc.manuelpagination.databinding.ActivityManuelPaginationBinding

class ManuelPaginationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManuelPaginationBinding
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
        val productList = getProductList()
        val productListAdapter = ProductListAdapter(productList)
        binding.apply {
            rvProducts.adapter = productListAdapter
            Handler(mainLooper).postDelayed({
                productListAdapter.showLoading()
            }, 5000)

            Handler(mainLooper).postDelayed({
                productListAdapter.hideLoading()
            }, 7000)


        }
    }

    private fun getProductList(): MutableList<String> {
        val productList = mutableListOf<String>()
        repeat(20) {
            productList.add("Product ${it+1}")
        }
        return productList
    }
}

// Pagination yapmamız bizim için memory management açısından daha iyi olacaktır.
// Aynı zamanda be'ye gereksiz istek çıkmasını engelleyerek büyük çaplı projelerde servis trafiğini azaltmaya ve
// performansı artırmaya yardımcı olacaktır.(Örnek kredi kartı ekstresindeki harcamalar)

// Pagination liste size'nın memorydeki yeri ile ilgilidir.
// Ekrandaki item sayısı +2 -2 mantığı rv'nin kendi içindeki item sayısını belirler.