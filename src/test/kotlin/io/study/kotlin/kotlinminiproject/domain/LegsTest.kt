package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LegsTest {

    @DisplayName("Legs 생성 테스트")
    @Test
    fun create() {
        val legs1 = Legs(listOf(Leg(left = false, right = true), Leg(left = true, right = false), Leg(left = false, right = false)))
        val legs2 = Legs(listOf(Leg(left = false, right = true), Leg(left = true, right = false), Leg(left = false, right = false)))

        assertEquals(legs1, legs2)
    }

    @DisplayName("첫번째 참가자는 오른쪽으로 갈수 있기 때문에, 2번 목적지를 리턴한다.")
    @Test
    fun getResult() {
        val legs1 = Legs(listOf(Leg(left = false, right = true), Leg(left = true, right = false), Leg(left = false, right = false), Leg(left = false, right = false)))
        assertEquals(2, legs1.getMovedPosition(1))
    }

    @DisplayName("두번째 참가자는 왼쪽으로 갈수 있기 때문에, 1번 목적지를 리턴한다.")
    @Test
    fun getResult2() {
        val legs1 = Legs(listOf(Leg(left = false, right = true), Leg(left = true, right = false), Leg(left = false, right = false), Leg(left = false, right = false)))
        assertEquals(1, legs1.getMovedPosition(2))
    }

    @DisplayName("세번째 참가자는 어느 방향으로도 갈수 없기 때문에, 3번 목적지를 리턴한다.")
    @Test
    fun getResult3() {
        val legs1 = Legs(listOf(Leg(left = false, right = true), Leg(left = true, right = false), Leg(left = false, right = false), Leg(left = false, right = false)))
        assertEquals(3, legs1.getMovedPosition(3))
    }

    @DisplayName("네번째 참가자는 어느 방향으로도 갈수 없기 때문에, 4번 목적지를 리턴한다.")
    @Test
    fun getResult4() {
        val legs1 = Legs(listOf(Leg(left = false, right = true), Leg(left = true, right = false), Leg(left = false, right = false), Leg(left = false, right = false)))
        assertEquals(4, legs1.getMovedPosition(4))
    }
}