package sv.edu.ufg.fis.amd.activity_datos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombres: EditText
    private lateinit var txtApellido: EditText
    private lateinit var txtEmail:EditText
    private  lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombres = findViewById(R.id.txt_nombres)
        txtApellido = findViewById(R.id.txt_apellidos)
        txtEmail = findViewById(R.id.txt_email)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            if (txtNombres.getText().toString().isNullOrEmpty() || txtApellido.getText().toString().isNullOrEmpty() || txtEmail.getText().toString().isNullOrEmpty()){
                mensaje("Campos vacios", "Se ha detectado que al menos un campo esta vacio")

            }else{
                val intent = Intent(this,ActivityRecepecionDatos::class.java)
                intent.putExtra("nombres", txtNombres.getText().toString())
                intent.putExtra("apellidos", txtApellido.getText().toString())
                intent.putExtra("email", txtEmail.getText().toString())
                startActivity(intent)
            }

        }

    }
    fun mensaje(titulo:String,mensaje:String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage(mensaje)
            .setTitle(titulo)
            .setPositiveButton("Aceptar") { _, _ ->
                // Do something.
            }
        /*.setNegativeButton("Cancelar") { _, _ ->
            // Do something else.
        }*/

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}