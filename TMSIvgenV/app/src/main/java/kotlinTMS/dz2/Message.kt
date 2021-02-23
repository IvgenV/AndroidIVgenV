package kotlinTMS.dz2

import java.util.*

data class Message(
        var id:Int,
        val senderId:Int = 0,
        var text:String,
        val date:Date = Date()
) {

   /* operator fun plus(message: Message):Message{
        return this.copy(text = this.text + "\n" + "id: ${message.id} " +  message.text)
    }*/

    fun simpleText():String{
        return "Id: $id, Text: $text\n"
    }

    override fun toString(): String {
        return "Id: $id, Time:$date, Text:$text\n"
    }

    inline fun lowerCase(text:String):String{

        return text.toLowerCase()

    }

    inline fun upperCase(text: String):String{

        return text.toUpperCase()

    }

}