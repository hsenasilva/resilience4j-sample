package hsenasilva.com.github.resilience4jsample.services

import hsenasilva.com.github.resilience4jsample.connectors.SampleConnector
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.vavr.control.Try
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException
import java.time.Duration
import javax.servlet.http.HttpServletResponse


/**
 * @author hsena
 */
@Service
class SampleService(val sampleConnector: SampleConnector) {


    fun failure() = this.sampleConnector.failure()

    fun recovery() = this.sampleConnector.recovery()

}