package com.nilmani.strugglelife.service

import com.nilmani.strugglelife.entity.Student
import com.nilmani.strugglelife.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserService : UserDetailsService {
    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String?): UserDetails {
        val studentData: Student? = email?.let { studentRepository.findByEmail(it) }
        if (studentData != null){
            return User(studentData.email,studentData.password,ArrayList())
        }
        throw UsernameNotFoundException("invalid email and password")
    }
}