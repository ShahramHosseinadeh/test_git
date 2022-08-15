package com.example.test_7.fragment.details

import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.test_7.R
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModel
import com.example.test_7.ui.adapter.ShopListAdapterProduct
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.fragment_shop_detail_home.*

class ShopDetailFragment : Fragment(R.layout.fragment_shop_detail_home), OnClickListener,
    ShopListListener {
    val navController by lazy { findNavController() }

    val shopDetailFragmentArgs: ShopDetailFragmentArgs by navArgs()

    //This is for favorite FULL or EMPTY
    var isFavorite: Boolean = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_fragment_detail_product.load(shopDetailFragmentArgs.newModel.imageUrl)
        tv_fragment_detail_title.text = shopDetailFragmentArgs.newModel.title
        tv_fragment_detail_price.text = shopDetailFragmentArgs.newModel.price

        rv_fragment_detail_product.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListCoat, this@ShopDetailFragment
        )

        //colors
        iv_fragment_detail_black_circle.setOnClickListener(this)
        iv_fragment_detail_white_circle.setOnClickListener(this)
        iv_fragment_detail_red_circle.setOnClickListener(this)
        iv_fragment_detail_blue_circle.setOnClickListener(this)

        //back & favorite button
        iv_fragment_detail_favorite.setOnClickListener(this)
        iv_fragment_detail_back.setOnClickListener(this)
    }

    /* companion object {
         var shopDetailItem: NewModel? = null
         fun getShopDetailFragment(item: NewModel): ShopDetailFragment {
             shopDetailItem = item
             return ShopDetailFragment()
         }
     }
 */
    override fun onClick(view: View?) {
        when (view) {
            iv_fragment_detail_black_circle -> {
                iv_fragment_detail_black_line.alpha = 1f

                iv_fragment_detail_white_line.alpha = 0f
                iv_fragment_detail_red_line.alpha = 0f
                iv_fragment_detail_blue_line.alpha = 0f
            }
            iv_fragment_detail_white_circle -> {
                iv_fragment_detail_white_line.alpha = 1f

                iv_fragment_detail_black_line.alpha = 0f
                iv_fragment_detail_red_line.alpha = 0f
                iv_fragment_detail_blue_line.alpha = 0f
            }
            iv_fragment_detail_red_circle -> {
                iv_fragment_detail_red_line.alpha = 1f

                iv_fragment_detail_black_line.alpha = 0f
                iv_fragment_detail_white_line.alpha = 0f
                iv_fragment_detail_blue_line.alpha = 0f
            }
            iv_fragment_detail_blue_circle -> {
                iv_fragment_detail_blue_line.alpha = 1f

                iv_fragment_detail_black_line.alpha = 0f
                iv_fragment_detail_white_line.alpha = 0f
                iv_fragment_detail_red_line.alpha = 0f
            }
            iv_fragment_detail_favorite -> {
                if (!isFavorite) {
                    iv_fragment_detail_favorite.setImageResource(R.drawable.ic_favorite_detail_black)
                    isFavorite = true
                } else {
                    iv_fragment_detail_favorite.setImageResource(R.drawable.ic_favorite_detail)
                    isFavorite = false
                }
            }
            iv_fragment_detail_back -> {
                activity?.onBackPressed()
            }
        }
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        navController.navigate(
            ShopDetailFragmentDirections.actionShopDetailFragmentSelf(shopItems)
        )
    }
}