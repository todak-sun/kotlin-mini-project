package io.study.kotlin.kotlinminiproject.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LegTest {
    @Test
    @DisplayName("Leg 생성 테스트")
    fun create() {
        val leg1 = Leg(left = false, right = true)
        val leg2 = Leg(left = false, right = true)

        Assertions.assertEquals(leg1, leg2)
    }
}