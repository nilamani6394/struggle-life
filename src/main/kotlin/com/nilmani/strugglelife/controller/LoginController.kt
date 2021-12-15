package com.nilmani.strugglelife.controller

import com.nilmani.strugglelife.entity.Student
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class LoginController {
    @GetMapping("/login")
    fun showLogin():String{
        return "login"
    }

    fun login(@ModelAttribute("student")student: Student,model: Model){

    }
}