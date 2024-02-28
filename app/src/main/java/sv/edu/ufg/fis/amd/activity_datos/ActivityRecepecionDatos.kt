package sv.edu.ufg.fis.amd.activity_datos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import  android.widget.Button

class ActivityRecepecionDatos : AppCompatActivity() {

    private lateinit var Nombres: TextView
    private lateinit var Apellido: TextView
    private lateinit var Email: TextView
    private  lateinit var Salir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recepecion_datos)

        Nombres = findViewById(R.id.output_nombres)
        Apellido = findViewById(R.id.output_apellidos)
        Email = findViewById(R.id.output_email)
        Salir = findViewById(R.id.btnLeave)

        val intent = intent
        val nombres = intent.getStringExtra("nombres")
        val apellidos = intent.getStringExtra("apellidos")
        val email = intent.getStringExtra("email")

        Nombres.text = nombres
        Apellido.text = apellidos
        Email.text = email

        Salir.setOnClickListener{
            finish()
        }
    }
}