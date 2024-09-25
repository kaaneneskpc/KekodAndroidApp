package com.kaaneneskpc.manuelpagination

import android.os.Bundle
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
        binding.apply {
            rvProducts.adapter = ProductListAdapter(productList)
        }
    }

    private fun getProductList(): List<String> {
        val productList = mutableListOf<String>()
        repeat(100) {
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