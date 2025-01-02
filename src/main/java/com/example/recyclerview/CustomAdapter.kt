package com.example.recyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val garderobs:MutableList<Garderob>):
RecyclerView.Adapter<CustomAdapter.UserViewHolder>(){

    private var onUserClickListener:OnUserClickListener? = null

    interface OnUserClickListener{
        fun onUserClick(garderob: Garderob, position: Int)
    }
    class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameTV:TextView = itemView.findViewById(R.id.nameTV)
        val infoTV:TextView = itemView.findViewById(R.id.infoTV)
        val imageViewIV: ImageView = itemView.findViewById(R.id.imageViewIV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount() = garderobs.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val carderob = garderobs[position]
        holder.nameTV.text = carderob.name
        holder.infoTV.text = carderob.info
        holder.imageViewIV.setImageResource(carderob.image)
        if(onUserClickListener!=null){
            onUserClickListener!!.onUserClick(carderob, position)
        }
    }

    fun setOnUserClickListener(onUserClickListener: OnUserClickListener){
        this.onUserClickListener = onUserClickListener
    }
}