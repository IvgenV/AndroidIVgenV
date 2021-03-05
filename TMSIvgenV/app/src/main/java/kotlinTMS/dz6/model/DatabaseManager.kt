package kotlinTMS.dz6.model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri
import java.net.URL

class DatabaseManager(context: Context) {

    private var sp = context.getSharedPreferences("Shared", MODE_PRIVATE)
    private val age = "age"
    private val avatar = "avatar"

    fun getage():Int{
        return sp.getInt(age,370)
    }

    fun changeAge(newAge:Int){
        sp.edit().putInt(age,newAge).commit()
    }

    fun getUrl():String{
        return  sp.getString(avatar,"https://media.istockphoto.com/vectors/error-page-or-file-not-found-icon-vector-id924949200")!!
    }

    fun changeUrl(url:String){
        sp.edit().putString(avatar,url).commit()
    }

}