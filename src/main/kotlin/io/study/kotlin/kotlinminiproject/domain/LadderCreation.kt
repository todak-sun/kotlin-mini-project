package io.study.kotlin.kotlinminiproject.domain

class LadderCreation(participants: List<String>, destinations: List<String>, rung: Int?) {
    var participants: Participants
    var destinations: Destinations
    var rung: Rung

    init {
        this.participants = Participants(participants)
        this.destinations = Destinations(destinations)
        this.rung = Rung(rung)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LadderCreation

        if (participants != other.participants) return false
        if (destinations != other.destinations) return false
        if (rung != other.rung) return false

        return true
    }

    override fun hashCode(): Int {
        var result = participants.hashCode()
        result = 31 * result + destinations.hashCode()
        result = 31 * result + rung.hashCode()
        return result
    }
}