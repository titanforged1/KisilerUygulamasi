package com.sebnem.kisileruygulamasi.data.entity

import java.io.Serializable

data class Kisiler(var kisi_id: Int,
                   var kisi_ad: String,
                   var kisi_tel: String): Serializable {
    //Serializable: nesne transferi için bu özellikte bir sınıf lazım

}