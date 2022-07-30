fun main(args: Array<String>) {
    val config = StepArgsHandler.getConfig(args = args)
    CloneStep(config = config).run()
}
