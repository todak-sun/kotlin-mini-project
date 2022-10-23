package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

internal class LadderGameTest {

    internal fun practice() {
        val first = Participant(1, "Apple")
        val second = Participant(1, "Apple")
        assertTrue(first == second)
    }

    @DisplayName("[정상] [1] 사다리 게임이 정상적으로 생성된다. (참가자 = 4명, 목적지 = 4개)")
    @Test
    internal fun pass_1() {
//        val request = LadderGameStartRequest(
//            participants = listOf("Ashe", "Akali", "Katarina", "Caitlyn"),
//            destinations = listOf("Apple", "Banana", "Citron", "Durian"),
//            null
//        )
//        val ladderGame = LadderGame()
//        val ladderGameResults = ladderGame.start(request)
//        assertNotNull(ladderGameResults)
//
//        assertGameResult(ladderGameResults.find { it.participant == "Ashe" }, 1, "Ashe")
//        assertGameResult(ladderGameResults.find { it.participant == "Akali" }, 2, "Akali")
//        assertGameResult(ladderGameResults.find { it.participant == "Katarina" }, 3, "Katarina")
//        assertGameResult(ladderGameResults.find { it.participant == "Caitlyn" }, 4, "Caitlyn")
    }

    @DisplayName("[정상] [1] 사다리 게임이 정상적으로 생성된다. (참가자 = 4명, 목적지 = 4개, 단계 = 8)")
    @Test
    internal fun pass_2() {

    }
    @DisplayName("[정상] [2] 사다리 게임 목적지가 참가자보다 적으면 그 차이 만큼 NONE 이란 이름을 가진 목적지가 추가된다. (참가자 = 4명, 목적지 = 2개)")
    @Test
    internal fun pass_3() {

    }

//    @DisplayName("[실패] [1]사다리 게임 인원이 2명 보다 적으면 게임을 시작할 수 없다.")
//    @DisplayName("[실패] [2]사다리 게임 인원이 100명 보다 많으면 게임을 시작할 수 없다.")
//    @DisplayName("[실패] [3]사다리 게임 목적지가 참가자보다 많으면 게임을 시작할 수 없다.")

    fun assertGameResult(result: LadderGameResult?, order: Int, participant: String) {
        assertNotNull(result)
        if (result == null) throw Error("result is null")
        //assertEquals(order, result.order)
        assertEquals(participant, result.participant)
        assertNotNull(result.destination)
        assertTrue(result.routes.isNotEmpty())
    }

}