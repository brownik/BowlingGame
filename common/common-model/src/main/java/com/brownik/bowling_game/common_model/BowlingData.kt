package com.brownik.bowling_game.common_model

sealed class BowlingDataState {
    object Normal: BowlingDataState()
    object Spare: BowlingDataState()
    object Strike: BowlingDataState()
}

data class BowlingFrameData(
    val memNo: Int = 0,
    val memName: String = "",
    var frameData: List<BowlingFrameDetailData> = emptyList()
)

data class BowlingFrameDetailData(
    val frame: Int,
    var pin: Int,
    val state: BowlingDataState
)