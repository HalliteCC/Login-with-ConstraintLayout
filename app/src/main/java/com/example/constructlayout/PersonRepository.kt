package com.example.constructlayout

class PersonRepository {

    fun login (email: String, password: String): Boolean {
        return (email != "" && password != "")

    }
}