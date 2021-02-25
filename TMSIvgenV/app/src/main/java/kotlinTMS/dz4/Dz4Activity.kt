package kotlinTMS.dz4

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tmsivgenv.R

class Dz4Activity : AppCompatActivity() {

    lateinit var login:EditText
    lateinit var password:EditText
    lateinit var textResult:TextView
    lateinit var buttonLogin:Button
    lateinit var buttonAddUser:Button
    lateinit var checkBox1:CheckBox
    lateinit var checkBox2:CheckBox
    lateinit var checkBox3:CheckBox
    lateinit var listOfUsers:MutableList<UserDz4>
    var id = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz4)

        password = findViewById(R.id.inputPassword)
        login = findViewById(R.id.inputLogin)
        textResult = findViewById(R.id.result)
        buttonLogin = findViewById(R.id.buttonDz4Login)
        buttonAddUser = findViewById(R.id.buttonDz4NU)
        checkBox1 = findViewById(R.id.checkBox1)
        checkBox2 = findViewById(R.id.checkBox2)
        checkBox3 = findViewById(R.id.checkBox3)


        listOfUsers = mutableListOf(
                UserDz4("Alesha","12345",id),
                UserDz4("Ivgen","ice",id++),
                UserDz4("Tanya","beautiful",id++),
                UserDz4("Sasha","pruha215",id++)
        )

        buttonLogin.setOnClickListener {

            when {
                findUser(login.text.toString(),password.text.toString())=="Wrong password" -> {
                    Toast.makeText(applicationContext,"Wrong password!",Toast.LENGTH_SHORT).show()
                }
                findUser(login.text.toString(),password.text.toString())=="Nothing found" -> {
                    Toast.makeText(applicationContext,"Nothing found!",Toast.LENGTH_SHORT).show()
                }
                else -> textResult.text = findUser(login.text.toString(),password.text.toString())
            }
            password.setText("")

        }

        buttonAddUser.setOnClickListener {

          if(addUser(login.text.toString())){
              listOfUsers.add(UserDz4(login.text.toString(),password.text.toString(),++id))
              Toast.makeText(applicationContext,"Successful added!",Toast.LENGTH_SHORT).show()
           } else if(!addUser(login.text.toString())) Toast.makeText(applicationContext,"This user already exist",Toast.LENGTH_SHORT).show()


        }

        checkBox1.setOnCheckedChangeListener{ _, isChecked ->

            if(isChecked){
                changeColorButtonAdUser()
            }else if(!isChecked){
                defaultColorButtonAddUser()
            }

        }

        checkBox2.setOnCheckedChangeListener{_,isChecked->
            if(isChecked){
                changeButtonLogin()
            }else if(!isChecked){
                defaultColorButtonLogin()
            }
        }

        checkBox3.setOnCheckedChangeListener{_,isChecked->
            if(isChecked){
                changeColorTextResult()
            }else if(!isChecked){
                defaultColorTextResult()
            }
        }

    }

    private fun findUser(login:String, password:String):String{

        var text = ""

        for (i in listOfUsers){

            if(i.login == login &&i.password==password){
                text = "User: ${i.login}, id: $id"
                break
            }else if(i.login==login&&i.password!=password){
                text = "Wrong password"
                break
            } else text = "Nothing found"
        }

        return text
    }

    private fun addUser(login:String):Boolean{

        var successful = false

       for(i in listOfUsers){
           if(i.login==login){
               successful = false
               break
           }else successful = true
       }

        return successful

    }

    private fun defaultColorTextResult(){
        textResult.setTextColor(ContextCompat.getColor(applicationContext,R.color.black))
        textResult.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.white))
    }

    private fun changeColorTextResult(){
        textResult.setTextColor(ContextCompat.getColor(applicationContext,R.color.white))
        textResult.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.black))
    }

    private fun defaultColorButtonLogin(){
        buttonLogin.setTextColor(ContextCompat.getColor(applicationContext,R.color.white))
        buttonLogin.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.blue))
    }

    private fun changeButtonLogin(){
        buttonLogin.setTextColor(ContextCompat.getColor(applicationContext,R.color.blue))
        buttonLogin.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.white))
    }

    private fun defaultColorButtonAddUser(){
        buttonAddUser.setTextColor(ContextCompat.getColor(applicationContext,R.color.blue))
        buttonAddUser.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.yellow))
    }

    private fun changeColorButtonAdUser(){
        buttonAddUser.setTextColor(ContextCompat.getColor(applicationContext,R.color.yellow))
        buttonAddUser.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.blue))
    }

}