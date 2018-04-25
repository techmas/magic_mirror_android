package ru.noixlab.drivepoint.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.api.models.PhotoDTO
import ru.techmas.magicmirror.models.Photos
import ru.techmas.magicmirror.utils.ImageLoader

class AlbumAdapter(val context: Context, items: Photos)
    : BaseRecyclerAdapter<PhotoDTO, AlbumAdapter.ViewHolder>(items) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_album, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        with(item) {
            with(holder) {
                tvNumber.text = "№ ${photoRate}"
                flItem.setOnClickListener { onItemClickListener.onClick(item) }
                detailPicture?.let { ImageLoader.load(context, ivPhoto, it) }
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var flItem = itemView.findViewById<FrameLayout>(R.id.flItem)
        var ivPhoto = itemView.findViewById<ImageView>(R.id.ivPhoto)
        var tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
    }
}