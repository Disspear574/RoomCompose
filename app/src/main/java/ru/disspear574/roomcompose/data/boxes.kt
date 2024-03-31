package ru.disspear574.roomcompose.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boxes")
data class BoxesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "color_name")
    var color_name: String,
    @ColumnInfo(name = "color_value")
    var color_value: String,
)

