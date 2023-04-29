package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFIEND_ID) {
            item.id = autoIncrementId++
        }
        shopList += item
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList -= item
    }

    override fun editShopItem(item: ShopItem) {
        val oldItem = getShopItemWithId(item.id)
        shopList.remove(oldItem)
        addShopItem(item)
    }

    override fun getShopItemWithId(id: Int): ShopItem {
        return shopList.find { it.id == id }
            ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}