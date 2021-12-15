package com.nilmani.strugglelife.repository

import com.nilmani.strugglelife.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student,Long> {
}