package com.example.sinigr.sharedactivityanimation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.transition.TransitionInflater
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

			window.exitTransition = TransitionInflater.from(this@MainActivity)
					.inflateTransition(android.R.transition.explode)
			window.reenterTransition = TransitionInflater.from(this@MainActivity)
					.inflateTransition(android.R.transition.explode)

			window.exitTransition.excludeTarget(android.R.id.statusBarBackground, true)
			window.exitTransition.excludeTarget(android.R.id.navigationBarBackground, true)
			//window.exitTransition.excludeTarget(R.id.toolbar, true)

			window.reenterTransition.excludeTarget(android.R.id.statusBarBackground, true)
			window.reenterTransition.excludeTarget(android.R.id.navigationBarBackground, true)
			//window.reenterTransition.excludeTarget(R.id.toolbar, true)
		}

		setContentView(R.layout.activity_main)

		val toolbar = findViewById(R.id.toolbar) as Toolbar
		setSupportActionBar(toolbar)
	}
}
