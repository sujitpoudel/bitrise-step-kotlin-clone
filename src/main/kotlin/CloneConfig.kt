import environment.EnvKey
import environment.EnvKeys

@Suppress("PropertyName", "PrivatePropertyName", "EnumEntryName")
class CloneConfig : StepConfig {
    enum class Names {
        repository_url,
        clone_destination,
        checkout_branch
    }

    override val envKeys = EnvKeys(
        EnvKey(required = true, name = Names.repository_url.name),
        EnvKey(required = true, name = Names.clone_destination.name),
        EnvKey(required = false, name = Names.checkout_branch.name)
    )

    var repository_url
        get() = envKeys[Names.repository_url.name]!!
        set(value) {
            envKeys[Names.repository_url.name] = value
        }

    var clone_destination
        get() = envKeys[Names.clone_destination.name]!!
        set(value) {
            envKeys[Names.clone_destination.name] = value
        }

    var checkout_branch
        get() = envKeys[Names.checkout_branch.name]
        set(value) {
            envKeys[Names.checkout_branch.name] = value
        }

    fun load(repository_url: String, clone_destination: String, checkout_branch: String?) {
        this.repository_url = repository_url
        this.clone_destination = clone_destination
        this.checkout_branch = checkout_branch
    }
}