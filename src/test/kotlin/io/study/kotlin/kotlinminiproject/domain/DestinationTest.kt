package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DestinationTest {

    @DisplayName("생성 테스트")
    @Test
    fun create() {
        val destination1 = Destination("나무에 물주기")
        val destination2 = Destination("나무에 물주기")

        assertEquals(destination1, destination2)
    }

    @DisplayName("생성 테스트2 - 목적지의 이름이 다르면 false")
    @Test
    fun create2() {
        val destination1 = Destination("나무에 물주기")
        val destination2 = Destination("커피 머신 청소")

        assertNotEquals(destination1, destination2)
    }
}