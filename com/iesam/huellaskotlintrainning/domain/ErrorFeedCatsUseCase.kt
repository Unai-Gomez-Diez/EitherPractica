package com.iesam.huellaskotlintrainning.domain

import com.iesam.huellaskotlintrainning.app.Either
import com.iesam.huellaskotlintrainning.app.right
import com.iesam.huellaskotlintrainning.domain.errors.ErrorApp

class ErrorFeedCatsUseCase(private val repository: CatRepository) {
    operator fun invoke(): Either<ErrorApp, List<Cat>> {
        return repository.getAllError()
    }
}