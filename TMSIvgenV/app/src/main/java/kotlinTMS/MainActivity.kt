package kotlinTMS

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.lesson1.Admin
import kotlinTMS.lesson1.Consumer

class MainActivity : AppCompatActivity() {

    lateinit var tvtext:TextView
    var admin1 = Admin("Admin",1)
    var admin2 = Admin("Ivgen",2)
    var consumer1 = Consumer("Alexei",1,33)
    var consumer2 = Consumer("Natasha",2,26)
    var consumer3 = Consumer("Ivgen",3,27)
    var consumer4 = Consumer("Sasha",4,35)
    var consumer5 = Consumer("Grisha",5,28)
    var consumer6 = Consumer("Tanya",6,24)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvtext = findViewById(R.id.tvText)

        admin1.add(consumer1.id,"Frank man")
        admin1.add(consumer2.id,"Don't trust")
        admin1.add(consumer3.id,"Reliable man")
        admin2.add(consumer4.id,"Frank man")
        admin2.add(consumer5.id,"Dont't trust")
        admin2.add(consumer6.id,"Frank woman")

        tvtext.text = admin1.toText(2)
    }

}