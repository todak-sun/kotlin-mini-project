package io.study.kotlin.kotlinminiproject.domain

class Leg {

    val id: Int
    val steps: List<Step>
    val destination: Destination

    val numberOfStep: Int
        get() = this.steps.size

    constructor(id: Int, numberOfStep: Int, destination: Destination) {
        this.id = id
        this.steps = (1 .. numberOfStep).map { Step(it) }.toList()
        this.destination = destination
    }

    fun getStep(step: Int): Step {
        return steps[step - 1]
    }

    fun go(): LadderIterationRoute {
        for (step in 1 .. this.steps.size) {
            this.steps[step - 1]
        }d
    }

    fun next() {

    }

}

class Step(
    val value: Int,
    var left: Rung = EmptyRung(),
    var right: Rung = EmptyRung(),
) {
    fun move(current: Leg): Leg {
        if (left is ConnectedRung) {
            return left.left
        } else if (right is ConnectedRung) {
            return right.right
        } else {
            return current
        }
    }
}

class LadderIterationRoute {
    val routes: MutableList<Leg> = mutableListOf()

    fun add(leg: Leg) {
        this.routes.add(leg)
    }


}
