package com.example.study.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "travel")
data class TravelEntity(
    @field:SerializedName("addr1")
    val addr1: String,
    @field:SerializedName("addr2")
    val addr2: String? = "",
    @field:SerializedName("areacode")
    val areacode: Int,
    @field:SerializedName("cat1")
    val cat1: String,
    @field:SerializedName("cat2")
    val cat2: String,
    @field:SerializedName("cat3")
    val cat3: String,
    @PrimaryKey
    @field:SerializedName("contentid")
    val contentid: Int,
    @field:SerializedName("contenttypeid")
    val contenttypeid: Int,
    @field:SerializedName("createdtime")
    val createdtime: Long,
    @field:SerializedName("dist")
    val dist: Int,
    @field:SerializedName("firstimage")
    val firstimage: String,
    @field:SerializedName("firstimage2")
    val firstimage2: String,
    @field:SerializedName("mapx")
    val mapx: String,
    @field:SerializedName("mapy")
    val mapy: String,
    @field:SerializedName("mlevel")
    val mlevel: Int,
    @field:SerializedName("modifiedtime")
    val modifiedtime: Long,
    @field:SerializedName("readcount")
    val readcount: Int,
    @field:SerializedName("sigungucode")
    val sigungucode: Int,
    @field:SerializedName("tel")
    val tel: String,
    @field:SerializedName("title")
    val title: String
)
