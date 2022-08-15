package com.example.test_7.fragment.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.fragment.product.ShopProductFragment
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModel
import com.example.test_7.model.NewModelMenu
import com.example.test_7.ui.adapter.ShopListAdapterProduct
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.fragment_shop_detail_product.*

class ShopProductMenuFragment : Fragment(R.layout.fragment_shop_detail_product),
    ShopListListener {
    val navController by lazy { findNavController() }

    val shopDetailProductFragmentArgs: ShopProductMenuFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_fragment_detail_product_back.setOnClickListener {
            activity?.onBackPressed()
        }

        if (shopDetailItemProduct?.title == "Pants") {
            tv_fragment_detail_product_name.text = shopDetailItemProduct?.title
        }

        Log.d("tagX",
            getShopDetailProductFragment(shopDetailProductFragmentArgs.newModelMenu).toString())


    }

    companion object {
        var shopDetailItemProduct: NewModelMenu? = null
        fun getShopDetailProductFragment(item: NewModelMenu): ShopProductMenuFragment {
            shopDetailItemProduct = item
            return ShopProductMenuFragment()
        }
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        navController.navigate(
            ShopProductMenuFragmentDirections.actionShopProductFragmentToShopDetailFragment(
                shopItems)
        )
    }
}