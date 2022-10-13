package io.study.kotlin.kotlinminiproject.laddergame.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ParticipantTest {

    @DisplayName("Participant는 이름을 가진다.")
    @Test
    fun createParticipant() {
        // given
        val participant = Participant.creation("이름")

        // when & then
        assertEquals("이름", participant.name)
    }

    @DisplayName("GHOST라는 이름을 가진 인스턴스를 생성한다.")
    @Test
    fun createParticipantGhost() {
        // given
        val participant = Participant.ghost()

        // when & then
        assertEquals("GHOST", participant.name)
    }

    @DisplayName("Participant는 최대 길이 100의 이름까지만 가질 수 있으며, 그 이상이 되면 예외가 발생한다.")
    @Test
    fun createParticipantTooLongName() {
        // given
        val tooLongName: String = "Name".repeat(30)


        // when & then
        assertThrows<IllegalArgumentException> { Participant.creation(tooLongName) }
            .let { exception -> assertEquals("참여자의 이름의 길이가 너무 깁니다.", exception.message) }

    }


}