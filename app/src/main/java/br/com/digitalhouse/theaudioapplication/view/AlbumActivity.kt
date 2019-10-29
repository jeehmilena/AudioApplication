package br.com.digitalhouse.theaudioapplication.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.theaudioapplication.R
import br.com.digitalhouse.theaudioapplication.model.Album
import br.com.digitalhouse.theaudioapplication.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        val viewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
        val listAlbum: MutableList<Album> = mutableListOf()

        val adapter = RecyclerViewAlbumAdapter(listAlbum)

        albumList.adapter = adapter
        albumList.layoutManager = LinearLayoutManager(this)

        viewModel.getAlbuns("Aerosmith")

        viewModel.getAlbumList().observe(this, Observer { albumListReturn ->
            if (albumListReturn != null){
                adapter.updateList(albumListReturn)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Deu ruim", Toast.LENGTH_LONG).show()
            }
        })


    }
}
