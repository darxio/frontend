package com.darx.foodscaner.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "scanned_products")
data class ScannedProductModel(
    @PrimaryKey @ColumnInfo(name = "barcode") var barcode: Long,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "contents") var contents: String, //!!!!!!!!!!
    @ColumnInfo(name = "category_url") var categoryURL: String,
    @ColumnInfo(name = "mass") var mass: String,
    @ColumnInfo(name = "bestbefore") var bestBefore: String,
    @ColumnInfo(name = "nutrition") var nutrition: String,
    @ColumnInfo(name = "manufacturer") var manufacturer: String,
    @ColumnInfo(name = "image") var image: String,
    @TypeConverters(TimestampConverter::class)
    @ColumnInfo(name = "date")
    var date: Date?
){
    constructor():this(0,"","", "", "", "","","","","", null)

}