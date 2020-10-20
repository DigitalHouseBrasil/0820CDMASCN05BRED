package com.digitalhouse.rickapp.api

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickApi {
    companion object {
        fun getData(context: Context, iRespostaDaApi: IRespostaDaApi) {
            val retrofitClient = NetworkUtils
                .getRetrofitInstance("https://rickandmortyapi.com/api/")

            val endpoint = retrofitClient.create(Endpoint::class.java)
            val callback = endpoint.getPersonagens()

            callback.enqueue(object : Callback<Resultado> {
                override fun onFailure(call: Call<Resultado>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                    response.body()?.let { iRespostaDaApi.obtevePersonagens(it.resultados) }
                }
            })
        }
    }
}