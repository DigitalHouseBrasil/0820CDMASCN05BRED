package com.turma05.aula39.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.turma05.aula39.cartao.dao.CartaoDao
import com.turma05.aula39.cartao.entity.CartaoEntity

@Database(
    entities = [CartaoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cartaoDao(): CartaoDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        // Singleton
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pagbem"
                ).build()
            }

            return INSTANCE!!
        }
    }
}