package io.study.kotlin.kotlinminiproject.laddergame.model

class Destination private constructor(val name: String) {

    companion object {
        fun creation(name: String): Destination = Destination(name)
        fun none() = Destination("NONE")
    }

    init {
        if (name.length > 100) {
            throw IllegalArgumentException("목적지의 이름은 100글자를 넘을 수 없습니다.")
        }
    }

}