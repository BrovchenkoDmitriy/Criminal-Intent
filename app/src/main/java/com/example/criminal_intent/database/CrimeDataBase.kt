package com.example.criminal_intent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.criminal_intent.Crime

@Database(entities = [Crime::class], version = 2, exportSchema = false)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDataBase: RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}
val migration_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Crime ADD COLUMN suspect TEXT NOT NULL DEFAULT''")
    }
}