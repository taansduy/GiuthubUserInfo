package com.example.githubuserinfo.utils

import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.githubuserinfo.R
import com.google.android.material.appbar.AppBarLayout

fun AppCompatActivity.hideSoftKeyboard() {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as? InputMethodManager

    inputMethodManager?.hideSoftInputFromWindow(
        currentFocus?.windowToken, 0
    )
}

fun AppCompatActivity.showToast(message: String? = "") {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.addToolbar(
    @LayoutRes toolbarLayoutId: Int,
    viewGroup: ViewGroup?,
    toolbarCallBack: ((activity: AppCompatActivity?, toolbar: Toolbar?) -> Unit)? = null
) {
    viewGroup?.findViewById<AppBarLayout>(R.id.appBarLayout)?.apply {
        viewGroup.removeView(this)
    }

    val toolbarItem = layoutInflater.inflate(toolbarLayoutId, viewGroup, false) ?: return
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        toolbarItem.stateListAnimator = null
    }
    viewGroup?.addView(toolbarItem)

    val toolbar = toolbarItem.findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayShowTitleEnabled(false)
    toolbarCallBack?.invoke(this, toolbar)
}

fun AppCompatActivity.removeToolbar(viewGroup: ViewGroup?) {
    viewGroup?.findViewById<AppBarLayout>(R.id.appBarLayout)?.apply {
        viewGroup.removeView(this)
    }
}