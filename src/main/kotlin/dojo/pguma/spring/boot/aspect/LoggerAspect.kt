package dojo.pguma.spring.boot.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.LocalDateTime

@Aspect
@Component
class LoggerAspect {
    companion object {
        val log: Logger = LoggerFactory.getLogger(LoggerAspect::class.java)
    }
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    fun inApiLayer() {}

    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/advice.html

    @Before("inApiLayer()")
    fun BeforeProcess(joinPoint: JoinPoint) {
        log.info("request ${joinPoint.target.javaClass.name}:${joinPoint.signature.name}")
    }

    @AfterReturning("inApiLayer()")
    fun AfterReturningProcess(joinPoint: JoinPoint) {
        log.info("success ${joinPoint.target.javaClass.name}:${joinPoint.signature.name}")
    }

    @AfterThrowing("inApiLayer()")
    fun AfterThrowingProcess(joinPoint: JoinPoint) {
        log.info("fail ${joinPoint.target.javaClass.name}:${joinPoint.signature.name}")
    }

    @After("inApiLayer()")
    fun AfterProcess(joinPoint: JoinPoint) {
        log.info("finally ${joinPoint.target.javaClass.name}:${joinPoint.signature.name}")
    }

    @Around("inApiLayer()")
    fun AroundProcess(joinPoint: ProceedingJoinPoint) {
        log.info("start ${joinPoint.target.javaClass.name}:${joinPoint.signature.name}")
        val startTime = LocalDateTime.now()
        joinPoint.proceed()
        val endTime = LocalDateTime.now()
        log.info("end ${joinPoint.target.javaClass.name}:${joinPoint.signature.name}")

        log.info("processed time is ${Duration.between(startTime, endTime).toMillis()}ms")
    }
}