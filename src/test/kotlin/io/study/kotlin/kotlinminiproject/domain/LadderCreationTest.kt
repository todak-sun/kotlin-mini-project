package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LadderCreationTest {

    @DisplayName("생성 테스트")
    @Test
    fun create() {
        val ladderCreation1 = LadderCreation(listOf("서영덕", "서동성", "선용주"), listOf("화분에 물 주기", "커피 머신 청소", "화장실 비품 채우기"), 3)
        val ladderCreation2 = LadderCreation(listOf("서영덕", "서동성", "선용주"), listOf("화분에 물 주기", "커피 머신 청소", "화장실 비품 채우기"), 3)

        assertEquals(ladderCreation1, ladderCreation2)
    }

    @DisplayName("생성 테스트2 - 참가자의 이름이 다르면 false")
    @Test
    fun create2() {
        val ladderCreation1 = LadderCreation(listOf("서영덕", "서동성", "홍석민"), listOf("화분에 물 주기", "커피 머신 청소", "화장실 비품 채우기"), 3)
        val ladderCreation2 = LadderCreation(listOf("서영덕", "서동성", "선용주"), listOf("화분에 물 주기", "커피 머신 청소", "화장실 비품 채우기"), 3)

        assertNotEquals(ladderCreation1, ladderCreation2)
    }

    @DisplayName("생성 테스트3 - 참가자수가 2미만 100 초과이면 IllegalArgumentException exception")
    @Test
    fun create3() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            LadderCreation(listOf("서영덕"), listOf("화분에 물 주기", "커피 머신 청소", "화장실 비품 채우기"), 3)
        }

        assertEquals("참가자의 수는 2명 이상 100명 이하 이어야 합니다.", exception.message)
    }

    @DisplayName("생성 테스트4 - 단계 수 3미만 20 초과이면 IllegalArgumentException exception")
    @Test
    fun create4() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            LadderCreation(listOf("서영덕", "서동성", "선용주"), listOf("화분에 물 주기", "커피 머신 청소", "화장실 비품 채우기"), 30)
        }

        assertEquals("사다리의 단계는 3개 이상 20개 이하 이어야 합니다.", exception.message)
    }
}