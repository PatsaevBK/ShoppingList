package com.example.shoppinglist.domain

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFIEND_ID
) {

    companion object {
        const val UNDEFIEND_ID = -1
    }

}
