package data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Member::class, Card::class], version = 1)
abstract class OneCardRoomDb : RoomDatabase() {
    abstract fun memberDao(): MemberDao

    companion object DbFactory {
        private var INSTANCE: OneCardRoomDb? = null

        fun getDbInstance(context: Context): OneCardRoomDb? {
            if (INSTANCE == null) {
                synchronized(OneCardRoomDb::class){
                    if (INSTANCE == null){
                        Room.databaseBuilder(context.applicationContext,
                                OneCardRoomDb::class.java, "OneCard_database")
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}