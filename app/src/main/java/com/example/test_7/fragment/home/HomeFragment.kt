package com.example.test_7.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.R
import com.example.test_7.fragment.details.ShopDetailFragment
import com.example.test_7.fragment.product.*
import com.example.test_7.model.DummyData
import com.example.test_7.model.NewModel
import com.example.test_7.model.NewModelMenu
import com.example.test_7.ui.adapter.ShopListAdapter
import com.example.test_7.ui.listener.ShopListListener
import kotlinx.android.synthetic.main.activity_main_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), ShopListListener, View.OnClickListener {
    val navController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViewData()

        tv_fragment_home_t_shirt_see_all.setOnClickListener(this)
        tv_fragment_home_dress_see_all.setOnClickListener(this)
        tv_fragment_home_pants_see_all.setOnClickListener(this)
        tv_fragment_home_shoes_see_all.setOnClickListener(this)
        tv_fragment_home_coat_see_all.setOnClickListener(this)

    }

    private fun setRecyclerViewData() {
        rv_fragment_home_top_woman.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv_fragment_home_top_woman.adapter = ShopListAdapter(
            listItems = DummyData().shopListTopWoman, listener = this@HomeFragment
        )

        rv_fragment_home_top_man.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv_fragment_home_top_man.adapter = ShopListAdapter(
            listItems = DummyData().shopListTopMan, listener = this@HomeFragment
        )
    }


    override fun onClick(view: View?) {
        when (view) {
            tv_fragment_home_t_shirt_see_all -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ShopTShirtFragment())
                    .addToBackStack(null)
                    .commit()
            }
            tv_fragment_home_dress_see_all -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ShopDressFragment())
                    .addToBackStack(null)
                    .commit()
            }
            tv_fragment_home_pants_see_all -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ShopPantsFragment())
                    .addToBackStack(null)
                    .commit()
            }
            tv_fragment_home_shoes_see_all -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ShopShoesFragment())
                    .addToBackStack(null)
                    .commit()
            }
            tv_fragment_home_coat_see_all -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, ShopCoatsFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onShopItemClicked(shopItems: NewModel) {
        navController.navigate(
            HomeFragmentDirections.actionFragmentHomeToShopDetailFragmentHome(shopItems)
        )
    }
}