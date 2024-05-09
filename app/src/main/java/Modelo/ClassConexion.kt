package Modelo

import java.sql.Connection
import java.sql.DriverManager

class ClassConexion {

    fun cadenaConexion(): Connection? {

       try{
           val url = "jdbc:oracle:thin:@10.10.0.65:1521:xe"
           val usuario = "system"
           val contrasena = "desarrollo"

           val conection = DriverManager.getConnection(url, usuario, contrasena)
           return conection
       }catch (e: Exception){
           println("Este es el error: $e")
           return null
        }

    }

}
