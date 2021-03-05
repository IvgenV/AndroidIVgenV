package kotlinTMS.dz6.view

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tmsivgenv.R
import kotlinTMS.dz6.model.DatabaseManager
import kotlinTMS.dz6.presenter.MainPresenter
import kotlinTMS.dz6.presenter.MainPresenterImpl

class Dz6Activity : AppCompatActivity(),Dz6MainView {

    lateinit var buttonChangeAge:Button
    lateinit var buttonChangeAvatar:Button
    lateinit var name:TextView
    lateinit var ageText:TextView
    lateinit var inputAge:EditText
    lateinit var inputUrl:EditText
    lateinit var avatar:ImageView
    lateinit var mainpresenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6)
        buttonChangeAge = findViewById(R.id.changeAgeButton)
        buttonChangeAvatar = findViewById(R.id.changeAvatarButton)
        ageText = findViewById(R.id.age)
        name = findViewById(R.id.name)
        inputAge = findViewById(R.id.inputAge)
        inputUrl = findViewById(R.id.inputUrl)
        avatar = findViewById(R.id.avatar)


        mainpresenter = MainPresenterImpl(DatabaseManager(this),this)
        mainpresenter.requestAge()
        mainpresenter.requestUrl()

        buttonChangeAge.setOnClickListener {
            mainpresenter.changeAge()
            mainpresenter.requestAge()
        }

        buttonChangeAvatar.setOnClickListener {
            mainpresenter.changeUrl()
            mainpresenter.requestUrl()
        }

    }

    override fun setAge(age: Int) {
        ageText.text = age.toString()
    }

    override fun changeAge():Int {
        return if(inputAge.text.isEmpty()){
            Toast.makeText(this,"Input age!", Toast.LENGTH_SHORT).show()
            -1
        } else
            inputAge.text.toString().toInt()
    }

    override fun setAvatar(url: String) {
        Glide.with(this).load(url).circleCrop().into(avatar)
    }

    override fun changeUrl(): String {
        return if(inputUrl.text.isEmpty()){
            Toast.makeText(this,"Input url!", Toast.LENGTH_SHORT).show()
            "Error 404!"
        } else
            inputUrl.text.toString()
    }

}