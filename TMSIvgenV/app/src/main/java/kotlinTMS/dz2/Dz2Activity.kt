package kotlinTMS.dz2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import java.lang.NumberFormatException

class Dz2Activity : AppCompatActivity() {

    lateinit var userIdTV: TextView
    lateinit var chat:TextView
    lateinit var button: Button
    lateinit var inputUserId: EditText
    lateinit var inputMessage: EditText
    lateinit var inputEditId:EditText

    val userIVgen = 1
    val userSasha = 2
    var id = 0
    var userId = 0
    var editId = 0
    var idMessage = 0
    var message: Message? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz2)

        userIdTV = findViewById(R.id.userId)
        button = findViewById(R.id.sendButton)
        inputUserId = findViewById(R.id.inputUserId)
        inputMessage = findViewById(R.id.inputMessage)
        inputEditId = findViewById(R.id.idEditText)
        chat = findViewById(R.id.chat)


        button.setOnClickListener{

            try {
                userId = inputUserId.text.toString().toInt()
                editId = inputEditId.text.toString().toInt()
            } catch (e:NumberFormatException){
                e.printStackTrace()
            }


            if(inputUserId.text.isEmpty()){
                Toast.makeText(applicationContext,"Input id!", Toast.LENGTH_SHORT).show()
            }else if(userId!=1&&userId!=2){
                Toast.makeText(applicationContext,"This user not found!", Toast.LENGTH_SHORT).show()
            }else if(editId!=1&&editId!=2&&inputEditId.text.isNotEmpty()){
                Toast.makeText(applicationContext,"This edit setting not found!", Toast.LENGTH_SHORT).show()
            }else if(userId==userIVgen||userId==userSasha){

                when {
                    inputMessage.text.isEmpty() -> {
                        Toast.makeText(applicationContext,"Input something in a field input message!",
                                Toast.LENGTH_SHORT).show()
                    }
                    message==null -> {

                        id = userId

                        when {
                            inputEditId.text.isEmpty() -> {
                                message = Message(id = idMessage,text = inputMessage.text.toString())
                                inputMessage.setText("")
                                idMessage++
                                chat.text = message!!.toString()
                            }
                            editId==1 -> {
                                message = Message(id = idMessage,text = inputMessage.text.toString())
                                inputMessage.setText("")
                                idMessage++
                                message!!.text = EditMessage({text->message!!.lowerCase(text)},message!!.text).toString()
                                chat.text = message!!.toString()
                            }
                            editId==2 -> {
                                message = Message(id = idMessage,text = inputMessage.text.toString())
                                inputMessage.setText("")
                                idMessage++
                                message!!.text = EditMessage({text->message!!.upperCase(text)},message!!.text).toString()
                                chat.text = message!!.toString()
                            }

                        }
                    }

                    id==userId -> {

                        when {
                            inputEditId.text.isEmpty() -> {
                                message!!.id = idMessage
                                message!!.text = inputMessage.text.toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText()
                            }
                            editId==1 -> {
                                message!!.id = idMessage
                                message!!.text = EditMessage({text->message!!.lowerCase(text)},inputMessage.text.toString())
                                        .toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText()
                            }
                            editId==2 -> {
                                message!!.id = idMessage
                                message!!.text = EditMessage({text->message!!.upperCase(text)},inputMessage.text.toString())
                                        .toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText()
                            }
                        }
                    }
                    id!=userId -> {

                        when{

                            inputEditId.text.isEmpty() -> {
                                id = userId
                                message!!.id = idMessage
                                message!!.text = inputMessage.text.toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.toString()
                            }

                            editId==1 -> {
                                id = userId
                                message!!.id = idMessage
                                message!!.text = EditMessage({text->message!!.lowerCase(text)},inputMessage.text.toString())
                                        .toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText()
                            }

                            editId==2 -> {
                                id = userId
                                message!!.id = idMessage
                                message!!.text = EditMessage({text->message!!.upperCase(text)},inputMessage.text.toString())
                                        .toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText()
                            }

                        }

                    }
                }

            }

        }
    }
}