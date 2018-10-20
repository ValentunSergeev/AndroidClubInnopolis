package com.valentun.learn.lessonrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.android.synthetic.main.list_item_2.*

class StringAdapter(private val data : List<String>) : RecyclerView.Adapter<StringAdapter.StringHolder>() {


    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int) = if (position % 2 == 0)
        R.layout.list_item else R.layout.list_item_2


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        return StringHolder(view)
    }

    override fun onBindViewHolder(holder: StringHolder, position: Int) {
       holder.bind(data[position])
    }

    class StringHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bind(item : String) {
            when(itemViewType) {
                R.layout.list_item -> bindItem1(item)
                R.layout.list_item_2 -> bindItem2(item)
            }
        }

        private fun bindItem1(item: String) {
            item_content.text = item
        }

        private fun bindItem2(item: String) {
            item_content_2.text = item
        }
    }
}