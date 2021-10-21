package com.shady.fragmentslesson.data

import com.shady.fragmentslesson.data.model.User

class Repo {
    fun getAllUsers() : List<User>{
        val users = mutableListOf<User>()
        for (i in 1..100){
            val user = User(i,"fName $i","lName $i", i*10)
            users += user
        }
        return users
    }
}