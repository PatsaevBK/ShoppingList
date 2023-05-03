package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(item: ShopItem): Unit

    fun deleteShopItem(item: ShopItem): Unit

    fun editShopItem(item: ShopItem): Unit

    fun getShopItemWithId(id: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>


}