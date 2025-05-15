package com.sebnem.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sebnem.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")//sorgu yapma
    suspend fun kisileriYukle() : List <Kisiler>

     @Insert
     suspend fun kaydet(kisi : Kisiler)
     }
 @Update
 suspend fun guncelle(kisi: Kisiler){
}