package id.haaweejee.kotlinrestfulapi.controller

import id.haaweejee.kotlinrestfulapi.model.*
import id.haaweejee.kotlinrestfulapi.service.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val service: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val response = service.create(body)

        return WebResponse(
            code = 200,
            "OK",
            response
        )
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductResponse> {
        val response = service.get(id)

        return WebResponse(
            code = 200,
            message = "OK",
            response,
        )
    }

    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("idProduct") id: String,
        @RequestBody request: UpdateProductRequest
    ): WebResponse<ProductResponse> {
        val response = service.update(id, request)

        return WebResponse(
            code = 200,
            message = "OK",
            response
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String> {
        service.delete(id)
        return WebResponse(
            code = 200,
            message = "OK",
            data = "Item with ID $id, is Success Deleted"
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProducts(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): WebResponse<List<ProductResponse>> {
        val response = service.list(ListProductRequest(page, size))
        return WebResponse(
            code = 200,
            message = "OK",
            data = response
        )
    }
}