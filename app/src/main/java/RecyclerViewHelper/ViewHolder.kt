package RecyclerViewHelper

import Claudia.Ortega.crudclaudia2a.R
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.txtProductoCard)
        val imgEditar: ImageView = view.findViewById(R.id.imgEditar)
        val imgBorrar: ImageView = view.findViewById(R.id.imgBorrar)
    }
