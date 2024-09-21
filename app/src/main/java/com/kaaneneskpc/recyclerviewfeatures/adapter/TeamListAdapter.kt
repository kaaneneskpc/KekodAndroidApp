package com.kaaneneskpc.recyclerviewfeatures.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kaaneneskpc.R
import com.kaaneneskpc.databinding.ItemLayoutTeamListBinding
import com.kaaneneskpc.databinding.ItemLayoutTeamTypeHeaderBinding
import com.kaaneneskpc.recyclerviewfeatures.model.TeamModel
import com.kaaneneskpc.recyclerviewfeatures.model.TeamType

class TeamListAdapter(
    private val teamList: List<TeamModel>,
    private val onClickListener: (TeamModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return teamList[position].teamType.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TeamType.HEADER.type -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutTeamTypeHeaderBinding.inflate(inflater, parent, false)
                TeamTypeHeaderViewHolder(binding)
            }

            TeamType.ITEM.type -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutTeamListBinding.inflate(inflater, parent, false)
                TeamListViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TeamTypeHeaderViewHolder -> {
                holder.bind(teamList[position])
            }

            is TeamListViewHolder -> {
                holder.bind(teamList[position], onClickListener)
            }

            else -> throw IllegalArgumentException("Invalid view holder")
        }
    }

    override fun getItemCount() = teamList.size

    inner class TeamListViewHolder(private val binding: ItemLayoutTeamListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(teamModel: TeamModel, onClickListener: (TeamModel) -> Unit) {
            binding.tvTeamName.text = teamModel.teamName
            binding.root.setOnClickListener {
                onClickListener(teamModel)
            }
        }
    }

    inner class TeamTypeHeaderViewHolder(private val binding: ItemLayoutTeamTypeHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(teamModel: TeamModel) {
            binding.tvTeamTypeHeader.text = teamModel.teamName
        }
    }
}