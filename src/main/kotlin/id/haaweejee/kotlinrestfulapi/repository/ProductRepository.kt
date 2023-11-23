package id.haaweejee.kotlinrestfulapi.repository

import id.haaweejee.kotlinrestfulapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {
}