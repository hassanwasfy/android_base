package com.dezz.uitls

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File


fun String?.convertToRequestBody(): RequestBody? {
    return this?.toRequestBody("text/plain".toMediaTypeOrNull())
}


fun File?.convertToRequestBody(): MultipartBody.Part? {
    val requestFile = this?.asRequestBody("image/*".toMediaTypeOrNull())
    return requestFile?.let { MultipartBody.Part.createFormData("avatar_path", this?.name, it) }
}
fun File?.convertPaymentImageToRequestBody(): MultipartBody.Part? {
    val requestFile = this?.asRequestBody("image/*".toMediaTypeOrNull())
    return requestFile?.let { MultipartBody.Part.createFormData("payment_path", this?.name, it) }
}