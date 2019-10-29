package br.com.digitalhouse.theaudioapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.digitalhouse.theaudioapplication.data.remote.RetrofitService
import br.com.digitalhouse.theaudioapplication.model.AlbumResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class AlbumRepository {

    val service = RetrofitService()

    fun getAllAbuns(artist: String): Observable<AlbumResponse> {
        return service.loadAlbuns(artist)
    }
}