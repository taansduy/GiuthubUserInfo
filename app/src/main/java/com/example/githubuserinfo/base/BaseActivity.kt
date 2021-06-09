package com.example.githubuserinfo.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.githubuserinfo.utils.*

abstract class BaseActivity <ViewBinding : ViewDataBinding>: AppCompatActivity(){
    lateinit var viewBinding: ViewBinding

    @get:LayoutRes
    abstract val layoutId: Int

    @get:LayoutRes
    open val toolbarLayoutId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this
        setupToolbar()
        bindView()
        bindViewModel()
    }

    private fun setupToolbar(){
        if(toolbarLayoutId == -1) return
        addToolbar(
            toolbarLayoutId = toolbarLayoutId,
            viewGroup = viewBinding.root as? ViewGroup,
            toolbarCallBack = {curActivity, toolbar ->
                toolbarFunc(curActivity,toolbar)
            }
        )
    }

    fun removeToolbar(){
        removeToolbar(viewBinding.root as? ViewGroup)
    }

    open fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {}
    open fun bindView(){}
    open  fun bindViewModel(){}
}