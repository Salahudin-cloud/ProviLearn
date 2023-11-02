package com.example.provilearn.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Provinsi(
    val namaProvinsi : String ,
    val logoProvinsi : String ,
    val namaIbuKota : String,
    val luasProvinsi : String ,
    val totalPenduduk : String,
    val deskripsiProvinsi : String
) : Parcelable
