package com.iesam.huellaskotlintrainning

import com.iesam.huellaskotlintrainning.data.CatDataRepository
import com.iesam.huellaskotlintrainning.data.local.CatFileLocalDataSource
import com.iesam.huellaskotlintrainning.data.remote.CatApiRemoteDataSource
import com.iesam.huellaskotlintrainning.domain.Error2FeedCatsUseCase
import com.iesam.huellaskotlintrainning.domain.ErrorFeedCatsUseCase
import com.iesam.huellaskotlintrainning.domain.GetFeedCatsUseCase
import java.util.Locale

fun main(){
    //Crea un caso de uso para cada uno de los métodos que existen en el repositorio.

   /* fun example01(getFeedCatsUseCase: GetFeedCatsUseCase){

            val x = getFeedCatsUseCase.invoke()
            println(x)

    }
    example01(getFeedCatsUseCase = GetFeedCatsUseCase(repository = CatDataRepository(
        CatFileLocalDataSource(),
        CatApiRemoteDataSource()
    )))*/

    fun example02(errorFeedCatsUseCase: ErrorFeedCatsUseCase){
            val y = errorFeedCatsUseCase()
        println(y)
    }
     example02(errorFeedCatsUseCase = ErrorFeedCatsUseCase(repository = CatDataRepository(
        CatFileLocalDataSource(),
        CatApiRemoteDataSource()
    )))

    /*fun example03(error2FeedCatsUseCase: Error2FeedCatsUseCase){
        val z = error2FeedCatsUseCase()
        println(z)
    }*/
    /* example03(error2FeedCatsUseCase = Error2FeedCatsUseCase(repository = CatDataRepository(
        CatFileLocalDataSource(),
        CatApiRemoteDataSource()
    )))*/







}
fun getAllCats(){
    GetFeedCatsUseCase (CatDataRepository(CatFileLocalDataSource(), CatApiRemoteDataSource()))


}

fun errorFeedCatsUseCase(){
    ErrorFeedCatsUseCase(CatDataRepository(CatFileLocalDataSource(), CatApiRemoteDataSource()))

}

fun error2FeedCatsUseCase(){
    Error2FeedCatsUseCase(CatDataRepository(CatFileLocalDataSource(), CatApiRemoteDataSource()))
}

