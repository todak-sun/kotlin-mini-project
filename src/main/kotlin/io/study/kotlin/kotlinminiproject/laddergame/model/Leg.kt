package io.study.kotlin.kotlinminiproject.laddergame.model


class Leg(
    val order: Int,
    val participant: Participant,
    val destination: Destination,
) {
    private var left: Leg? = null
    private var right: Leg? = null
}