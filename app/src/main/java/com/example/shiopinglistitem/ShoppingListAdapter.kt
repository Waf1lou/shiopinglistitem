package com.example.shiopinglistitem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingListAdapter(
    private val shoppingList: MutableList<String>
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.itemName.text = item

        holder.deleteButton.setOnClickListener {
            shoppingList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, shoppingList.size)
        }
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }
}