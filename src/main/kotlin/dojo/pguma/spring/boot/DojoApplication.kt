package dojo.pguma.spring.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DojoApplication

fun main(args: Array<String>) {
	runApplication<DojoApplication>(*args)
}
