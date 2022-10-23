package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ParticipantTest {

    @DisplayName("생성 테스트")
    @Test
    fun create() {
        val participant1 = Participant("ZeroDuck")
        val participant2 = Participant("ZeroDuck")
        assertEquals(participant1, participant2)
    }

    @DisplayName("생성 테스트2 - 이름 다르면 다른 사용자")
    @Test
    fun create2() {
        val participant1 = Participant("ZeroDuck")
        val participant2 = Participant("TodakSun")
        assertNotEquals(participant1, participant2)
    }
}