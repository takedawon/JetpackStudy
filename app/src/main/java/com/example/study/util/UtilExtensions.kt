package com.example.study.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(msg: String) {
    Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
}

