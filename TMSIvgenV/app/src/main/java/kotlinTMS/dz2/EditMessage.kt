package kotlinTMS.dz2

data class EditMessage (val filter: (String) -> String, val text: String) {
    override fun toString(): String {
        return filter(text)
    }
}