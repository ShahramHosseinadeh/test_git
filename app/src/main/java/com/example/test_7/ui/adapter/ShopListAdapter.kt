package com.example.test_7.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.test_7.R
import com.example.test_7.model.NewModel
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.item_shop_list.view.*

class ShopListAdapter(val listItems: List<NewModel>, val listener: ShopListListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_shop_list, parent, false)
        return ShopListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShopListViewHolder).bindData(listItems[position], listener)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class ShopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: NewModel, listener: ShopListListener) {
            itemView.tv_shop_list_title.text = item.title
            itemView.tv_shop_list_price.text = item.price
            itemView.iv_shop_list_cover.load(item.imageUrl)

            var isFavorite = false
            itemView.iv_shop_list_favorite.setOnClickListener {
                if (!isFavorite) {
                    itemView.iv_shop_list_favorite.setImageResource(R.drawable.ic_favorite_full)
                    isFavorite = true
                } else {
                    itemView.iv_shop_list_favorite.setImageResource(R.drawable.ic_favorite)
                    isFavorite = false
                }
            }

            itemView.setOnClickListener {
                listener.onShopItemClicked(shopItems = item)
            }
        }
    }
}