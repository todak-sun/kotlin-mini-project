package io.study.kotlin.kotlinminiproject.domain

data class Legs(val legs: List<Leg>) {
    fun getMovedPosition(currentPosition: Int): Int {
        val leg = this.legs[currentPosition - 1]

        if(leg.left) {
            return currentPosition - 1
        }
        if(leg.right) {
            return currentPosition + 1
        }
        return currentPosition
    }
}