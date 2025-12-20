package com.apolodevsystem.todoperformance.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import java.lang.ref.WeakReference


private const val USER_PREFERENCES_NAME = "user_preferences"

val Context.dataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

val USER_NAME = stringPreferencesKey("user_name")

class DataStoreManager(private val context: WeakReference<Context>) {
    suspend fun createUser() {
        context.get()?.dataStore?.edit { preferences ->
            preferences[USER_NAME] = "Apolo"
        }
    }

    suspend fun getUserName(): String {
        val preferences = context.get()?.dataStore?.data?.first()
        return preferences?.get(USER_NAME) ?: "User"
    }

}