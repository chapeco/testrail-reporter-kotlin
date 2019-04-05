package io.github.chapeco.utilities

import cucumber.api.event.Event

internal class TestManagerImpl: TestManager
{
    private lateinit var configuration: Configuration
    private val features = mutableMapOf<String,List<String>>()

    override fun setCurrentScenarioLabel(line: Int) {
        configuration = configuration.copy(
                currentScenarioLabel = "(?<=scenario_label=).*$"
                        .toRegex()
                        .find(features[configuration.currentFeature]!![line].trim())!!
                        .value
        )
    }

    override fun resetSteps() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCurrentFeature(designation: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addToFeatureMap(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private data class Configuration(
            val currentScenarioLabel: String,
            val currentFeature: String
    )
}