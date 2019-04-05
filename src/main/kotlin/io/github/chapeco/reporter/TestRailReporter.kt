package io.github.chapeco.reporter

import cucumber.api.event.*
import io.github.chapeco.utilities.TestManager

class TestRailReporter(
        val testManager: TestManager
) : ConcurrentEventListener {

    override fun setEventPublisher(publisher: EventPublisher)
    {
        publisher.registerHandlerFor(TestRunStarted::class.java) {

        }
        publisher.registerHandlerFor(TestSourceRead::class.java) {
            testManager.addToFeatureMap(it)
        }
        publisher.registerHandlerFor(TestCaseStarted::class.java) { event->
            testManager.updateCurrentFeature(event.testCase.scenarioDesignation)
            testManager.setCurrentScenarioLabel(event.testCase.line)
            testManager.resetSteps()
        }
        publisher.registerHandlerFor(TestCaseFinished::class.java) {

        }
    }
}