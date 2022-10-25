package io.study.kotlin.kotlinminiproject.domain

class Destinations(destinations: List<String>) {
    var destinations: List<Destination>

    init {
        this.destinations = destinations.asSequence().map{Destination(it)}.toList()
    }

    fun addNone(count: Int) {
        for (i in 0 until count) {
            this.destinations += Destination("NONE")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Destinations

        if (destinations != other.destinations) return false

        return true
    }

    override fun hashCode(): Int {
        return destinations.hashCode()
    }
}
