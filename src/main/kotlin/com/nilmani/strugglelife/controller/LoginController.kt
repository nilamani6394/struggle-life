package com.nilmani.strugglelife.controller

import com.nilmani.strugglelife.contentdyna.ReqStudent
import com.nilmani.strugglelife.entity.Student
import com.nilmani.strugglelife.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.lang.NullPointerException

@Controller
class LoginController {
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var studentRepository: StudentRepository

   /** @GetMapping("/login")
    fun login(request:ReqStudent, model: Model): String? {
       val existingUser=studentRepository.findByEmail(request.email)//userRepo.findUserByEmail(request.email)
        if(existingUser != null){
            try {
                authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(
                        request.email,
                        request.password
                    )
                )
            }catch (e: BadCredentialsException){
                return "Wrong Username and Password"
            }
        }
        return "login"
    }*/
   @GetMapping("/login")
   fun studentLogin(@ModelAttribute request:ReqStudent,model: Model):String{
       val message:String=""
       val existingStudent = studentRepository.findByEmail(request.email)
           try {
               if (existingStudent?.email == request.email && existingStudent.password == request.password){
//                   model.addAttribute("request",request)
                   return "redirect:LoginSuccesspage"
               }else{
                   println("Sorry inconvintional username and password")
               }

           }catch (e:NullPointerException){
               e.stackTrace
           }
       return "login"
   }

//    @GetMapping("/")
//    fun showLogin():String{
//        return "login"
//    }

    fun login(@ModelAttribute("student")student: Student,model: Model){

    }
}