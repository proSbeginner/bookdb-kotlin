package com.pros.bookdb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookdbApplication

fun main(args: Array<String>) {
	runApplication<BookdbApplication>(*args)
}
