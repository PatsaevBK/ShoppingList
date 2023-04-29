package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemWithId(id: Int): ShopItem = shopListRepository.getShopItemWithId(id)
}