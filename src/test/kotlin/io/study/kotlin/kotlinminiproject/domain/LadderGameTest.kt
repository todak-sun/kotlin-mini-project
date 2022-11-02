package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

internal class LadderGameTest {

    @Test
    internal fun practice() {
        val number: Int?


    }

    @DisplayName("[정상] [1] 사다리 게임이 정상적으로 생성된다. (참가자 = 4명, 목적지 = 4개)")
    @Test
    internal fun pass_1() {
        val request = LadderGameStartRequest(
            participants = listOf("Ashe", "Akali", "Katarina", "Caitlyn"),
            destinations = listOf("Apple", "Banana", "Citron", "Durian"),
            null
        )
        val ladderGame = LadderGame(request)
        val ladderGameResults = ladderGame.start()
        assertNotNull(ladderGameResults)

        assertGameResult(ladderGameResults.find { it.participant.name == "Ashe" }, 1, "Ashe")
        assertGameResult(ladderGameResults.find { it.participant.name == "Akali" }, 2, "Akali")
        assertGameResult(ladderGameResults.find { it.participant.name == "Katarina" }, 3, "Katarina")
        assertGameResult(ladderGameResults.find { it.participant.name == "Caitlyn" }, 4, "Caitlyn")
    }

    @DisplayName("[정상] [1] 사다리 게임이 정상적으로 생성된다. (참가자 = 4명, 목적지 = 4개, 단계 = 8)")
    @Test
    internal fun pass_2() {

    }
    @DisplayName("[정상] [2] 사다리 게임 목적지가 참가자보다 적으면 그 차이 만큼 NONE 이란 이름을 가진 목적지가 추가된다. (참가자 = 4명, 목적지 = 2개)")
    @Test
    internal fun pass_3() {

    }

    @DisplayName("[실패] [1]사다리 게임 인원이 2명 보다 적으면 게임을 시작할 수 없다.")
    @Test
    internal fun fail_1() {
        val exception = assertThrows(Error::class.java) {
            val request = LadderGameStartRequest(
                participants = listOf("Ashe"),
                destinations = listOf("Apple"),
                null
            )
            LadderGame(request)
        }
        assertTrue(exception.message!!.contains("참가자는 최소 2명, 최대 100명까지 가능합니다."))
    }

    @DisplayName("[실패] [2]사다리 게임 인원이 100명 보다 많으면 게임을 시작할 수 없다.")
    @Test
    internal fun fail_2() {
        val exception = assertThrows(Error::class.java) {
            val participants: MutableList<String> = mutableListOf()
            val destinations: MutableList<String> = mutableListOf()
            for (number: Int in 1..200) {
                participants.add("participant_$number")
                destinations.add("destination_$number")
            }

            val request = LadderGameStartRequest(
                participants = participants,
                destinations = destinations,
                null
            )
            LadderGame(request)
        }
        assertTrue(exception.message!!.contains("참가자는 최소 2명, 최대 100명까지 가능합니다."))
    }

    @DisplayName("[실패] [3]사다리 게임 목적지가 참가자보다 많으면 게임을 시작할 수 없다.")
    @Test
    internal fun fail_3() {
        val exception = assertThrows(Error::class.java) {
            val request = LadderGameStartRequest(
                participants = listOf("Ashe", "Akali", "Katarina"),
                destinations = listOf("Apple", "Banana", "Citron", "Durian"),
                null
            )
            LadderGame(request)
        }
        assertTrue(exception.message!!.contains("목적지는 참가자 수 보다 많이 입력할 수 없습니다."))
    }

    fun assertGameResult(result: LadderGameResult?, order: Int, participant: String) {
        assertNotNull(result)
        if (result == null) throw Error("result is null")
        //assertEquals(order, result.order)
        assertEquals(participant, result.participant)
        assertNotNull(result.destination)
        assertTrue(result.routes.isNotEmpty())
    }

}