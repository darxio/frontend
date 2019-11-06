package com.darx.foodscaner.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ingredients")
data class IngredientModel(
                    @PrimaryKey var id: Int,
                    @ColumnInfo(name = "name") var name: String,
                    @ColumnInfo(name = "description") var description: String,
                    @ColumnInfo(name = "image") var imagePath: String

): Serializable {
    constructor():this(0,"","", "")
}