package com.example.githubuserinfo.view.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatTextView
import com.example.githubuserinfo.R

class ResultScreen : FrameLayout {

    private val mBtnText = "Thử lại"
    private var mTxtMessage: AppCompatTextView? = null
    private var mBtnRetry: TextView? = null
    private var mProgressBar: ProgressBar? = null
    private var mLlEmpty: View? = null


    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context) {
        if (!isInEditMode) { // no visible when design layout.
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as? LayoutInflater)?.inflate(R.layout.layout_result_screen, this, true)
            mProgressBar = findViewById(R.id.progress_bar)
            mLlEmpty = findViewById(R.id.ll_empty)
            mTxtMessage = findViewById(R.id.tvMessage)
        }
    }

    override fun setVisibility(visibility: Int) {
        if (visibility != View.VISIBLE) {
            mProgressBar?.visibility = View.GONE
        }
        super.setVisibility(visibility)
    }

    fun loadingBegin() {
        visibility = View.VISIBLE
        //        setBackgroundColor(getResources().getColor(R.color.white));
        mLlEmpty?.visibility = View.GONE
        mProgressBar?.visibility = View.VISIBLE
    }

    fun loadingFinish() {
        visibility = View.GONE
        mLlEmpty?.visibility = View.GONE
        mProgressBar?.visibility = View.GONE
    }

    fun loadingError(msgError: String?) {
        visibility = View.VISIBLE
        mLlEmpty?.visibility = View.VISIBLE
        mProgressBar?.visibility = View.GONE
        mTxtMessage?.visibility = View.VISIBLE
        mTxtMessage?.text = msgError
    }


    fun loadingEmpty(message: String) {
        visibility = View.VISIBLE
        mLlEmpty?.visibility = View.VISIBLE
        mBtnRetry?.visibility = View.GONE
        mProgressBar?.visibility = View.GONE
        mTxtMessage?.text = message
        mTxtMessage?.visibility = View.VISIBLE
    }
}