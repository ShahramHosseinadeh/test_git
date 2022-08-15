package com.example.test_7.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.model.NewModel
import com.example.test_7.model.NewModelMenu
import com.example.test_7.ui.listener.ShopListListener
import com.example.test_7.ui.listener.ShopListListenerProduct
import kotlinx.android.synthetic.main.item_shop_list_menu.view.*

class ShopListAdapterMenu(
    val listItem: List<NewModelMenu>,
    val listener: ShopListListenerProduct,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_shop_list_menu, parent, false)
        return ShopListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShopListViewHolder).bindData(listItem[position], listener)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    inner class ShopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: NewModelMenu, listener: ShopListListenerProduct) {
            itemView.tv_shop_list_menu_title.text = item.title
            itemView.iv_shop_list_menu_cover.setImageResource(item.img)

            itemView.setOnClickListener {
                listener.onShopItemProductClicked(item)
            }
        }
    }

}