package com.example.test_7.model

import android.media.Image
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

data class NewModel(var title: String, var price: String, var imageUrl: String) : Serializable

data class NewModelPopularHome(var imageUrl: String)


data class NewModelMenu(var title: String, var img: Int) : Serializable

data class NewModelCart(var img: String, var title: String, var price: String, var quantity: String)