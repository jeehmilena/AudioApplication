package br.com.digitalhouse.theaudioapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.theaudioapplication.R
import br.com.digitalhouse.theaudioapplication.model.Album
import kotlinx.android.synthetic.main.item_recyclerview_album.view.*

class RecyclerViewAlbumAdapter(var albumList: MutableList<Album>) : RecyclerView.Adapter<RecyclerViewAlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_album, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumList.get(position)
        holder.onBind(album)
    }

    fun updateList(newList: MutableList<Album>){
        this.albumList.removeAll(albumList)
        this.albumList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(album: Album){
            itemView.albumName.text = album.strAlbum
        }

    }
}