package environment

data class EnvKey(
    val required: Boolean,
    val name: String,
    var value: String? = null
)