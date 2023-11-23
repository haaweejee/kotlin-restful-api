package id.haaweejee.kotlinrestfulapi.service

import id.haaweejee.kotlinrestfulapi.entity.Product
import id.haaweejee.kotlinrestfulapi.exception.NotFoundException
import id.haaweejee.kotlinrestfulapi.model.CreateProductRequest
import id.haaweejee.kotlinrestfulapi.model.ListProductRequest
import id.haaweejee.kotlinrestfulapi.model.ProductResponse
import id.haaweejee.kotlinrestfulapi.model.UpdateProductRequest
import id.haaweejee.kotlinrestfulapi.repository.ProductRepository
import id.haaweejee.kotlinrestfulapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val repository: ProductRepository,
    val validationUtil: ValidationUtil,
) : ProductService {

    override fun create(request: CreateProductRequest): ProductResponse {
        validationUtil.validate(request)

        val product = Product(
            id = request.id!!,
            name = request.name!!,
            price = request.price!!,
            quantity = request.quantity!!,
            createdAt = Date(),
            updateAt = null
        )

        repository.save(product)

        return product.toProductResponse()
    }

    override fun get(id: String): ProductResponse {
        val product = id.findProductByIdOrThrowNotFound()

        return product.toProductResponse()
    }

    override fun update(id: String, request: UpdateProductRequest): ProductResponse {
        validationUtil.validate(request)

        val product = id.findProductByIdOrThrowNotFound()

        val updateProduct = product.apply {
            name = request.name!!
            price = request.price!!
            quantity = request.quantity!!
            updateAt = Date()
        }

        repository.save(updateProduct)

        return updateProduct.toProductResponse()
    }

    override fun delete(id: String) =
        repository.delete(id.findProductByIdOrThrowNotFound())

    override fun list(request: ListProductRequest): List<ProductResponse> {
        val page = repository.findAll(PageRequest.of(request.page, request.size))
        val products = page.get().collect(Collectors.toList())

        return products.map { it.toProductResponse() }
    }

    private fun String.findProductByIdOrThrowNotFound(): Product =
        repository.findByIdOrNull(this) ?: throw NotFoundException()

    private fun Product.toProductResponse(): ProductResponse =
        ProductResponse(
            id = this.id,
            name = this.name,
            price = this.price,
            quantity = this.quantity,
            createdAt = this.createdAt,
            updateAt = this.updateAt
        )
}