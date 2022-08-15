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
import kotlinx.android.synthetic.main.fragment_shop_t_shirt.*

class ShopTShirtFragment : Fragment(R.layout.fragment_shop_t_shirt), ShopListListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViewData()

        iv_fragment_t_shirt_back.setOnClickListener{
            activity?.onBackPressed()
        }
    }

    private fun setRecyclerViewData() {
        rv_fragment_t_shirt_one.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_t_shirt_one.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListTShirt, listener = this@ShopTShirtFragment
        )

        rv_fragment_t_shirt_two.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_t_shirt_two.adapter = ShopListAdapterProduct(
            listItems = DummyData().shopListTShirt2, listener = this@ShopTShirtFragment
        )
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        requireActivity().supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            ShopDetailFragment.getShopDetailFragment(item = shopItems)).addToBackStack(null)
            .commit()
    }
}