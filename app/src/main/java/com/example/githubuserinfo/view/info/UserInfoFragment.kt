package com.example.githubuserinfo.view.info

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.githubuserinfo.R
import com.example.githubuserinfo.base.BaseFragment
import com.example.githubuserinfo.base.Resource
import com.example.githubuserinfo.databinding.FragmentUserInfoBinding
import com.example.githubuserinfo.viewmodel.MainViewModel

class UserInfoFragment: BaseFragment<FragmentUserInfoBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_user_info
    override val toolbarLayout: Int
        get() = R.layout.toolbar_has_back
    private val viewModel : MainViewModel by activityViewModels()
    override fun bindView() {
        super.bindView()
        viewModel.getUserInfo()
        viewBinding.btnSeeMore.setOnClickListener {
            navController.navigate(R.id.listFollowersFragment)
        }
    }

    override fun bindViewModel() {
        super.bindViewModel()
        viewModel.userInfoViewModel.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Resource.Status.SUCCESS->{
                    if(it.data!=null){
                        viewBinding.user = it.data
                        viewBinding.resultScreen.loadingFinish()
                    }
                    else{
                        viewBinding.resultScreen.loadingError("User not found.")
                    }
                }
                Resource.Status.ERROR->{
                    viewBinding.resultScreen.loadingError("Something wrong happened.")
                }
                else->{
                    viewBinding.resultScreen.loadingBegin()
                }
            }
        })
    }

    override fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {
        super.toolbarFunc(curActivity, toolbar)
        toolbar?.findViewById<AppCompatTextView>(R.id.tvTitle)?.text = "Information"
        toolbar?.findViewById<AppCompatImageView>(R.id.ivBack)?.setOnClickListener {
            navController.popBackStack()
        }
    }
}