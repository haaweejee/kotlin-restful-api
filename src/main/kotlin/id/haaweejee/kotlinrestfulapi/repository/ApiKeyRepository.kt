package id.haaweejee.kotlinrestfulapi.repository

import id.haaweejee.kotlinrestfulapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}