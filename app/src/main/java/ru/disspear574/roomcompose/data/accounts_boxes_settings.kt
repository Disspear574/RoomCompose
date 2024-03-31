package ru.disspear574.roomcompose.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts_boxes_settings")
data class SettingEntity(
    @ColumnInfo(name = "account_id")
    var account_id: Int,
    @ColumnInfo(name = "box_id")
    var box_id: Int,
    @ColumnInfo(name = "is_active")
    var is_active: Int,
)


