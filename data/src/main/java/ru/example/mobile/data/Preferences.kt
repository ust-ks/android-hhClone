package ru.example.mobile.data

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class Preferences(context: Context) {

    companion object {
        private const val PREFS = "hhClone_prefs"
    }

    private val masterKeyAlias by lazy {
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
    }

    private val preferences = EncryptedSharedPreferences.create(
        context,
        PREFS,
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    var email: String?
        get() = preferences.getString("email", null)
        set(value) = preferences.edit().putString("email", value).apply()

    var isAuthorized: Boolean
        get() = preferences.getBoolean("is_authorized", false)
        set(value) = preferences.edit().putBoolean("is_authorized", value).apply()

}