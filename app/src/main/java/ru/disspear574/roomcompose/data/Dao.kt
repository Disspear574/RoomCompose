package ru.disspear574.roomcompose.data
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)
    @Delete
    suspend fun deleteUser(userEntity: UserEntity)
    @Query(value = "DELETE FROM users")
//    @Query(value = "DELETE FROM sqlite_sequence")
    suspend fun deleteAllUsers()

    @Query(value = "SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>

}