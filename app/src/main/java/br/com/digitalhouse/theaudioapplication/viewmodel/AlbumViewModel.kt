package br.com.digitalhouse.theaudioapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.digitalhouse.theaudioapplication.model.Album
import br.com.digitalhouse.theaudioapplication.repository.AlbumRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlbumViewModel(application: Application) : AndroidViewModel(application) {
    val albumListReturn: MutableLiveData<MutableList<Album>> = MutableLiveData()
    val repository = AlbumRepository()

    fun getAlbumList(): LiveData<MutableList<Album>> {
        return this.albumListReturn
    }

    fun getAlbuns(artist: String) {
        repository.getAllAbuns(artist)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                albumListReturn.value = it?.album
            }, { e ->
                e.printStackTrace()
                e.message
            }
            )
    }
}