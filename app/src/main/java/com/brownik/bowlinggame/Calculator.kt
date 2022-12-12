package com.brownik.bowlinggame

object Calculator {

    fun totalScore(round: Int, isChance: Boolean, score: Int): Int {
        when (round) {
            in (1..9) -> calculateNormalScore(isChance, score)
            else -> calculateLastScore(isChance, score)
        }
        return 0
    }

    private fun calculateNormalScore(isChance: Boolean, score: Int) {
        if (isChance) {
            when (score) {

            }
        }
    }

    private fun calculateLastScore(isChance: Boolean, score: Int) {
        if (isChance) {
            when (score) {

            }
        }
    }

}