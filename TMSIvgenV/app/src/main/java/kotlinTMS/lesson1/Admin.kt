package kotlinTMS.lesson1


class Admin(override var name: String, override var id: Int) : User() {

    var list = ListOfConsumers()

    fun add(id:Int ,consumer:Consumer){

        list.consumersList[id] = consumer

    }

    fun toText(id:Int):String{

        return "Name : ${list.consumersList[id]!!.name}, id = ${list.consumersList[id]!!.id}, age = " +
                "${list.consumersList[id]!!.age}"


    }

}