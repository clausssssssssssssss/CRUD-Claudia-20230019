package Claudia.Ortega.crudclaudia2a

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.util.UUID

class detalle_producto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_producto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //1.Mando a llamar a todos los elementos a la pantalla
        val txtUUID = findViewById<TextView>(R.id.txtUUIDDetalle)
        val txtNombre = findViewById<TextView>(R.id.txtNombreDetalle)
        val txtPrecio = findViewById<TextView>(R.id.txtPrecioDetalle)
        val txtCantidad = findViewById<TextView>(R.id.txtCantidadDetalle)
        val imgAtras = findViewById<ImageView>(R.id.imgAtras)

        //2.Recibir los valores
        val UUIDProducto = intent.getStringExtra("uuid")
        val NombreProducto = intent.getStringExtra("nombre")
        val PrecioProducto = intent.getIntExtra("precio", 0)
        val CantidadProducto = intent.getIntExtra("cantidad", 0)


        //3.Poner valores recibidos en el textView
        txtUUID.text = UUIDProducto
        txtNombre.text = NombreProducto
        txtPrecio.text = PrecioProducto.toString()
        txtCantidad.text = CantidadProducto.toString()

        //1.Ir una pantalla atras
        imgAtras.setOnClickListener{
            val pantallaAtras = Intent(this, MainActivity::class.java)
            startActivity(pantallaAtras)
        }
    }
}