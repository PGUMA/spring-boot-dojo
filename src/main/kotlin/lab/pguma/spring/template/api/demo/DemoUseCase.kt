package lab.pguma.spring.template.api.demo

import lab.pguma.spring.template.api.exception.NoSuchResourceException
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