package br.com.digitalhouse.theaudioapplication.model

data class AlbumResponse(
    val album: MutableList<Album>
)

data class Album(
    val strAlbum: String
)