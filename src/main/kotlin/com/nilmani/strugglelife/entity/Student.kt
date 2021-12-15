package com.nilmani.strugglelife.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long= -1,
    val firstName:String = "",
    val lastName:String ="",
    val mobile:String = "",
    val course:String = "",
    val email:String = "",
    val password:String = "",
    val gender:String = ""
        )
