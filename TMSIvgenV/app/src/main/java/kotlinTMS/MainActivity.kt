package kotlinTMS

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.dz1.Dz1Activity
import kotlinTMS.dz2.Dz2Activity
import kotlinTMS.dz3.Dz3Activity


class MainActivity : AppCompatActivity() {

    lateinit var buttonDz1:Button
    lateinit var buttonDz2:Button
    lateinit var buttonDz3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDz1 = findViewById(R.id.dz1button)
        buttonDz2 = findViewById(R.id.dz2button)
        buttonDz3 = findViewById(R.id.dz3button)


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

    }

}
