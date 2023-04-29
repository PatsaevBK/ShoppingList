package com.example.shoppinglist.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(item: ShopItem): Unit = shopListRepository.deleteShopItem(item)
}