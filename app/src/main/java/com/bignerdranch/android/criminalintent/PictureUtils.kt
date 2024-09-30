package com.bignerdranch.android.criminalintent

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlin.math.roundToInt

//scaling down images

fun getScaledBitmap(path: String, destwidth: Int, destHeight: Int): Bitmap {
    val options= BitmapFactory.Options()
    options.inJustDecodeBounds=true
    BitmapFactory.decodeFile(path,options)

    val srcWidth=options.outWidth.toFloat()
    val srcHeight=options.outHeight.toFloat()

    val sampleSize=if(srcHeight <= destHeight && srcWidth <= destwidth){
        1
    } else{
        val heightScale=srcHeight/destHeight
        val widthScale=srcWidth/destwidth

        minOf(heightScale, widthScale).roundToInt()
    }
    return BitmapFactory.decodeFile(path, BitmapFactory.Options().apply{
        inSampleSize=sampleSize
    })
}