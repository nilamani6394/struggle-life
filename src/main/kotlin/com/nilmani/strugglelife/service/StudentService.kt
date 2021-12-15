package com.nilmani.strugglelife.service

import com.nilmani.strugglelife.entity.Student
import com.nilmani.strugglelife.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService {
    @Autowired
    private lateinit var studentRepository: StudentRepository

    fun saveStudent(student:Student){
        studentRepository.save(student)
    }
}