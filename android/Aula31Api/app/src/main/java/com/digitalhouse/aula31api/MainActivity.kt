package com.digitalhouse.aula31api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.aula31api.models.ApiResponseModel
import com.digitalhouse.aula31api.models.CharacterModel
import com.digitalhouse.aula31api.repository.CharacterEndpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fins de testes
        httpClient = NetworkUtils.getRetrofitInstance(BASE_URL)
        obterPersonagens()
    }

    fun obterPersonagens() {
        val endpoint = httpClient.create(CharacterEndpoint::class.java)

        endpoint.obterPersonagens().enqueue(object: Callback<ApiResponseModel<CharacterModel>> {
            override fun onResponse(
                call: Call<ApiResponseModel<CharacterModel>>,
                response: Response<ApiResponseModel<CharacterModel>>
            ) {
                val resultado = response.body()

                Toast.makeText(this@MainActivity, resultado!!.results[0].nome, Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ApiResponseModel<CharacterModel>>, t: Throwable) {

            }
        })
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        lateinit var httpClient: Retrofit
    }
}