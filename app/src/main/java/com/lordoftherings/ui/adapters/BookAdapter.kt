package com.lordoftherings.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lordoftherings.R
import com.lordoftherings.databinding.BookSingleBinding
import com.lordoftherings.models.BookPresentation

class BookAdapter : PagingDataAdapter<BookPresentation, BookAdapter.BookViewHolder>(DiffUtilCallback()) {
    class BookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = BookSingleBinding.bind(itemView)

        fun setData(bookPresentation: BookPresentation) {
            Glide.with(itemView.context)
                .load(bookPresentation.image)
                .into(binding.bookImage)
            binding.bookName.text = bookPresentation.name
        }
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        book?.let { holder.setData(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.book_single, parent, false)
        return BookViewHolder(inflater)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<BookPresentation>() {
        override fun areItemsTheSame(oldItem: BookPresentation, newItem: BookPresentation): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BookPresentation, newItem: BookPresentation): Boolean {
            return oldItem.name == newItem.name
        }
    }

}