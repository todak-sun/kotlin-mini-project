package io.study.kotlin.kotlinminiproject.laddergame.model

class Participant private constructor(val name: String) {

    companion object {
        fun creation(name: String): Participant = Participant(name)
        fun ghost() = Participant("GHOST")
    }

    init {
        if (name.length > 100) {
            throw IllegalArgumentException("참여자의 이름의 길이가 너무 깁니다.")
        }
    }
}