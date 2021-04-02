package kotlinTMS

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.dz1.Dz1Activity
import kotlinTMS.dz2.Dz2Activity
import kotlinTMS.dz3.Dz3Activity
import kotlinTMS.dz4.Dz4Activity
import kotlinTMS.dz5.Dz5Activity
import kotlinTMS.dz6.view.Dz6Activity
import kotlinTMS.dz8.view.Dz8Activity


class MainActivity : AppCompatActivity() {

    lateinit var buttonDz1:Button
    lateinit var buttonDz2:Button
    lateinit var buttonDz3:Button
    lateinit var buttonDz4:Button
    lateinit var buttonDz5:Button
    lateinit var buttonDz6:Button
    lateinit var buttonDz8:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializationButtons()
        startActivity()

    }

    private fun startActivity(){

        buttonDz1.setOnClickListener{
            val intent = Intent(this,Dz1Activity::class.java)
            startActivity(intent)
        }

        buttonDz2.setOnClickListener{
            val intent = Intent(this,Dz2Activity::class.java)
            startActivity(intent)
        }

        buttonDz3.setOnClickListener{
            val intent = Intent(this, Dz3Activity::class.java)
            startActivity(intent)
        }

        buttonDz4.setOnClickListener{
            val intent = Intent(this, Dz4Activity::class.java)
            startActivity(intent)
        }

        buttonDz5.setOnClickListener{
            val intent = Intent(this, Dz5Activity::class.java)
            startActivity(intent)
        }

        buttonDz6.setOnClickListener{
            val intent = Intent(this, Dz6Activity::class.java)
            startActivity(intent)
        }

        buttonDz8.setOnClickListener{
            val intent = Intent(this, Dz8Activity::class.java)
            startActivity(intent)
        }

    }

    fun initializationButtons(){

        buttonDz1 = findViewById(R.id.dz1button)
        buttonDz2 = findViewById(R.id.dz2button)
        buttonDz3 = findViewById(R.id.dz3button)
        buttonDz4 = findViewById(R.id.dz4button)
        buttonDz5 = findViewById(R.id.dz5button)
        buttonDz6 = findViewById(R.id.dz6button)
        buttonDz8 = findViewById(R.id.dz8button)

    }

}
