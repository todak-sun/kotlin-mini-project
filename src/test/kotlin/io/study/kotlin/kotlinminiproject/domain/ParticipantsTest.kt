package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ParticipantsTest {
    @DisplayName("생성 테스트")
    @Test
    fun create() {
        val participants1 = Participants(listOf("서영덕", "서동성", "선용주"))
        val participants2 = Participants(listOf("서영덕", "서동성", "선용주"))

        assertEquals(participants1, participants2)
    }

    @DisplayName("생성 테스트2 - 참가자수가 2미만 100 초과이면 IllegalArgumentException exception")
    @Test
    fun create2() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Participants(listOf("서영덕"))
        }

        assertEquals("참가자의 수는 2명 이상 100명 이하 이어야 합니다.", exception.message)
    }
}