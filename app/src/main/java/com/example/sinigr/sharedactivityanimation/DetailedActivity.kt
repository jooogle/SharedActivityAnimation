package com.example.sinigr.sharedactivityanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionInflater
import android.view.MenuItem

class DetailedActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detailed)

		window.enterTransition = TransitionInflater.from(this)
				.inflateTransition(android.R.transition.explode)

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
