package io.study.kotlin.kotlinminiproject.laddergame

import io.study.kotlin.kotlinminiproject.laddergame.model.Bridge
import io.study.kotlin.kotlinminiproject.laddergame.model.Destination
import io.study.kotlin.kotlinminiproject.laddergame.model.Leg
import io.study.kotlin.kotlinminiproject.laddergame.model.Participant
import kotlin.math.max


class LadderGameApplication {

    fun start(creation: LadderCreation): Result {

        val legSize = max(creation.participants.size, creation.destinations.size)

        val participants =
            creation.participants
                .map { Participant.creation(it) }
                .plus(
                    (0).until(legSize - creation.participants.size)
                        .map { Participant.ghost() })

        val destinations =
            creation.destinations.map { Destination.creation(it) }
                .plus(
                    (0).until(legSize - creation.destinations.size)
                        .map { Destination.none() })

        val legs = (0).until(legSize)
            .map { Leg(it + 1, participants[it], destinations[it]) }


        // 최소한의 Bridge의 수 = Leg의 수 - 1
        // Rung이 N개 주어질 때, Leg와 Leg 사이에 가질 수 있는 개수의 범위: 0 ~ N - 2

        //

        return Result(1, "Participant", "Destination", listOf(1, 2, 3, 4))
    }

}

class Ladder(
    val left: Leg,
    val right: Leg,
    val bridges: List<Bridge>
) {

}