package com.smartdata.kotlincodeanalysis

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
// errors are added in this file to check how detekt find the errors
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // example of non-compliant code
    private fun complexityMethod(){
        val str = "foo"
        val isFoo = if (str.startsWith("foo") && !str.endsWith("foo") && !str.endsWith("bar") && !str.endsWith("_")) {
            // ...
        }else{

        }

    }

    //ThrowingExceptionsWithoutMessageOrCause
    fun fooNonComp(bar: Int) {
        if (bar < 1) {
            throw IllegalArgumentException()
        }
        // ...
    }

    //ThrowingExceptionsWithMessageOrCause
    fun fooComp(bar: Int) {
        if (bar < 1) {
            throw IllegalArgumentException("bar must be greater than zero")
        }
        // ...
    }

}
