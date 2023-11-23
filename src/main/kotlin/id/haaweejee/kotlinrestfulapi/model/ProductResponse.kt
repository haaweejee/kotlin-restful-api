package id.haaweejee.kotlinrestfulapi.model

import java.util.*

data class ProductResponse(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createdAt: Date,
    val updateAt: Date?
)
