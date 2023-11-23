package id.haaweejee.kotlinrestfulapi.controller

import id.haaweejee.kotlinrestfulapi.exception.NotFoundException
import id.haaweejee.kotlinrestfulapi.exception.UnauthorizedException
import id.haaweejee.kotlinrestfulapi.model.WebResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(exception: ConstraintViolationException): WebResponse<String> =
        WebResponse(
            code = 400,
            message = "BAD REQUEST",
            data = exception.message!!
        )

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(exception: NotFoundException): WebResponse<String> =
        WebResponse(
            404,
            "Not Found",
            "Not Found"
        )

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorizedHandler(exception: UnauthorizedException): WebResponse<String> =
        WebResponse(
            401,
            "UNAUTHORIZED",
            "Please put your X-API-Key"
        )
}