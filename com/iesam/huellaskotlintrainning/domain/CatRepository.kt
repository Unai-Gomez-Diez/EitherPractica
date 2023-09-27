package com.iesam.huellaskotlintrainning.domain

import com.iesam.huellaskotlintrainning.app.Either
import com.iesam.huellaskotlintrainning.domain.errors.ErrorApp

interface CatRepository {


    fun getAllOk(): Either<ErrorApp, List<Cat>>

    fun getAllError(): Either<ErrorApp, List<Cat>>

    fun getAllError2(): Either<ErrorApp, List<Cat>>
}