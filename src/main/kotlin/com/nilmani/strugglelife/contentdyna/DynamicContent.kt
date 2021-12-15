package com.nilmani.strugglelife.contentdyna

class DynamicContent (
    val studForm:ArrayList<StuForm>?=null,
        )
class StuForm(
    val id:Long= -1,
    val firstName:String = "",
    val lastName:String ="",
    val mobile:String = "",
    val course:String = "",
    val email:String = "",
    val password:String = "",
    val gender:String = ""
)