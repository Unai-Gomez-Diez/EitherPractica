package com.iesam.huellaskotlintrainning.data

import com.iesam.huellaskotlintrainning.app.Either
import com.iesam.huellaskotlintrainning.data.local.CatFileLocalDataSource
import com.iesam.huellaskotlintrainning.data.remote.CatApiRemoteDataSource
import com.iesam.huellaskotlintrainning.domain.Cat
import com.iesam.huellaskotlintrainning.domain.CatRepository
import com.iesam.huellaskotlintrainning.domain.errors.ErrorApp

class CatDataRepository(
    val localSource: CatFileLocalDataSource,
    val apiSource: CatApiRemoteDataSource
) : CatRepository {

    /*
     Lógica a seguir.
     - Si existe en local, se devuelve lo que hay en local.
     - Si no existe en local, se obtiene de red, se guarda en local y se devuelve el listado obtenido de red
     - Si da error, devolvemos el error.
     */
    override fun getAllOk(): Either<ErrorApp, List<Cat>> {
        val resultLocal= localSource.findAll()

        if(resultLocal.isNotEmpty()){
            return Either.Right(resultLocal)
        }
        return apiSource.getCats().map {
            localSource.saveList(it)
            it
        }
/*
        val resultRemote = apiSource.getCats()
        return if (resultRemote.isRight()){
            localSource.saveList(resultRemote.get())
            resultRemote
        }else{
            resultRemote
        }*/

    }

    /*
     Lógica a seguir.
     - Se obtiene de red con la respuesta sin errores.
     - Se guarda en local.
     - Se obtiene de red con la respuesta de errores.
     - Nos devuelve un error, devolvemos lo de local
     */
    override fun getAllError(): Either<ErrorApp, List<Cat>> {

        apiSource.getCats().map {
            localSource.saveList(it)
            it
        }
        val resultRemote = apiSource.getCatsWithError()

       resultRemote.mapLeft {
            return Either.Right(localSource.findAll())

        }
        return resultRemote


        /*return if (resultRemote.isLeft()){
            Either.Right(localSource.findAll())


        }else{
            Either.Right(localSource.findAll())
        }*/


    }

    /*
     Lógica a seguir.
     - Se obtiene de red con la respuesta con errores.
     - Se devuelve al dominio
     */
    override fun getAllError2(): Either<ErrorApp, List<Cat>> {
        val resultRemote = apiSource.getCatsWithError()
        return resultRemote.mapLeft {
            it
        }
    }
}