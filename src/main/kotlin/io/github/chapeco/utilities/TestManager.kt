package io.github.chapeco.utilities

import cucumber.api.event.Event

interface TestManager
{
    fun addToFeatureMap(event: Event)

    fun updateCurrentFeature(designation: String)

    fun setCurrentScenarioLabel(line: Int)

    fun resetSteps()
}