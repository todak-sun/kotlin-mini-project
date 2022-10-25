package io.study.kotlin.kotlinminiproject.domain

import java.util.UUID
import java.util.stream.IntStream
import kotlin.streams.toList

class LadderGame {

    val id: UUID = UUID.randomUUID()
    val request: LadderGameStartRequest
    val legs: MutableList<Leg>
    val destinations: MutableList<Destination>

    constructor(request: LadderGameStartRequest) {
        this.request = request
        this.legs = mutableListOf()
        this.destinations = mutableListOf()
        validate()
        initialize()

        for (order: Int in 1..this.request.participants.size) {
            this.legs.add(Leg(order))
        }
    }

    fun validate() {
        if (request.participants.size !in 2..100) {
            throw Error("참가자는 최소 2명, 최대 100명까지 가능합니다. [입력값 = $request.participants.size]")
        }

        if (request.rung != null && request.rung !in 3..20) {
            throw Error("Rung은 3이상 20이하로 입력 해주세요. [입력값 = $request.rung]")
        }

        if (request.destinations.size > request.participants.size) {
            throw Error("목적지는 참가자 수 보다 많이 입력할 수 없습니다. [입력값 = $request.destinations.size]")
        }
    }

    fun initialize() {
        if (request.destinations.size < request.participants.size) {
            val difference = request.participants.size - request.destinations.size
            for (number: Int in 1 .. difference) {
                this.destinations.add(Destination.none())
            }
        }
    }

    fun start(): List<LadderGameResult> {
        println("Ladder Game is started.")

        return listOf()
//        return request.participants
//            .mapIndexed { index, it ->  LadderGameResult(Participant(index + 1, it), Destination("test"), listOf(1))}
    }

}

data class LadderGameStartRequest(
    val participants: List<String>,
    val destinations: List<String>,
    val rung: Int?
)

data class Participant(val order: Int, val name: String) {
    companion object Factory {
        fun ghost(order: Int): Participant = Participant(order, "GHOST")
    }
}

data class Destination(val name: String){
    companion object Factory {
        fun none(): Destination = Destination("NONE")
    }
}

data class LadderGameResult(
    val participant: Participant,
    val destination: Destination, // 목적지(결과)의 이름
    val routes: List<Int>, // 참여자가 목적지까지 간 경로(Leg의 번호)
)

class Leg {
    val order: Int
    constructor(order: Int) {
        this.order = order
    }
}

class Rung {
    val left: Leg? = null
    val right: Leg? = null
}
