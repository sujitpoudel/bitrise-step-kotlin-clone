package environment

import ConfigException

class EnvKeys(vararg args: EnvKey) {
    val keys: MutableMap<String, EnvKey> = mutableMapOf()
    init {
        args.forEach {
            keys[it.name] = it
        }
    }

    operator fun get(key: String): String? {
        val envKeyData = keys[key] ?: throw ConfigException("$key is not defined for this step")
        val envValue = envKeyData.value
        if (envValue == null && envKeyData.required) throw ConfigException("Required parameter `$key` is not passed to the step")
        return envValue
    }

    operator fun set(key: String, value: String?) {
        if (keys.containsKey(key)) {
            keys[key]?.value = value
        }
    }
}