package com.example.study.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.study.R
import com.example.study.base.BaseFragment
import com.example.study.data.local.TravelEntity
import com.example.study.databinding.FragmentTravelListBinding
import com.example.study.databinding.ItemTravelLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TravelListFragment : BaseFragment<FragmentTravelListBinding>(
    layoutRes = R.layout.fragment_travel_list
) {

    private val mainViewModel: TestViewModel by activityViewModels() // 테스트
    private val travelViewModel: TravelViewModel by viewModels()
    private val travelAdapter: TravelAdapter by lazy { TravelAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = travelViewModel

        binding.rycTravel.adapter = travelAdapter

        travelViewModel.travelData.observe(
            viewLifecycleOwner,
            Observer {
                travelAdapter.submitList(it.item)
            }
        )
    }
}

class TravelAdapter :
    ListAdapter<TravelEntity, TravelAdapter.TravelViewHolder>(
        object : DiffUtil.ItemCallback<TravelEntity>() {
            override fun areItemsTheSame(
                oldItem: TravelEntity,
                newItem: TravelEntity
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: TravelEntity,
                newItem: TravelEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TravelAdapter.TravelViewHolder {
        return TravelViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_travel_location,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TravelAdapter.TravelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TravelViewHolder(private val binding: ItemTravelLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(travelData: TravelEntity) {
            binding.data = travelData
        }
    }
}
