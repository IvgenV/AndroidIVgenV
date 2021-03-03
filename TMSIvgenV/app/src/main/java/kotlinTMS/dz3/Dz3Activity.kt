package kotlinTMS.dz3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.dz1.Consumer
import kotlinx.coroutines.*
import java.net.URL
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
        button.visible()
        sortUsers()


        button.setOnClickListener {

           GlobalScope.launch {

               val response = fakeserver()

               Log.e("Response fun",response.toString())

               tvText.post{
                   tvText.text = response.toString()
               }

            }

        }

    }

    private fun Button.visible(){

        visibility = Button.VISIBLE

        text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

    }

    fun sortUsers(){

        val list = mutableListOf(
                Consumer("Ivgen",1,27),
                Consumer("Sasha",2,33),
                Consumer("Tanya",3,25),
                Consumer("Grisha",4,27),
                Consumer("Kate",5,26)
        )

        val list2 = list.sortedWith(compareBy({it.age},{it.id}))
        for(i in list2){
            tvText.text = "${tvText.text} Age: ${i.age}, id: ${i.id}, name: ${i.name}\n"
        }
    }

    suspend fun fakeserver():Response{
        val start = "Time message sending: " + SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date()) + '\n'
        delay(3000)
        val end = "Time of message receipt: " + SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date()) + '\n' +
                URL("https://jsonplaceholder.typicode.com/todos/1").readText()
        return Response(start,end)
    }

}