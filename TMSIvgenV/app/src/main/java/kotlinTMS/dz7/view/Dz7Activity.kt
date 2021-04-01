package kotlinTMS.dz7.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.dz7.model.Manager
import kotlinTMS.dz7.viewModel.ViewModel

class Dz7Activity : AppCompatActivity() {

    lateinit var button:Button
    lateinit var inputPassword:EditText
    lateinit var textPassword:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz7)

        button = findViewById(R.id.buttonDz7Password)
        inputPassword = findViewById(R.id.inputPasswordDz7)
        textPassword = findViewById(R.id.textPasswordDz7)
        val manager = Manager(this)

        val model = ViewModel(manager)

        if(manager.sp.getLong("Timer", 10000)<10000){
            model.passwordFromView(-1)
        }

        model.data.observe(this, { data ->
            if(model.data.value==-1){
                finish()
            }else textPassword.text = data.toString()
        })


        button.setOnClickListener {
            checkPassword(model)
        }

    }

    fun checkPassword(model:ViewModel){
        if(inputPassword.text.isEmpty()){
            Toast.makeText(applicationContext,"Input password!", Toast.LENGTH_SHORT).show()
        }else {
            model.passwordFromView(inputPassword.text.toString().toInt())
            if(model.data.value != inputPassword.text.toString().toInt()){
                Toast.makeText(applicationContext,"Input new password quickly!", Toast.LENGTH_SHORT).show()
            } else if(model.data.value == inputPassword.text.toString().toInt()){
                Toast.makeText(applicationContext,"Success!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}