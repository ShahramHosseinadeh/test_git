package com.example.test_7.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.test_7.R
import com.example.test_7.model.NewModelCart
import com.example.test_7.model.NewModelMenu
import kotlinx.android.synthetic.main.item_shop_list.view.*
import kotlinx.android.synthetic.main.item_shop_list_cart.view.*
import kotlinx.android.synthetic.main.item_shop_list_menu.view.*

class ShopListAdapterCart(val listItem: List<NewModelCart>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_shop_list_cart, parent, false)
        return ShopListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShopListViewHolder).bindData(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    inner class ShopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: NewModelCart) {

            itemView.iv_shop_list_cart_cover.load(item.img)
            itemView.tv_shop_list_cart_title.text = item.title
            itemView.tv_shop_list_cart_price.text = item.price
            itemView.tv_shop_list_cart_quantity.text = item.quantity

            /*itemView.setOnClickListener{
                listener.onNewsItemClicked(news_item = item)
            }*/
        }
    }
}