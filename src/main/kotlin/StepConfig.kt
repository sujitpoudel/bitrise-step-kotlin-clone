import environment.EnvKey
import environment.EnvKeys

interface StepConfig {
    val envKeys: EnvKeys

    fun loadFromEnv() {
        envKeys.keys.forEach { (name, env) ->
            val data = System.getenv(name)
            if (data == null && env.required) {
                throw ConfigException("Required environment is not passed: $name")
            }
            envKeys.keys[name] = EnvKey(required = env.required, name = name, value = data)
        }
    }
}