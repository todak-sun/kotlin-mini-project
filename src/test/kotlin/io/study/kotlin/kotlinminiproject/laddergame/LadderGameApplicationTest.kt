package io.study.kotlin.kotlinminiproject.laddergame

import io.study.kotlin.kotlinminiproject.laddergame.model.Participant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LadderGameApplicationTest {


    @Test
    fun `두 리스트 중 길이가 더 긴 리스트의 길이를 찾아낸다`() {
        // given
        val list1 = listOf(1, 2, 3)
        val list2 = listOf(1, 2, 3, 4)

        // when
        val max = Math.max(list1.size, list2.size)

        // then
        assertEquals(4, max)
    }

    @Test
    fun `원하는 사이즈의 길이만큼 참여자를 늘려서 초기 참여자 리스트를 생성한다`() {
        // given
        val wantedSize = 4
        val initialParticipantNames = listOf("참여자1", "참여자2")


        // when
        val result =
            initialParticipantNames.map { Participant.creation(it) } +
                    (0).until(wantedSize - initialParticipantNames.size)
                        .map { Participant.ghost() }

        // then
        assertThat(result).hasSize(wantedSize)
        assertThat(result)
            .extracting("name")
            .containsExactlyInAnyOrder("참여자1", "참여자2", "GHOST", "GHOST")
    }

}