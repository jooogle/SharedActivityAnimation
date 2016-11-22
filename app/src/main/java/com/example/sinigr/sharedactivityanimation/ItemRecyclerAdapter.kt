package com.example.sinigr.sharedactivityanimation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class ItemRecyclerAdapter(private val context: Context, private var callback: Callback) : RecyclerView.Adapter<ItemRecyclerAdapter.Companion.ItemViewHolder>() {
	interface Callback {
		fun onClick(item: ImageView?)
	}

	companion object {
		private var items: ArrayList<String> = ArrayList()

		class ItemViewHolder(view: View, private val callback: Callback) : RecyclerView.ViewHolder(view),
			View.OnClickListener {
			var tvName: TextView? = null

			init {
				tvName = view.findViewById(R.id.tvName) as TextView
				view.setOnClickListener(this)
			}

			override fun onClick(v: View?) {
				callback.onClick(itemView.findViewById(R.id.ivPortrait) as ImageView?)
			}
		}
	}

	fun addAll(items: List<String>) {
		ItemRecyclerAdapter.items.addAll(items)
	}

	override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
		holder?.tvName?.text = items[position]
	}

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
		val inflater = LayoutInflater.from(context)

		val view = inflater.inflate(R.layout.recycler_item, parent, false)
		return ItemViewHolder(view, callback)
	}

	override fun getItemCount(): Int = items.size
}