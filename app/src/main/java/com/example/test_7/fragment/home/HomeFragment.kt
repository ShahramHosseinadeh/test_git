package com.example.test_7.fragment.home

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModel
import com.example.test_7.ui.adapter.ShopListAdapter
import com.example.test_7.ui.adapter.ShopListAdapterProduct
import com.example.test_7.ui.adapter.ShopListAdapterProductPopular
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.handleCoroutineException

class HomeFragment : Fragment(R.layout.fragment_home), ShopListListener, View.OnClickListener {
    val navController by lazy { findNavController() }

    companion object {
        var myScrollViewerInstanceState: Parcelable? = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (myScrollViewerInstanceState != null) {
            nsv_fragment_home.onRestoreInstanceState(myScrollViewerInstanceState)
        }

        setRecyclerViewData()

        tv_fragment_home_t_shirt_see_all.setOnClickListener(this)
        tv_fragment_home_dress_see_all.setOnClickListener(this)
        tv_fragment_home_pants_see_all.setOnClickListener(this)
        tv_fragment_home_shoe_see_all.setOnClickListener(this)
        tv_fragment_home_coat_see_all.setOnClickListener(this)

    }

    override fun onPause() {
        super.onPause()
        super.onPause()
        myScrollViewerInstanceState = nsv_fragment_home.onSaveInstanceState()
    }

    private fun setRecyclerViewData() {
        //Top sales Product
        rv_fragment_home_top_woman.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv_fragment_home_top_woman.adapter = ShopListAdapter(
            listItems = DummyData().shopListTopWoman, listener = this@HomeFragment,
        )

        (rv_fragment_home_top_woman.adapter as ShopListAdapter).stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        rv_fragment_home_top_man.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv_fragment_home_top_man.adapter = ShopListAdapter(
            listItems = DummyData().shopListTopMan, listener = this@HomeFragment,
        )

        //Popular Product
        rv_fragment_home_popular_t_shirt.adapter = ShopListAdapterProductPopular(
            listItems = DummyData().shopListTShitPopular, listener = this@HomeFragment
        )

        rv_fragment_home_popular_dress.adapter = ShopListAdapterProductPopular(
            listItems = DummyData().shopListDressPopular, listener = this@HomeFragment
        )

        rv_fragment_home_popular_pants.adapter = ShopListAdapterProductPopular(
            listItems = DummyData().shopListPantsPopular, listener = this@HomeFragment
        )

        rv_fragment_home_popular_coat.adapter = ShopListAdapterProductPopular(
            listItems = DummyData().shopListCoatPopular, listener = this@HomeFragment
        )

        rv_fragment_home_popular_shoe.adapter = ShopListAdapterProductPopular(
            listItems = DummyData().shopListShoePopular, listener = this@HomeFragment
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onClick(view: View?) {
        when (view) {
            tv_fragment_home_t_shirt_see_all -> {
                val valueOfTitleProduct = tv_fragment_home_popular_t_shirt.text.toString()
                navController.navigate(
                    HomeFragmentDirections.actionFragmentHomeToShopProductFragment(
                        valueOfTitleProduct)
                )
            }
            tv_fragment_home_dress_see_all -> {
                val valueOfTitleProduct = tv_fragment_home_popular_dress.text.toString()
                navController.navigate(
                    HomeFragmentDirections.actionFragmentHomeToShopProductFragment(
                        valueOfTitleProduct)
                )
            }
            tv_fragment_home_pants_see_all -> {
                val valueOfTitleProduct = tv_fragment_home_popular_pants.text.toString()
                navController.navigate(
                    HomeFragmentDirections.actionFragmentHomeToShopProductFragment(
                        valueOfTitleProduct)
                )
            }
            tv_fragment_home_coat_see_all -> {
                val valueOfTitleProduct = tv_fragment_home_popular_coat.text.toString()
                navController.navigate(
                    HomeFragmentDirections.actionFragmentHomeToShopProductFragment(
                        valueOfTitleProduct)
                )
            }
            tv_fragment_home_shoe_see_all -> {
                val valueOfTitleProduct = tv_fragment_home_popular_shoe.text.toString()
                navController.navigate(
                    HomeFragmentDirections.actionFragmentHomeToShopProductFragment(
                        valueOfTitleProduct)
                )
            }
        }
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        navController.navigate(
            HomeFragmentDirections.actionFragmentHomeToShopDetailFragment(shopItems)
        )
    }
}