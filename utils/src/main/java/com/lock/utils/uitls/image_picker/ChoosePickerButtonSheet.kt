package com.arabapps.utils.image_picker

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lock.utils.R

class ChoosePickerButtonSheet() : BottomSheetDialogFragment(),
    View.OnClickListener {

    var onPickFromCamera: (() -> Unit)? = null
    var onPickFromGallery: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_picker_dialog, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setDimAmount(0.2f)

        setTransparentBackground()

        view.findViewById<TextView>(R.id.cancelTv).setOnClickListener(this)
        view.findViewById<TextView>(R.id.cameraTv).setOnClickListener(this)
        view.findViewById<TextView>(R.id.galleryTv).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.galleryTv -> onPickFromGallery?.invoke()
            R.id.cameraTv -> onPickFromCamera?.invoke()
        }
        dismiss()
    }

    private fun BottomSheetDialogFragment.setTransparentBackground() {
        dialog?.apply {
            setOnShowListener {
                val bottomSheet =
                    findViewById<View?>(com.google.android.material.R.id.design_bottom_sheet)
                bottomSheet?.setBackgroundResource(android.R.color.transparent)
            }
        }
    }
}