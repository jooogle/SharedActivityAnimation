package com.example.sinigr.sharedactivityanimation

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class ListeningImageView : ImageView {
	var listener: OnSizeChangedListener? = null

	constructor(context: Context) : super(context)

	constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

	interface OnSizeChangedListener {
		fun onSizeChanged(): Unit
	}

	fun addOnSizeChangedListener(listener: OnSizeChangedListener) {
		this.listener = listener
	}

	override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
		super.onSizeChanged(w, h, oldw, oldh)

		listener?.onSizeChanged()
	}
}