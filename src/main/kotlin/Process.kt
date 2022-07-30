import java.io.File
import java.util.concurrent.TimeUnit

object Process {
    fun runCommand(cmd: String, workingDir: File) {
        ProcessBuilder(*cmd.split(" ").toTypedArray())
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor(300, TimeUnit.MINUTES)
    }
}