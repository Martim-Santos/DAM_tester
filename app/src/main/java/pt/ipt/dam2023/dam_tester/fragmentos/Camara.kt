package pt.ipt.dam2023.dam_tester.fragmentos

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import pt.ipt.dam2023.dam_tester.R
import pt.ipt.dam2023.dam_tester.converter.ImagetoBase64
import pt.ipt.dam2023.dam_tester.model.APIResultFoto
import pt.ipt.dam2023.dam_tester.model.Foto
import pt.ipt.dam2023.dam_tester.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class Camara:Fragment() {
    lateinit var button: Button
    lateinit var imageView: ImageView
    var fotogarafia: String? = null
    val currentDateTime: java.util.Date = java.util.Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View
        view = inflater.inflate(R.layout.camera, container, false)

        button = view.findViewById(R.id.button)
        imageView = view.findViewById(R.id.ImageView)

        button.setOnClickListener {
            capturePhoto()
            addDummyFoto()
        }

        return view
    }

    fun capturePhoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(cameraIntent)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            imageView.setImageBitmap(data?.extras?.get("data") as Bitmap)
            fotogarafia = ImagetoBase64().encodeImage(bm = data?.extras?.get("data") as Bitmap)
        }
    }

    fun addDummyFoto() {
        val i = Random.nextInt()
        val imagem = Foto("nome: "+ i, "fotografia "+ fotogarafia,"Data: " + currentDateTime ,)
        addFoto(imagem) {

        }
    }

    fun addFoto(foto : Foto, onResult:(APIResultFoto?)-> Unit){
        var call = RetrofitInitializer().imageService().addFoto(fotogarafia, foto.nome , currentDateTime)
        call.enqueue(object : Callback<APIResultFoto> {
            override fun onFailure(call: Call<APIResultFoto>, t: Throwable) {
                t.printStackTrace()
                onResult(null)
            }
            override fun onResponse(call: Call<APIResultFoto>, response: Response<APIResultFoto>) {
                val addedNote = response.body()
                onResult(addedNote)
            }
        })
    }


}