import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required

object StepArgsHandler {
    fun getConfig(args: Array<String>): CloneConfig {
        return try {
            val config = CloneConfig()
            config.loadFromEnv()
            config
        } catch (e: ConfigException) {
            parsePassedParams(args = args)
        }
    }

    private fun parsePassedParams(args: Array<String>): CloneConfig {
        val parser = ArgParser("bitrise-step-kotlin-clone")
        val repositoryUrl by parser.option(ArgType.String, shortName = "u", description = "Repository URL").required()
        val cloneDestination by parser.option(ArgType.String, shortName = "d", description = "Destination to clone to").required()
        val checkoutBranch by parser.option(ArgType.String, shortName = "b", description = "Branch to clone").default("main")
        parser.parse(args)
        val config = CloneConfig().apply {
            load(
                repository_url = repositoryUrl,
                clone_destination = cloneDestination,
                checkout_branch = checkoutBranch,
            )
        }
        return config
    }
}