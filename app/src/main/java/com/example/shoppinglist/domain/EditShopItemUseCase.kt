package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(item: ShopItem): Unit = shopListRepository.editShopItem(item)
}