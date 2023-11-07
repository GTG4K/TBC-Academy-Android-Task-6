package com.example.tbc_academy_android_task_6

import java.io.Serializable

data class User(var firstName: String, var lastName: String, var age:Int, var email: String) :
    Serializable
