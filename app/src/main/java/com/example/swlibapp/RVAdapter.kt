package com.example.swlibapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter internal constructor(c: Context?, data: List<String>) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    private val mData: List<String> = data
    private val inflater: LayoutInflater = LayoutInflater.from(c)
    private var clickListener:ItemClickListener? = null

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var textView: TextView = itemView.findViewById(R.id.itemName)

        override fun onClick(v: View?) {
            if(clickListener != null) clickListener!!.onItemClick(v, bindingAdapterPosition)
        }

        init {
            itemView.setOnClickListener(this)
        }

    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = mData[position]
        holder.textView.text = name
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        clickListener = itemClickListener
    }

    fun getItem(id: Int): String{
        return mData[id]
    }

}