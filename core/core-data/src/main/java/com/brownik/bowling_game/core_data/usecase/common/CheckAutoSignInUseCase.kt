package com.brownik.bowling_game.core_data.usecase.common

import com.brownik.bowling_game.common_util.extension.apiResultState
import com.brownik.bowling_game.core_data.repository.common.CommonRepository
import javax.inject.Inject

class CheckAutoSignInUseCase @Inject constructor(
    private val repository: CommonRepository
) {
    operator fun invoke() = repository.checkAutoSignIn().apiResultState()
}