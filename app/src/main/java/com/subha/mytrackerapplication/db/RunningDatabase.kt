package com.subha.mytrackerapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.subha.mytrackerapplication.db.Converters
import com.subha.mytrackerapplication.db.Run
import com.subha.mytrackerapplication.db.RunDAO

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDAO
}
