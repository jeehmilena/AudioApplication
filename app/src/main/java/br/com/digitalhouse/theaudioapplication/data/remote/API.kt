package br.com.digitalhouse.theaudioapplication.data.remote

import br.com.digitalhouse.theaudioapplication.model.AlbumResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface API {

    @GET("searchalbum.php")
    fun getAllAbunsArtist(
        @Query("s") artist: String) : Observable<AlbumResponse>

}