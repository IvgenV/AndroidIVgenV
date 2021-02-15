package kotlinTMS.lesson1


class Admin(override var name: String, override var id: Int) : User() {

    var list = mutableListOf<ConsumersInfo>()

    fun add(id:Int ,note:String){

        var consumersInfo = ConsumersInfo(id,note)
        list.add(consumersInfo)

    }

    fun toText(id:Int):String{

        return "Id: ${list[id].id}, note : ${list[id].note}"

    }

}