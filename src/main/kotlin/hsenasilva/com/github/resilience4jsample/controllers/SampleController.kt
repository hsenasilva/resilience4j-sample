package hsenasilva.com.github.resilience4jsample.controllers

import hsenasilva.com.github.resilience4jsample.services.SampleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author hsena
 */
@RestController
@RequestMapping(value = ["/samples"])
class SampleController(val service: SampleService) {

    @GetMapping("/failure")
    fun sampleFailure(): ResponseEntity<Any> {
        return ResponseEntity.ok(this.service.failure())
    }

    @GetMapping("/recovery")
    fun sampleRecovery(): ResponseEntity<Any> {
        return ResponseEntity.ok(this.service.recovery())
    }

}