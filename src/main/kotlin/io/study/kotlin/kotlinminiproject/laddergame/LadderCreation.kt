package io.study.kotlin.kotlinminiproject.laddergame

import org.hibernate.validator.constraints.Length
import kotlin.random.Random

class LadderCreation(
    @Length(min = 2, max = 100) val participants: List<String>,
    @Length(min = 2, max = 100) val destinations: List<String>,
    val rung: Int = Random.nextInt(3, 20)
)