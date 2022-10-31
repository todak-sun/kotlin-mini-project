package io.study.kotlin.kotlinminiproject.domain

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RungTest {
    @DisplayName("생성 테스트")
    @Test
    fun create() {
        val rung1 = Rung(3)
        val rung2 = Rung(3)

        assertEquals(rung1, rung2)
    }

    @DisplayName("생성 테스트2 - 단계 수가 다르면 - false")
    @Test
    fun create2() {
        val rung1 = Rung(3)
        val rung2 = Rung(4)

        assertNotEquals(rung1, rung2)
    }

    @DisplayName("생성 테스트3 - 단계수가 3미만 20 초과이면 IllegalArgumentException exception")
    @Test
    fun create3() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Rung(30)
        }

        assertEquals("사다리의 단계는 3개 이상 20개 이하 이어야 합니다.", exception.message)
    }

    @DisplayName("생성 테스트4 - 단계수를 입력 하지 않았을 때는 3 이상 20 이하의 단계수가 랜덤으로 설정")
    @Test
    fun create4() {
        val rung = Rung(null)

        assertThat(rung.count, allOf(greaterThanOrEqualTo(3), lessThanOrEqualTo(20)))
    }
}