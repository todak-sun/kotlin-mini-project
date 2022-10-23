package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DestinationsTest {
    @DisplayName("생성 테스트")
    @Test
    fun create() {
        val destination1 = Destinations(listOf("나무에 물 주기", "커피 머신 청소", "쓰레기통 비우기"))
        val destination2 = Destinations(listOf("나무에 물 주기", "커피 머신 청소", "쓰레기통 비우기"))

        assertEquals(destination1, destination2)
    }
}