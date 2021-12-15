package com.nilmani.strugglelife.controller

import com.nilmani.strugglelife.contentdyna.DynamicContent
import com.nilmani.strugglelife.entity.Student
import com.nilmani.strugglelife.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
//@RequestMapping("/student")
class StudentController {

    private var dynamicContent:DynamicContent?=null

    @Autowired
    private lateinit var studentService: StudentService

    var courses: MutableList<String> = arrayListOf()

    @ModelAttribute
    fun preLoad() {
//        courses = ArrayList()
//        (courses as ArrayList<String>).add("Android")
//        (courses as ArrayList<String>).add("IOS")
//        (courses as ArrayList<String>).add("Java")
        courses.add("Android")
        courses.add("Java")
        courses.add("IOS")
        courses.add("WebDesign")
        courses.add("Cow")

    }


//    @GetMapping("/")
//    fun getHomePage(student: Student,model: Model):String{
//        model.addAttribute("courses",courses)
//        return "index"
//    }
//
    @GetMapping("/")
    fun home(student: Student,model: Model):String{
        model.addAttribute("courses",courses)
        return "register"
    }


    @GetMapping("/register")
    fun showingRegistrationForm(student: Student,model: Model):String{
        model.addAttribute("student",student)
       return "register"
    }
    @PostMapping("/save")
    fun registerStudent(@ModelAttribute("student")student: Student,model: Model):String{
        studentService.saveStudent(student)
        return "welcome"
    }
    /**Shoe the user entred data as json format */
    fun getSubmitDetails(jsonMap : Map<String,Any>,model:Model):Boolean{
        var isError = false
        val arrayList = ArrayList<Map<String,Any>>()
        dynamicContent?.studForm?.forEach(){
            val map = hashMapOf<String,Any>()
//            map["id"] = it.id
            map["firstName"] = it.firstName
            map["lastName"] = it.lastName
            map["Mobile"] = it.mobile
            map["course"] = it.course
            map["email"] = it.email
            map["password"] = it.password
            map["gender"] = it.gender

            arrayList.add(map)
        }
        return isError
    }

    @PostMapping("/signUp")
    fun submitSignupDetails(@RequestParam jsonMap: Map<String, Any>, model: Model):String{
        val isError = getSubmitDetails(jsonMap,model)
        var redirect = ""
        redirect = if (isError)"redirect/register ${jsonMap["id"]}"
        else{
            "redirect/404pagenotFound"
        }
        return redirect
    }
}