package com.turma05.aula39.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.turma05.aula40.tarefa.dao.TarefaDao
import com.turma05.aula40.tarefa.entity.TarefaEntity

@Database(
    entities = [TarefaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun tarefaDao(): TarefaDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        // Singleton
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "aula40"
                ).build()
            }

            return INSTANCE!!
        }
    }
}