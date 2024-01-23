package pt.ipt.dam2023.dam_tester.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import pt.ipt.dam2023.dam_tester.R
import pt.ipt.dam2023.dam_tester.model.Foto

class ImageAdapter (private val images: List<Foto>, private val context: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder?.let {
            it.bindView(image)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(image: Foto) {
            val nome: EditText = itemView.findViewById(R.id.image_item_name)
            val imagem: ImageView = itemView.findViewById(R.id.ImageView)

            imagem.setImageURI(Uri.parse(image.foto))
            nome.setText(image.nome)
        }
    }
}