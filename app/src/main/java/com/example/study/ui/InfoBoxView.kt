package com.example.study.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.study.R
import com.example.study.databinding.ItemMenuBinding
import com.example.study.databinding.ItemMenuMainBinding
import com.example.study.util.Event

class InfoBoxView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    var binding: ItemMenuMainBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.item_menu_main, this, false
    )

    init {
        addView(binding.root)
        val attr =
            context.obtainStyledAttributes(attributeSet, R.styleable.InfoBoxView, defStyleAttr, 0)
        binding.tvTitle.text = attr.getString(R.styleable.InfoBoxView_title)
        attr.recycle()
    }

    fun setMenuList(viewModel: TravelViewModel) {
        viewModel.menuList.let {
            var id: Int? = null
            viewModel.menuList.forEachIndexed { index, it ->
                val menuBinding =
                    ItemMenuBinding.inflate(LayoutInflater.from(context), this, false).apply {
                        tvMenu.text = it
                        root.id = View.generateViewId()
                    }
                (menuBinding.root.layoutParams as LayoutParams).let {
                    if(id == null) {
                        it.topToBottom = binding.tvTitle.id
                        it.startToStart = binding.tvTitle.id
                        it.endToEnd = binding.tvTitle.id
                    } else {
                        it.topToBottom = id as Int
                        it.startToStart = id as Int
                        it.endToEnd = id as Int
                    }
                }
                if(index == viewModel.menuList.lastIndex) {
                    menuBinding.root.setPadding(0,0,0,15)
                }
                menuBinding.root.setOnClickListener {
                    viewModel.liveDataList[index].value = Event(Unit)
                }

                binding.parentLayout.addView(menuBinding.root)
                id = menuBinding.root.id
            }
        }
    }

}
