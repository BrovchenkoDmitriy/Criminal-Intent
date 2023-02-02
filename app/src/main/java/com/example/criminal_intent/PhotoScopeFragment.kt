package com.example.criminal_intent


import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.io.File
import java.util.zip.Inflater

private const val PHOTO_FILE = "photo file"
private const val ARG_IMAGE = "image"
private const val ARG_TITLE = "title"

class PhotoScopeFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.photo_scope, null)
            builder.setView(view)
            //val crimePicture: ImageView
            val crimePicture = view.findViewById(R.id.photo_scope_image) as ImageView
            val photoFile = arguments?.getSerializable(ARG_IMAGE) as File
            val title = arguments?.getSerializable(ARG_TITLE) as String
            val bitmap =
                PictureUtils().getRotatedBitmap(PictureUtils().getScaledBitmap(photoFile.path, requireActivity()), ExifInterface(photoFile.path))
            crimePicture.setImageBitmap(bitmap)
            crimePicture.maxWidth
            //crimePicture.scaleType = "fitCenter"
           // crimePicture.maxWidth = BitmapFactory.Options().outWidth
           // crimePicture.maxHeight = BitmapFactory.Options().outHeight
            //builder.setTitle(title)
            //    .setNegativeButton(R.string.Dissmis, DialogInterface.OnClickListener{ _, _ -> dialog?.cancel() } )


            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Acitivity cannot be null")

        }
    companion object {
        fun newInstance(photoFile: File, title: String): PhotoScopeFragment {
            val args = Bundle().apply { putSerializable(ARG_IMAGE, photoFile)
            putSerializable(ARG_TITLE, title)}

            return PhotoScopeFragment().apply { arguments = args }

        }

    }

}