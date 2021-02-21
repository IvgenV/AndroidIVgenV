package kotlinTMS.dz1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R

class Dz1Activity:AppCompatActivity() {

    lateinit var tvText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz1)

        tvText = findViewById(R.id.Dz1TV)
        val admin1 = Admin(1,"admin")

        val listOfConsumer = listOf(
                Consumer("Alex",1,27),
                Consumer("Ivgen",2,27),
                Consumer("Sasha",3,25),
                Consumer("Tanya",4,26)
        )

        for (consumer in listOfConsumer){
            admin1.add(consumer,"It's a list of the admin1")
        }

        tvText.text = admin1.toString()
    }

}