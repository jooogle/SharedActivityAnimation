package com.example.sinigr.sharedactivityanimation

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class MainActivityFragment : Fragment() {

	private lateinit var recyclerView: RecyclerView
	private lateinit var adapter: ItemRecyclerAdapter

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater?.inflate(R.layout.activity_main_fragment, container, false)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		recyclerView = view?.findViewById(R.id.rvMain) as RecyclerView
		adapter = ItemRecyclerAdapter(activity, object : ItemRecyclerAdapter.Callback {
			override fun onClick(item: ImageView?) {
				val intent: Intent = Intent(activity, DetailedActivity::class.java)

				val options = ActivityOptionsCompat
						.makeSceneTransitionAnimation(activity, item!!, "portrait")

				ActivityCompat.startActivity(activity, intent, options.toBundle())
			}
		})
		adapter?.addAll(arrayListOf("John Doe", "John Doe", "John Doe", "John Doe", "John Doe",
				"John Doe"))
		recyclerView?.adapter = adapter
		val layoutManager = LinearLayoutManager(activity)
		recyclerView?.layoutManager = layoutManager
		recyclerView?.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
	}
}