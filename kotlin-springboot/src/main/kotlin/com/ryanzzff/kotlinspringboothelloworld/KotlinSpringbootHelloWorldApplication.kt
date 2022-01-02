package com.ryanzzff.kotlinspringboothelloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringbootHelloWorldApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootHelloWorldApplication>(*args)
}
