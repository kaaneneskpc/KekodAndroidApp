package com.kaaneneskpc.recyclerviewfeatures

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaaneneskpc.R
import com.kaaneneskpc.databinding.ActivityRecyclerViewFeaturesBinding
import com.kaaneneskpc.recyclerviewfeatures.adapter.TeamListAdapter
import com.kaaneneskpc.recyclerviewfeatures.model.TeamModel
import com.kaaneneskpc.recyclerviewfeatures.model.TeamType

class RecyclerViewFeatures : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewFeaturesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewFeaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val teamList = listOf(
            TeamModel("Turkish Team", TeamType.HEADER),
            TeamModel("Galatasaray", TeamType.ITEM),
            TeamModel("Fenerbahçe", TeamType.ITEM),
            TeamModel("Sivasspor", TeamType.ITEM),
            TeamModel("Trabzonspor", TeamType.ITEM),
            TeamModel("Foreign Team", TeamType.HEADER),
            TeamModel("Real Madrid", TeamType.ITEM),
            TeamModel("Liverpool", TeamType.ITEM),
            TeamModel("Chelsea", TeamType.ITEM),
            TeamModel("Arsenal", TeamType.ITEM),
        )
        val teamListAdapter = TeamListAdapter(teamList) {
             Toast.makeText(this, "Clicked: ${it.teamName}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.apply {
            adapter = teamListAdapter
            layoutManager = LinearLayoutManager(this@RecyclerViewFeatures)
        }
    }
}

//Recylerview vs Listview
//Recyclerview ekrandaki var olan itemlara göre yükleme yapıyor listview en başta hepsini yüklemeye çalışıyor.
//Layout manager, item decoration, touch helper, swipe yapılabiliyor rv de listview de yok.

