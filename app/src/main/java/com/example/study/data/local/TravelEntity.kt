package com.example.study.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "travel")
data class TravelEntity(
    @field:SerializedName("addr1")
    val address1: String,
    @field:SerializedName("addr2")
    val address2: String? = "",
    @field:SerializedName("areacode")
    val areaCode: Int,
    @field:SerializedName("cat1")
    val cat1: String,
    @field:SerializedName("cat2")
    val cat2: String,
    @field:SerializedName("cat3")
    val cat3: String,
    @PrimaryKey
    @field:SerializedName("contentid")
    val contentId: Int,
    @field:SerializedName("contenttypeid")
    val contentTypeId: Int,
    @field:SerializedName("createdtime")
    val createdTime: Long,
    @field:SerializedName("dist")
    val dist: Int,
    @field:SerializedName("firstimage")
    val firstImage: String,
    @field:SerializedName("firstimage2")
    val firstImage2: String,
    @field:SerializedName("mapx")
    val mapX: String,
    @field:SerializedName("mapy")
    val mapY: String,
    @field:SerializedName("mlevel")
    val mLevel: Int,
    @field:SerializedName("modifiedtime")
    val modifiedTime: Long,
    @field:SerializedName("readcount")
    val readCount: Int,
    @field:SerializedName("sigungucode")
    val siGunGuCode: Int,
    @field:SerializedName("tel")
    val tel: String,
    @field:SerializedName("title")
    val title: String
)
