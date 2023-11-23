package id.haaweejee.kotlinrestfulapi.service

import id.haaweejee.kotlinrestfulapi.model.CreateProductRequest
import id.haaweejee.kotlinrestfulapi.model.ListProductRequest
import id.haaweejee.kotlinrestfulapi.model.ProductResponse
import id.haaweejee.kotlinrestfulapi.model.UpdateProductRequest

interface ProductService {
    fun create(request: CreateProductRequest): ProductResponse
    fun get(id: String): ProductResponse
    fun update(id: String, request: UpdateProductRequest): ProductResponse
    fun delete(id: String)
    fun list(request: ListProductRequest): List<ProductResponse>
}