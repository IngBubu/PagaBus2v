package com.example.pagabus2v
import java.util.regex.Matcher
import java.util.regex.Pattern

class ValidarEmail {
    companion object{
        var pat: Pattern?= null
        var mat: Matcher?= null

        fun  isEmail(email:String): Boolean{
            pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-ZÑña-z0-9-]+\\.)+[A-ZÑña-z]{2,4}$")
            mat = pat!!.matcher(email)
            return mat!!.find()
        }
    }
}