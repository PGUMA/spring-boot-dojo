package dojo.pguma.spring.boot.api.demo

import dojo.pguma.spring.boot.api.exception.NoSuchResourceException
import org.springframework.stereotype.Component

interface GetDemoUseCase {
    fun process(id: Int): String
}

@Component
class GetDemo: GetDemoUseCase {
    override fun process(id: Int): String {
        if(id == 1) {
            return "demo"
        }
        throw NoSuchResourceException()
    }
}