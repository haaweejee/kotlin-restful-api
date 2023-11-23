package id.haaweejee.kotlinrestfulapi.auth

import id.haaweejee.kotlinrestfulapi.exception.UnauthorizedException
import id.haaweejee.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val repository: ApiKeyRepository): WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-API-Key") ?: throw UnauthorizedException()
        if (!repository.existsById(apiKey)) { throw UnauthorizedException() }


        // valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
    }
}