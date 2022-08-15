package com.example.test_7.fragment.product

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test_7.R
import com.example.test_7.fragment.details.ShopDetailFragmentArgs
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModel
import com.example.test_7.ui.adapter.ShopListAdapterProduct
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.fragment_shop_detail_product.*
import kotlinx.android.synthetic.main.fragment_shop_product.*

class ShopProductFragment : Fragment(R.layout.fragment_shop_product), ShopListListener {
    val navController by lazy { findNavController() }

    val shopProductFragmentArgs: ShopProductFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //onClick
        iv_fragment_shop_product_back.setOnClickListener {
            activity?.onBackPressed()
        }

        rv_fragment_shop_product.layoutManager =
            GridLayoutManager(requireActivity(), 2)
        rv_fragment_shop_product.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListTShirt, listener = this@ShopProductFragment
        )

        when (shopProductFragmentArgs.titleProduct) {
            "T Shirt" -> {
                tv_fragment_shop_product_name.text = shopProductFragmentArgs.titleProduct

                rv_fragment_shop_product.adapter = ShopListAdapterProduct(
                    listItems = DummyData().shopListTShirt, listener = this@ShopProductFragment
                )
            }
            "Dress" -> {
                tv_fragment_shop_product_name.text = shopProductFragmentArgs.titleProduct

                rv_fragment_shop_product.adapter = ShopListAdapterProduct(
                    listItems = DummyData().shopListDress, listener = this@ShopProductFragment
                )
            }
            "Pants" -> {
                tv_fragment_shop_product_name.text = shopProductFragmentArgs.titleProduct

                rv_fragment_shop_product.adapter = ShopListAdapterProduct(
                    listItems = DummyData().shopListPants, listener = this@ShopProductFragment
                )
            }
            "Coat" -> {
                tv_fragment_shop_product_name.text = shopProductFragmentArgs.titleProduct

                rv_fragment_shop_product.adapter = ShopListAdapterProduct(
                    listItems = DummyData().shopListCoat, listener = this@ShopProductFragment
                )
            }
            "Shoe" -> {
                tv_fragment_shop_product_name.text = shopProductFragmentArgs.titleProduct

                rv_fragment_shop_product.adapter = ShopListAdapterProduct(
                    listItems = DummyData().shopListShoe, listener = this@ShopProductFragment
                )
            }
        }
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        navController.navigate(
            ShopProductFragmentDirections.actionShopProductFragmentToShopDetailFragment(shopItems)
        )
    }
}