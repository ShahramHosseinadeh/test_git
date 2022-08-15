package com.example.test_7.fragment.product

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.fragment.details.ShopDetailFragment
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModel
import com.example.test_7.ui.adapter.ShopListAdapterProduct
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.fragment_shop_dress.*

class ShopDressFragment : Fragment(R.layout.fragment_shop_dress), ShopListListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViewData()

        iv_fragment_dress_back.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setRecyclerViewData() {
        rv_fragment_dress_one.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_dress_one.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListDress, listener = this@ShopDressFragment
        )

        rv_fragment_dress_two.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_dress_two.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListDress2, listener = this@ShopDressFragment
        )
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        requireActivity().supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            ShopDetailFragment.getShopDetailFragment(item = shopItems)).addToBackStack(null)
            .commit()
    }
}