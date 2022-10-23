package io.study.kotlin.kotlinminiproject.domain

import java.util.UUID

class LadderGame {

    val id: UUID = UUID.randomUUID()



    constructor(request: LadderGameStartRequest) {

        if (request.participants.isEmpty() || request.participants.size > 100) {
            throw Error("참가자는 최소 2명, 최대 100명까지 가능합니다. [입력값 = $request.participants.size]")
        }

    }

    fun validate() {

    }

    fun start(request: LadderGameStartRequest): List<LadderGameResult> {


        println("Ladder Game is started.")


        return request.participants
            .mapIndexed { index, it ->  LadderGameResult(Participant(index + 1, it), Destination("test"), listOf(1))}
    }

}

data class LadderGameStartRequest(
    val participants: List<String>,
    val destinations: List<String>,
    val rung: Int?
)

data class Participant(val order: Int, val name: String)
fun Participant.ghost(order: Int): Participant = Participant(order, "GHOST")

data class Destination(val name: String)
fun Destination.none(): Destination = Destination("NONE")

data class LadderGameResult(
    val participant: Participant,
    val destination : Destination, // 목적지(결과)의 이름
    val routes : List<Int>, // 참여자가 목적지까지 간 경로(Leg의 번호)
)

class Leg {

}

class Rung {
    val left: Leg? = null
    val right: Leg? = null
}
