package com.example.sinigr.sharedactivityanimation

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.transition.TransitionInflater
import android.view.MenuItem

class DetailedActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			window.enterTransition = TransitionInflater.from(this)
					.inflateTransition(android.R.transition.explode)

			window.enterTransition.excludeTarget(android.R.id.statusBarBackground, true)
			window.enterTransition.excludeTarget(android.R.id.navigationBarBackground, true)
			//window.enterTransition.excludeTarget(R.id.toolbar, true)
		}

		setContentView(R.layout.activity_detailed)

		setSupportActionBar(findViewById(R.id.toolbar) as Toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		when (item?.itemId) {
			android.R.id.home -> {
				supportFinishAfterTransition()
				return true
			}
			else -> return super.onOptionsItemSelected(item)
		}
	}
}
