package io.study.kotlin.kotlinminiproject.domain

import java.util.*
import kotlin.math.max

class LadderGame {

    val id: UUID = UUID.randomUUID()
    val request: LadderGameStartRequest

    val participants: MutableList<Participant>
    val destinations: MutableList<Destination>

    val legs: MutableList<Leg>

    constructor(request: LadderGameStartRequest) {
        this.request = request
        validate()

        this.legs = mutableListOf()
        this.participants = mutableListOf()
        this.destinations = mutableListOf()

        initialize()
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

        val (participants, destinations, rung) = request
        val sizeOfLegs = max(participants.size, destinations.size)
        val sizeOfStep: Int = rung ?: Random().nextInt(3, 20)
        // val sizeOfStep: Int = 8


        /**
         * 2-4
         *   Participant의 수가 Destination의 수보다 작다면
         *   그 차이만큼 "GHOST" 란 이름을 가진 참여자가 생성된다.
         */
        if (destinations.size > participants.size) {
            val difference = destinations.size - participants.size
            repeat((1 .. difference).count()) {
                val ghost = Participant.ghost(participants.size + it)
                this.participants.add(ghost)
            }
        }

        /**
         * 4-2
         *   Destination의 수가 Participant보다 작다면
         *   그 차이만큼 "NONE" 이란 상태값을 가진 Destination이 자동으로 추가된다.
         */
        if (destinations.size < participants.size) {
            val difference = participants.size - destinations.size
            repeat((1 .. difference).count()) {
                this.destinations.add(Destination.none())
            }
        }

        // TODO LEG 생성
        this.legs.addAll(
            (1 .. sizeOfLegs)
                .map { Leg(it, sizeOfStep, this.destinations[it - 1]) }
                .toList()
        )

        for (index in 0 until  sizeOfLegs - 1) {
            val current = this.legs[index]
            val next = this.legs[index + 1]
            generateRung(current, next)
        }

    }

    fun generateRung(left: Leg, right: Leg) {

        val random = Random()

        for (step in 1 .. left.numberOfStep) {
            val leftStep: Step = left.getStep(step)
            val rightStep: Step = right.getStep(step)

            if (leftStep.left is EmptyRung && rightStep.right is EmptyRung) {
                val createdRung: Rung = if(random.nextBoolean()) ConnectedRung(left, right) else EmptyRung()
                leftStep.right = createdRung
                rightStep.left = createdRung
                if (createdRung is ConnectedRung) {
                    println("Rung 생성 [LEFT = (id = ${left.id}, step = $step), RIGHT = (id = ${right.id}, step = $step)]")
                }
            }
        }

    }

    fun start(): List<LadderGameResult> {
        println("Ladder Game is started.")



        return listOf()
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

