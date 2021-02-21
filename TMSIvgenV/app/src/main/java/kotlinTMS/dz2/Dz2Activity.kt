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

    lateinit var userId: TextView
    lateinit var chat:TextView
    lateinit var button: Button
    lateinit var inputUserId: EditText
    lateinit var inputMessage: EditText
    lateinit var inputEditId:EditText

    val userIVgen = 1
    val userSasha = 2
    var id = 0
    var idFromUser:Int? = null
    var idFromEdit:Int? = null
    var idMessage = 0
    var message: Message? = null
    lateinit var firstMessage:Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz2)

        userId = findViewById(R.id.userId)
        button = findViewById(R.id.sendButton)
        inputUserId = findViewById(R.id.inputUserId)
        inputMessage = findViewById(R.id.inputMessage)
        inputEditId = findViewById(R.id.idEditText)
        chat = findViewById(R.id.chat)

        ///chat.text = EditMessage({text->me.lowerCase(text)},me.text).toString()

        button.setOnClickListener{

            try {
                idFromUser = inputUserId.text.toString().toInt()
                idFromEdit = inputEditId.text.toString().toInt()
            } catch (e:NumberFormatException){
                e.printStackTrace()
            }


            if(inputUserId.text.isEmpty()){
                Toast.makeText(applicationContext,"Input id!", Toast.LENGTH_SHORT).show()
            }else if(idFromUser!=1&&idFromUser!=2){
                Toast.makeText(applicationContext,"This user not found!", Toast.LENGTH_SHORT).show()
            }else if(idFromEdit!=1&&idFromEdit!=2&&inputEditId.text.isNotEmpty()){
                Toast.makeText(applicationContext,"This edit setting not found!", Toast.LENGTH_SHORT).show()
            }else if(idFromUser==userIVgen||idFromUser==userSasha){

                when {
                    inputMessage.text.isEmpty() -> {
                        Toast.makeText(applicationContext,"Input something in a field input message!",
                                Toast.LENGTH_SHORT).show()
                    }
                    message==null -> {
                        id = idFromUser!!
                        idMessage++

                        if(idFromEdit==1){
                            message = Message(id = idMessage,text = inputMessage.text.toString())
                            inputMessage.setText("")
                            message!!.text = EditMessage({text->message!!.lowerCase(text)},message!!.text).toString()
                            chat.text = message!!.toString()
                        }else {
                            message = Message(id = idMessage,text = inputMessage.text.toString())
                            inputMessage.setText("")
                            message!!.text = EditMessage({text->message!!.upperCase(text)},message!!.text).toString()
                            chat.text = message!!.toString()
                        }
                    }
                    id==idFromUser -> {

                        when {
                            idFromEdit==1 -> {
                                message!!.id = idMessage
                                message!!.text = EditMessage({text->message!!.lowerCase(text)},inputMessage.text.toString())
                                        .toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText() + "Its to lover"
                            }
                            idFromEdit==2 -> {
                                message!!.id = idMessage
                                message!!.text = EditMessage({text->message!!.upperCase(text)},inputMessage.text.toString())
                                        .toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText() + "its to upper"
                            }
                            //////Не заходит в эту ветку, если inputEditId был сначала установен например
                            ///на значении 1 а затем значение было удалено, но если написать первое сообщение
                            /// с отсутствующим значением в inputEditId то хаходит
                            inputEditId.text.isEmpty() -> {
                                message!!.id = idMessage
                                message!!.text = inputMessage.text.toString()
                                idMessage++
                                inputMessage.setText("")
                                chat.text = chat.text.toString() + message!!.simpleText() + "its default"
                            }
                        }
                    }
                    id!=idFromUser -> {
                        id = idFromUser!!
                        message = Message(id = idMessage,text = inputMessage.text.toString())
                        idMessage++
                        inputMessage.setText("")
                        chat.text = chat.text.toString() + message!!.toString()
                    }
                }

            }

        }
    }
}