package com.example.githubuserinfo.view.input

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.githubuserinfo.R
import com.example.githubuserinfo.base.BaseActivity
import com.example.githubuserinfo.base.BaseFragment
import com.example.githubuserinfo.databinding.FragmentInputUserBinding
import com.example.githubuserinfo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputUserFragment : BaseFragment<FragmentInputUserBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_input_user
    override val toolbarLayout: Int
        get() = R.layout.toolbar
    private val viewModel : MainViewModel by activityViewModels()

    override fun bindView() {
        super.bindView()
        (activity as? BaseActivity<*>)?.removeToolbar()
        viewBinding.vm = viewModel
        viewBinding.btnGetInfo.setOnClickListener {
            navController.navigate(R.id.userInfoFragment)
        }
    }
}