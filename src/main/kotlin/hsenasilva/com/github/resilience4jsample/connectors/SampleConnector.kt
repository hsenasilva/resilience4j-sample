package hsenasilva.com.github.resilience4jsample.connectors

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpServerErrorException

/**
 * @author hsena
 */
@CircuitBreaker(name = "sampleService")
@Component(value = "sampleConnector")
class SampleConnector {

    fun failure(): String = throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Remote exception")

    @CircuitBreaker(name = "sampleService", fallbackMethod = "fallback")
    fun recovery(): String = this.failure()

    private fun fallback(ex: HttpServerErrorException): String {
        ex.printStackTrace()
        return "Recovered service"
    }

}