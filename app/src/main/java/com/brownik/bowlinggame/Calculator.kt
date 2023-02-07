@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.brownik.bowlinggame

import java.util.*

object Calculator {
    fun getTotalScore(list: List<BowlingFrameDetailData>){
        var score = 0
        val waitState = mutableListOf<BowlingFrameDetailData>()
        list.forEach { data ->
            when(data.state){
                BowlingDataState.Spare, BowlingDataState.Strike -> waitState.add(data)
                BowlingDataState.Normal -> {
                    if (waitState.size == 0){
                        data.pin.forEach { score += it }
                    } else {
                        calculateScore(waitState.toList())
                        waitState.clear()
                    }
                }
            }
        }
    }

    fun calculateScore(list: List<BowlingFrameDetailData>): Int{
        list.forEach {

        }
        return 0
    }
}

