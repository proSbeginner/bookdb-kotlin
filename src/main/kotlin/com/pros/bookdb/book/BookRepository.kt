package com.pros.bookdb.book

import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Int> {
}