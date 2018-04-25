package ru.noixlab.drivepoint.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ru.techmas.magicmirror.R
import ru.techmas.magicmirror.api.models.PhotoDTO
import ru.techmas.magicmirror.models.Photos
import ru.techmas.magicmirror.utils.ImageLoader

class TopAdapter(val context: Context, items: Photos)
    : BaseRecyclerAdapter<PhotoDTO, TopAdapter.ViewHolder>(items) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_top_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        with(item) {
            with(holder) {
                tvName.text = "$name ${user!!.lastName}"
                tvSerialNumber.text = "№ ${photoRate}"
                tvNumber.text = photoUser.toString()
                ltItem.setOnClickListener { onItemClickListener.onClick(item) }
                detailPicture?.let { ImageLoader.load(context, ivPhoto, it) }
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ltItem = itemView.findViewById<LinearLayout>(R.id.ltItem)
        var ivPhoto = itemView.findViewById<ImageView>(R.id.ivPhoto)
        var tvName = itemView.findViewById<TextView>(R.id.tvName)
        var tvSerialNumber = itemView.findViewById<TextView>(R.id.tvSerialNumber)
        var tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
    }
}