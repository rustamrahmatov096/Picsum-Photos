package com.example.picsumphotos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.picsumphotos.databinding.ItemListBinding
import com.example.picsumphotos.models.ListDataItem
import com.example.picsumphotos.room.AppDatabase
import com.example.picsumphotos.room.Photo
import com.example.picsumphotos.utils.loadImage

class ListPagingAdapter : PagingDataAdapter<ListDataItem, ListPagingAdapter.Vh>(MyDiffUtil()) {


    class MyDiffUtil : DiffUtil.ItemCallback<ListDataItem>() {
        override fun areItemsTheSame(oldItem: ListDataItem, newItem: ListDataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ListDataItem, newItem: ListDataItem): Boolean {
            return oldItem == newItem
        }

    }

    inner class Vh(private var itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind(listDataItem: ListDataItem) {

            itemListBinding.imageView.loadImage(listDataItem.download_url)
        }
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

}
