package pt.ipt.dam2023.dam_tester.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import pt.ipt.dam2023.dam_tester.model.Fotos
import pt.ipt.dam2023.dam_tester.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Galeria : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.galeria)

        listFotos()

    }

    private fun listFotos() {

        val call = RetrofitInitializer().imageService().list()
        call.enqueue(object : Callback<Fotos> {
            override fun onResponse(call: Call<Fotos>,
                                    response: Response<Fotos>
            ) {
                response?.body()?.let {
                    val fotos: Fotos = it
                    //configureList(notes)
                    Log.i("---->",fotos.fotos.get(0).nome)
                }
            }

            override fun onFailure(call: Call<Fotos>?, t: Throwable?) {
                t?.message?.let { Log.e("onFailure error", it) }
            }
        })

    }

}