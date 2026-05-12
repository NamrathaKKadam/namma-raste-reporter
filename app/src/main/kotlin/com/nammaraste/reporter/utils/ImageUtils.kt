package com.nammaraste.reporter.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

object ImageUtils {
    fun compressImage(imageFile: File, quality: Int = 80): File {
        val bitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream)
        val byteArray = stream.toByteArray()
        
        val compressedFile = File(imageFile.parent, "compressed_${imageFile.name}")
        val fos = FileOutputStream(compressedFile)
        fos.write(byteArray)
        fos.flush()
        fos.close()
        return compressedFile
    }
}
