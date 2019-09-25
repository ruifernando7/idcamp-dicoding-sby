package com.example.javakotlin.utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun Context.toast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context, message , duration).show()
}