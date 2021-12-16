package com.nilmani.strugglelife.entity

import javax.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long= -1,
    val firstName:String = "",
    val lastName:String ="",
    val mobile:String = "",
    val course:String = "",
    @Column(unique = true)
    val email:String = "",
    val password:String = "",
    val gender:String = ""
        )
