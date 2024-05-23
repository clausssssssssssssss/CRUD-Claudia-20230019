package RecyclerViewHelper

import Claudia.Ortega.crudclaudia2a.R
import Modelo.ClassConexion
import Modelo.DataClassProductos
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Adaptador(private var Datos: List<DataClassProductos>) : RecyclerView.Adapter<ViewHolder>() {

    fun ActualizarLista(nuevaLista: List<DataClassProductos>){
        Datos = nuevaLista
        notifyDataSetChanged()

    }
    fun eliminarRegristro(nombreProductos: String, posicion: Int){

        ///2.Crear el elemento de la lista
        val ListaDatos = Datos.toMutableList()
        ListaDatos.removeAt(posicion)

        ///3.Quitar de la base de datos
        GlobalScope.launch(Dispatchers.IO){
            ///1.Crear un pbjeto de la clase conexion
            val objConexion = ClassConexion().cadenaConexion()
            val delProducto =  objConexion?.prepareStatement("delete tbproductos where nombreProducto = ?")!!
            delProducto.setString(1,nombreProductos)
            delProducto.executeUpdate()

            val commit = objConexion.prepareStatement("commit")!!
            commit.executeUpdate()
        }
        Datos = ListaDatos.toList()
        notifyItemChanged(posicion)
        notifyDataSetChanged()

        fun actualizarProducto(nombreProducto: String, uuid: String){

            //1.Creo una corrutina
            GlobalScope.launch(Dispatchers.IO){
                
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista =            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(vista)

    }
    override fun getItemCount() = Datos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = Datos[position]
        holder.textView.text = producto.nombreProductos

        val item = Datos[position]
        holder.imgBorrar.setOnClickListener {

            holder.imgBorrar.setOnClickListener {

            //Creamos una alerta

                //1-Creamos el contexto
                val context = holder.itemView.context

                //2.Creo la alerta
                val builder = AlertDialog.Builder(context)

                //3.Ponerle un title a mi alerta
                builder.setTitle("¿Estas seguro?")

                //4.Paso final, agregamos los botones
                builder.setPositiveButton("si"){ dialog, wich ->
                    eliminarRegristro(item.nombreProductos, position)

                }

                builder.setNegativeButton("no"){ dialog, wich ->

                }
                //Creamos la alerta
                val alertDialog = builder.create()
                //Mostramos la alerta
                alertDialog.show()
            }
        }
    }
}