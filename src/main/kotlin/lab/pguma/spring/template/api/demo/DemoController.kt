package lab.pguma.spring.template.api.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demo")
class DemoController(
    private val useCase: GetDemoUseCase
) {
    @GetMapping("/{id}")
    fun demo(@PathVariable id: Int): String {
        return useCase.process(id)
    }
}