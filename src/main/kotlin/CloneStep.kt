import org.eclipse.jgit.api.Git
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
//import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.deleteExisting

class CloneStep(private val config: CloneConfig) {
    private fun mkCloneDestination(path: Path) {
        path.toFile().deleteRecursively()
        path.createDirectories()
    }

    fun run() {
        val path = Path(config.clone_destination)
        mkCloneDestination(path)
        Git.cloneRepository()
            .setURI(config.repository_url)
            .setBranch(config.checkout_branch)
            .setDirectory(path.toFile())
            .call()
        println("Cloned ${config.repository_url} @ `${config.checkout_branch}` into: ${path.absolutePathString()}")
    }
}
