package kotlinTMS.dz1


class Admin( id:Int,name:String) : User(id,name) {

    var list = mutableListOf<ConsumersInfo>()

    fun add(consumer:Consumer,note:String){

        val consumersInfo = ConsumersInfo(consumer.id,note)
        list.add(consumersInfo)

    }

    override fun toString(): String {
        var noteString = ""
        list.forEach{noteString += "id: {${it.id}}, note: {${it.note}}\n"}
        return noteString
    }


}
data class ConsumersInfo(var id:Int,var note:String)