package com.arabapps.utils.image_picker

import android.Manifest
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import java.io.File

private const val TAG = "ImagePicker"

class ImagePickerHelper(
    private val activity: AppCompatActivity? = null,
    private val fragment: Fragment? = null,
    private val onImagePicked: (uri: Uri?, file: File?) -> Unit
) {
    private var imageFile: File? = null


    /**
     * Gets the image file from the given URI.
     *
     * @param uri The URI of the image file.
     * @return The image file, or `null` if the URI is invalid.
     */
    private fun getImageFromUri(uri: Uri?): File? {
        val path = uri?.let { getPathFromURI(uri).toString() }.toString()
        return uri?.let { File(path) }
    }

    private val pickImage = (activity ?: fragment)?.registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { result ->
        onImagePicked(result, getImageFromUri(result))
    }

    /**
     * Registers a callback function to be called when an image has been picked from the gallery.
     *
     * @param onImagePicked The callback function to be called.
     */

    private fun checkCameraPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            (activity ?: fragment?.context)!!, Manifest.permission.CAMERA
        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            (activity ?: fragment?.requireActivity())!!, arrayOf(Manifest.permission.CAMERA), 1
        )
    }

    private fun checkFilePermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            (activity ?: fragment?.context)!!, Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    private fun requestFilePermission() {
        ActivityCompat.requestPermissions(
            (activity ?: fragment?.requireActivity())!!,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            2
        )
    }

    fun launchPickImageFromGallery() {
        // if android13 don't ask for permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pickImage?.launch("image/*")
        } else {
            if (checkFilePermission()) {
                pickImage?.launch("image/*")
            } else {
                requestFilePermission()
            }
        }
    }

    /**
     * Registers a callback function to be called when an image has been taken with the camera.
     *
     * @param onImagePicked The callback function to be called.
     */

    private val pickImageFromCamera = (activity ?: fragment)?.registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { result ->
        if (result && imageFile != null) {
            onImagePicked(Uri.fromFile(imageFile), imageFile)
        }
    }

    private fun getPathFromURI(uri: Uri): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = (activity ?: fragment?.context)?.contentResolver?.query(
            uri, projection, null, null, null
        )
        val columnIndex = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor?.moveToFirst()
        val path = cursor?.getString(columnIndex ?: -1)
        cursor?.close()
        return path
    }

    /**
     * Registers a callback function to be called when an image has been taken with the camera.
     *
     * @param onImagePicked The callback function to be called.
     */
    fun pickImageFromCamera() {
        if (checkCameraPermission()) {
            imageFile = createImageFile()
            launchCamera(imageFile!!)

        } else {
            requestCameraPermission()
        }

//            imageFile = createImageFile()
//            launchCamera(imageFile!!)
    }

    /**
     * Launches the camera to take a picture.
     *
     * @param imageFile The file in which the image will be saved.
     */
    private fun launchCamera(imageFile: File) = pickImageFromCamera?.launch(
        FileProvider.getUriForFile(
            (activity ?: fragment?.context)!!,
            (activity ?: fragment?.context)?.packageName + ".provider",
            imageFile
        )

    )


    /**
     * Creates a new image file.
     *
     * @return The new image file, or `null` if the file could not be created.
     */
    private fun createImageFile(): File {
        if ((activity ?: fragment?.context)?.getExternalFilesDir(null) == null) {
            return File("")
        }
        return File.createTempFile(
            "JPEG_${System.currentTimeMillis()}_",
            ".jpg",
            (activity ?: fragment?.context)?.getExternalFilesDir(null)
        )
    }

}


/*
  D  setupActions:imagggg file:///storage/emulated/0/Android/data/com.digo.edu/files/JPEG_1693997238305_1508685627936828447.jpg  filee /storage/emulated/0/Android/data/com.digo.edu/files/JPEG_1693997238305_1508685627936828447.jpg
  D  setupActions:imagggg content://media/picker/0/com.android.providers.media.photopicker/media/1000034456  filee /sdcard/.transforms/synthetic/picker/0/com.android.providers.media.photopicker/media/1000034456.jpg*/
