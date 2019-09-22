package com.pros.bookdb.book

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class BookController {
    @Autowired
    lateinit var repository: BookRepository;

    @GetMapping("/books")
    fun findAll() = repository.findAll();

    @GetMapping("/books/{id}")
    fun findById(@PathVariable id: Int) = repository.findById(id);

    @PostMapping("/books")
    fun create(@RequestBody book: Book): ResponseEntity<Void> {
        repository.save(book)
        return ResponseEntity(HttpStatus.CREATED)
    };

    @PutMapping("/books/{id}")
    fun updateById(@PathVariable id: Int, @RequestBody book: Book): ResponseEntity<Void> {
        val optional = repository.findById(id)
        if (optional.isPresent) {
            repository.save(book)
            return ResponseEntity(HttpStatus.OK)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/books/{id}")
    fun deleteById(@PathVariable id: Int, @RequestBody book: Book): ResponseEntity<Void> {
        val optional = repository.findById(id)
        if (optional.isPresent) {
            repository.delete(optional.get())
            return ResponseEntity(HttpStatus.OK)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}