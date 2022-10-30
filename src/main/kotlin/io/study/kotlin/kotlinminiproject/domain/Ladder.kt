package io.study.kotlin.kotlinminiproject.domain

import kotlin.random.Random

class Ladder(ladderCreation: LadderCreation) {
    private var ladder : List<Legs> = ArrayList()
    init {
        val legsCount = ladderCreation.participants.size() - 1
        for(row in 0 until  ladderCreation.rung.count) {
            var legs: List<Leg> = ArrayList()
            for(colum in 0 .. legsCount) {
                if(colum == legsCount - 1) {
                    legs += (Leg((legs[colum - 1].right), false))
                    continue
                }
                if(colum == 0 || !legs[colum -1].left) {
                    legs += Leg(left = false, right = Random.nextBoolean())
                    continue
                }
                if(legs[colum - 1].left) {
                    legs += Leg(left = true, right = false)
                    continue
                }
            }
            ladder += Legs(legs)
        }
    }
}