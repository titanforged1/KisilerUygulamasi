package com.sebnem.kisileruygulamasi.data.datasource

import android.util.Log
import com.sebnem.kisileruygulamasi.data.entity.Kisiler
import com.sebnem.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kisilerDao : KisilerDao) {
    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }


    suspend fun sil(kisi_id: Int) {
        Log.e("Kişi Sil", kisi_id.toString())
    }

    suspend fun kisileriYukle(): List<Kisiler> = withContext(Dispatchers.IO) {
       return@withContext kisilerDao.kisileriYukle()
    }

    suspend fun ara(aramaKelimesi: String): List<Kisiler> = withContext(Dispatchers.IO) {
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        liste.add(k1)

       return@withContext liste
    }

}