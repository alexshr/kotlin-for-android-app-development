val name: String? = null
val len = name?.length ?: 0  // Assigns length, or else zero as the default value

val len1=name.orEmpty().length
