package kotlinTMS

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.lesson1.Admin
import kotlinTMS.lesson1.Consumer

class MainActivity : AppCompatActivity() {

    lateinit var tvtext:TextView
    var admn = Admin("Admin",1)
    var consumer1 = Consumer("Alexei",1,33)
    var consumer2 = Consumer("Natasha",2,26)
    var consumer3 = Consumer("Ivgen",3,27)
    var consumer4 = Consumer("Sasha",4,35)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvtext = findViewById(R.id.tvText)

        admn.addIdConsumer(consumer1,"Надежный товарищ")
        admn.addIdConsumer(consumer2,"Не доверять")
        admn.addIdConsumer(consumer3,"Пойдет")
        admn.addIdConsumer(consumer4,"Не связываться!")

        tvtext.text = admn.countOfConsumers().toString()

    }

}