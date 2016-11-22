package com.example.sinigr.sharedactivityanimation

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.TransitionInflater
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

	var recyclerView: RecyclerView? = null
	var adapter: ItemRecyclerAdapter? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		recyclerView = findViewById(R.id.rvMain) as RecyclerView
		adapter = ItemRecyclerAdapter(this, object : ItemRecyclerAdapter.Callback {
			override fun onClick(item: ImageView?) {
				val intent: Intent = Intent(this@MainActivity, DetailedActivity::class.java)

				window.exitTransition = TransitionInflater.from(this@MainActivity)
						.inflateTransition(android.R.transition.explode)
				/*window.sharedElementReturnTransition = TransitionInflater.from(this@MainActivity)
						.inflateTransition(R.transition.change_image_transform)*/

				val options = ActivityOptionsCompat
						.makeSceneTransitionAnimation(this@MainActivity, item!!, "portrait")

				startActivity(intent, options.toBundle())
			}
		})
		adapter?.addAll(arrayListOf("John Doe", "John Doe", "John Doe", "John Doe", "John Doe",
				"John Doe"))
		recyclerView?.adapter = adapter
		val layoutManager = LinearLayoutManager(this)
		recyclerView?.layoutManager = layoutManager
		recyclerView?.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
	}
}
