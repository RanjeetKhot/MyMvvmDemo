package com.example.kotlinpeople.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinpeople.other.RegistrationResponse

@Dao
interface RegistrationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRegistration(user :RegistrationResponse)


      @Query("SELECT * FROM RegistrationResponse")
      fun getRegistration(): LiveData<RegistrationResponse>

}