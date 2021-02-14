package kotlinTMS.lesson1


class Admin(override var name: String, override var id: Int) : User() {

    var listId:MutableMap<Int,String> = mutableMapOf()

    fun addIdConsumer(consumer: Consumer,str:String){
        listId[consumer.id] = str
    }

    fun countOfConsumers():Int{

        return listId.size

    }
}