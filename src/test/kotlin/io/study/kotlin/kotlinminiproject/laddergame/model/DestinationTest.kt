package io.study.kotlin.kotlinminiproject.laddergame.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DestinationTest {

    @DisplayName("목적지는 이름을 가진다.")
    @Test
    fun creation() {
        // given
        val destination = Destination.creation("당첨!")

        // when & then
        assertEquals("당첨!", destination.name)
    }


    @DisplayName("빈 목적지를 생성하며, 빈 목적지는 NONE이란 이름을 가진다.")
    @Test
    fun creationNone() {
        // given
        val destination = Destination.none()

        // when & then
        assertEquals("NONE", destination.name)
    }

    @DisplayName("목적지의 이름은 최대 100글자 까지다.")
    @Test
    fun createTooLongName() {
        // given
        val tooLongName = "Destination".repeat(30)

        // when & then

        assertThrows<IllegalArgumentException> { Destination.creation(tooLongName) }
            .let { exception -> assertEquals("목적지의 이름은 100글자를 넘을 수 없습니다.", exception.message) }

    }

}