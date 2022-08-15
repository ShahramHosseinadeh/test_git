package com.example.test_7.fragment.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModelMenu
import com.example.test_7.ui.adapter.ShopListAdapterMenu

import com.example.test_7.ui.listener.ShopListListenerProduct
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(R.layout.fragment_menu), View.OnClickListener,
    ShopListListenerProduct {
    val navController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_fragment_menu_one.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_menu_one.adapter = ShopListAdapterMenu(
            listItem = DummyData().shopListMenuMan, listener = this@MenuFragment
        )

        rv_fragment_menu_two.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_fragment_menu_two.adapter = ShopListAdapterMenu(
            listItem = DummyData().shopListMenuMan2, listener = this@MenuFragment
        )

        iv_fragment_menu_man.setOnClickListener(this)
        iv_fragment_menu_woman.setOnClickListener(this)
        iv_fragment_menu_boy.setOnClickListener(this)
        iv_fragment_menu_girl.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view) {
            iv_fragment_menu_man -> {
                rv_fragment_menu_one.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_one.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuMan, listener = this@MenuFragment
                )

                rv_fragment_menu_two.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_two.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuMan2, listener = this@MenuFragment
                )
            }
            iv_fragment_menu_woman -> {
                rv_fragment_menu_one.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_one.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuWoman, listener = this@MenuFragment
                )

                rv_fragment_menu_two.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_two.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuWoman2, listener = this@MenuFragment
                )
            }

            iv_fragment_menu_boy -> {
                rv_fragment_menu_one.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_one.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuBoy, listener = this@MenuFragment
                )

                rv_fragment_menu_two.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_two.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuBoy2, listener = this@MenuFragment
                )
            }

            iv_fragment_menu_girl -> {
                rv_fragment_menu_one.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_one.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuGirl, listener = this@MenuFragment
                )

                rv_fragment_menu_two.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                rv_fragment_menu_two.adapter = ShopListAdapterMenu(
                    listItem = DummyData().shopListMenuGirl2, listener = this@MenuFragment

                )
            }
        }
    }

    override fun onShopItemProductClicked(shopItems: NewModelMenu) {
        navController.navigate(
            MenuFragmentDirections.actionFragmentMenuToShopDetailProduct(shopItems)
        )
    }
}