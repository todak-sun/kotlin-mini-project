package io.study.kotlin.kotlinminiproject.domain

class Participants(participants: List<String>) {
    var participants: List<Participant>

    init {
        if (participants.size < 2 || participants.size > 100) {
            throw IllegalArgumentException("참가자의 수는 2명 이상 100명 이하 이어야 합니다.")
        }

        this.participants = participants.asSequence().map { Participant(it) }.toList()
    }

    fun addGhost(count: Int) {
        for (i in 0 until count) {
            this.participants += Participant("GHOST")
        }
    }

    fun get(i: Int): String {
        return this.participants[i - 1].name
    }

    fun size(): Int {
        return this.participants.size
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Participants

        if (participants != other.participants) return false

        return true
    }

    override fun hashCode(): Int {
        return participants.hashCode()
    }
}