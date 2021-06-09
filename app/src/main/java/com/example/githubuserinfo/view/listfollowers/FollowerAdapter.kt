package com.example.githubuserinfo.view.listfollowers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuserinfo.databinding.LayoutItemFollowerBinding
import com.example.githubuserinfo.model.UserInfo

class FollowerAdapter(
    private val onClickUserCallback: (UserInfo) -> Unit = { _ -> }

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var users = listOf<UserInfo>()
    private var mContext: Context? = null

    fun submitListUsers(newCurrencies: List<UserInfo>) {
        users = newCurrencies
        notifyDataSetChanged()
    }

    fun clearData() {
        users = listOf()
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun getItem(position: Int): UserInfo = users[position]


    override fun getItemCount(): Int = users.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mContext = parent.context
        val binding =
            LayoutItemFollowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FollowerViewHolder).bind(users[position],position)
    }


    inner class FollowerViewHolder(private val binding: LayoutItemFollowerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userInfo: UserInfo, position: Int) {
            binding.user = userInfo
            binding.root.setOnClickListener {
                onClickUserCallback.invoke(userInfo)
            }
        }
    }

}