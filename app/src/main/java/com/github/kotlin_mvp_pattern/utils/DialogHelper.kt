package com.github.kotlin_mvp_pattern.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window

import com.github.kotlin_mvp_pattern.R

object DialogHelper {

    fun confirm(context: Context, message: String,
                yes: DialogInterface.OnClickListener): AlertDialog {

        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.warning)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.y, yes)
        builder.setNegativeButton(R.string.t) { dialog, which -> dialog.cancel() }

        return builder.create()

    }

    fun loading(context: Context): Dialog {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_loading)
        return dialog

    }

    interface DialogCallback {
        fun onConfirm()

        fun onCancel()
    }

}
