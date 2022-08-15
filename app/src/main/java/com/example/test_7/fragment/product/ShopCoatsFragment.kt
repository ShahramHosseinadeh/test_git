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
import kotlinx.android.synthetic.main.fragment_shop_coats.*

class ShopCoatsFragment : Fragment(R.layout.fragment_shop_coats), ShopListListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_fragment_coat_back.setOnClickListener {
            activity?.onBackPressed()
        }

        serRecyclerViewData();
    }

    private fun serRecyclerViewData() {
        rv_fragment_coat_one.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_coat_one.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListCoats, listener = this@ShopCoatsFragment
        )

        rv_fragment_coat_two.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_coat_two.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListCoats2, listener = this@ShopCoatsFragment
        )
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ShopDetailFragment.getShopDetailFragment(shopItems))
            .addToBackStack(null)
            .commit()
    }
}