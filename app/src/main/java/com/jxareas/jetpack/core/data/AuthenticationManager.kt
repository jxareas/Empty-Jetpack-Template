package com.jxareas.jetpack.core.data

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationManager @Inject constructor(val sharedPref: SharedPreferences) {
    fun isAuthenticated(): Boolean =
        sharedPref.getString("username", "")!!.isNotEmpty()

    fun saveRegistration(username: String) {
        sharedPref.edit().putString("username", username).apply()
    }

    fun clearRegistration() {
        sharedPref.edit().remove("username").apply()
    }

    fun getAuthenticatedUser(): String {
        return checkNotNull(sharedPref.getString("username", "").takeIf { it!!.isNotEmpty() })
    }
}