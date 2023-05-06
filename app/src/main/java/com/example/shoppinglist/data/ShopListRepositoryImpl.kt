package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10_000) {
            addShopItem(ShopItem("Name $i", i, Random.nextBoolean()))
        }
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFIEND_ID) {
            item.id = autoIncrementId++
        }
        shopList += item
        updateList()
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList -= item
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}