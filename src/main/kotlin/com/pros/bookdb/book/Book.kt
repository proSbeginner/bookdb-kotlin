package com.pros.bookdb.book

import org.hibernate.validator.constraints.Length
import javax.persistence.*

/*
Ref:
https://www.baeldung.com/hibernate-field-naming-spring-boot
https://stackoverflow.com/questions/29087626/entity-class-name-is-transformed-into-sql-table-name-with-underscores
 */

@Table(name = "book")
@Entity
data class Book(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id val id: Int,

        @Length(max = 20)
        val isbn: String,

        @Length(max = 100)
        val name: String,

        @Length(max = 100)
        val authorName: String,

        @Length(min = 4, max = 4)
        val year: String,

        val totalPage: Int
)