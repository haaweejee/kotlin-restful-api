package id.haaweejee.kotlinrestfulapi.config

import id.haaweejee.kotlinrestfulapi.entity.ApiKey
import id.haaweejee.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(val repository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!repository.existsById(apiKey)) {
            val key = ApiKey(apiKey)
            repository.save(key)
        }
    }
}