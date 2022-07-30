import org.eclipse.jgit.api.Git
import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createDirectories

class CloneStep(private val config: CloneConfig) {
    private fun mkCloneDestination(destination: String) {
        val path = Path(destination)
        path.createDirectories()
    }

    fun run() {
        mkCloneDestination(config.clone_destination)
        Git.cloneRepository()
            .setURI(config.repository_url)
            .setBranch(config.checkout_branch)
            .setDirectory(File(config.clone_destination))
            .call()
    }
}
