package com.sebnem.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.sebnem.kisileruygulamasi.data.datasource.KisilerDataSource
import com.sebnem.kisileruygulamasi.data.repo.KisilerRepository
import com.sebnem.kisileruygulamasi.room.KisilerDao
import com.sebnem.kisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
@Provides
@Singleton
fun provideKisilerRepository(kisilerDataSource: KisilerDataSource) : KisilerRepository {
return KisilerRepository(kisilerDataSource)
}
    @Provides
    @Singleton
    fun provideKisilerDataSoorce(kisilerDao: KisilerDao) : KisilerDataSource{
       return KisilerDataSource(kisilerDao)
    }
    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context : Context) : KisilerDao{
//veri tabanına erişme
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite")
            .build()
        return veritabani.getKisilerDao()

    }
}
