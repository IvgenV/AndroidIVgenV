package kotlinTMS.dz3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.dz1.Consumer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class Dz3Activity : AppCompatActivity() {

    lateinit var button:Button
    lateinit var tvText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz3)

        button = findViewById(R.id.invisibleButton)
        tvText = findViewById(R.id.textVDZ3)
        button.vissible()
        sorUsers()

           button.setOnClickListener {
                GlobalScope.async {
                    tvText.text =  SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date()) + '\n'
                    delay(5000)
                    tvText.text =  tvText.text.toString() + SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
                }
            }

    }

    fun Button.vissible(){

        visibility = Button.VISIBLE

        text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

    }

    fun sorUsers(){

        var list = mutableListOf(
                Consumer("Ivgen",1,27),
                Consumer("Sasha",2,33),
                Consumer("Tanya",3,25),
                Consumer("Grisha",4,27),
                Consumer("Kate",5,26)
        )

        var list2 = list.sortedWith(compareBy({it.age},{it.id}))
        for(i in list2){
            tvText.text = tvText.text.toString() + "Age: ${i.age}, id: ${i.id}, name: ${i.name}\n"
        }
    }

    suspend fun fakeServer():String{

        val str1 = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        delay(5000)
        val str2 = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        return str1 + '\n' + str2
    }

}