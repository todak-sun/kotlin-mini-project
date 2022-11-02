package io.study.kotlin.kotlinminiproject.domain

class EmptyRung: Rung {
    override fun next(leg: Leg): Leg {
        return leg
    }

}

interface Rung {
    fun next(leg: Leg): Leg
}

class ConnectedRung(
    val left: Leg,
    val right: Leg,
): Rung {
    override fun next(leg: Leg): Leg {
        return if (leg == left) right else left
    }

}