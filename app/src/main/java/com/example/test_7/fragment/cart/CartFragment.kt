package com.example.test_7.fragment.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.model.DummyData
import com.example.test_7.ui.adapter.ShopListAdapter
import com.example.test_7.ui.adapter.ShopListAdapterCart
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_home.*

class CartFragment : Fragment(R.layout.fragment_cart) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViewData()
    }

    private fun setRecyclerViewData() {
        rv_fragment_cart_cart.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_cart_cart.adapter = ShopListAdapterCart(
            listItem = DummyData().shopListCart,
        )
    }
}