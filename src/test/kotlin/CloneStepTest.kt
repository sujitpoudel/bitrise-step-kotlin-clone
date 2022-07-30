import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class CloneStepTest {
    @Test
    fun runTest() {
        val cloneDest = "build/testdir/2/1"
        File(cloneDest).deleteRecursively()
        val subject = CloneStep(
            config = CloneConfig().apply {
                repository_url = "https://github.com/sujitpoudel/bitrise-step-kotlin-clone.git"
                clone_destination = cloneDest
            }
        )
        subject.run()
        assertTrue(File(cloneDest).exists())
    }

    @Test
    fun cloneTest() {
        val cloneDest = "build/testdir/2/1"
        File(cloneDest).deleteRecursively()
        val subject = CloneStep(
            config = CloneConfig().apply {
                repository_url = "https://github.com/sujitpoudel/bitrise-step-kotlin-clone.git"
                clone_destination = cloneDest
            }
        )
        subject.run()
        assertTrue(File(cloneDest).exists())
    }
}