package com.shady.fragmentslesson.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shady.fragmentslesson.R
import com.shady.fragmentslesson.data.model.User
import com.shady.fragmentslesson.ui.details.Details

class UserRVAdapter(private val fillUsers: List<User>,private val isLandscape: Boolean) : RecyclerView.Adapter<CustomAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_item, parent, false)
        return CustomAdapter(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter, position: Int) {
        val user = fillUsers[position]
        holder.idTextView.text = user.id.toString()
        holder.nameTextView.text = "${user.fName}  ${user.lName}"
        holder.itemView.setOnClickListener {view ->
            val activity = view.context as AppCompatActivity
            val bundle = Bundle()
            bundle.putParcelable("userKey",user)
            val detailView = if(isLandscape) R.id.flDetails else R.id.container
            val fragment = Details.newInstance()
            fragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction()
                .replace(detailView , fragment)
                .addToBackStack("details")
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return fillUsers.size
    }

}

class CustomAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
    val idTextView: TextView = itemView.findViewById(R.id.tvId)
    val nameTextView: TextView = itemView.findViewById(R.id.tvName)
}
