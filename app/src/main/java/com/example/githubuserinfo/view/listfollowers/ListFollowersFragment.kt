package com.example.githubuserinfo.view.listfollowers

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
import com.example.githubuserinfo.databinding.FragmentListFollowerBinding
import com.example.githubuserinfo.viewmodel.MainViewModel

class ListFollowersFragment : BaseFragment<FragmentListFollowerBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_list_follower
    override val toolbarLayout: Int
        get() = R.layout.toolbar_has_back
    private val viewModel : MainViewModel by activityViewModels()
    val adapter: FollowerAdapter by lazy {
        FollowerAdapter()
    }

    override fun bindView() {
        super.bindView()
        viewModel.getFollowers()
        viewBinding.rvFollowers.adapter = adapter
    }

    override fun bindViewModel() {
        super.bindViewModel()
        viewModel.listFollowersViewModel.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Resource.Status.SUCCESS->{
                    if (it.data.isNullOrEmpty()){
                        viewBinding.resultScreen.loadingEmpty("List followers is empty.")
                    }
                    else{
                        viewBinding.resultScreen.loadingFinish()
                        it.data.let { it1 -> adapter.submitListUsers(it1) }
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
        toolbar?.findViewById<AppCompatTextView>(R.id.tvTitle)?.text = "Followers"
        toolbar?.findViewById<AppCompatImageView>(R.id.ivBack)?.setOnClickListener {
            navController.popBackStack()
        }
    }
}