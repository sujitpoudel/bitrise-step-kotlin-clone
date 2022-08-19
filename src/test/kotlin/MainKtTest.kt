import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junitpioneer.jupiter.SetEnvironmentVariable
import java.io.File

internal class MainKtTest {
    @Test
    @SetEnvironmentVariable(key = "repository_url", value = "https://github.com/sujitpoudel/bitrise-step-kotlin-clone.git")
    @SetEnvironmentVariable(key = "clone_destination", value = "build/testenv/4")
    fun mainTest() {
        main(args = arrayOf())
        val dest = System.getenv("clone_destination")
        assertNotNull(dest)
        assertTrue(File(dest).exists())
    }
}