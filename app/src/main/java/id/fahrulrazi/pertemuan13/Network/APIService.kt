package id.fahrulrazi.pertemuan13.Network

import id.fahrulrazi.pertemuan13.Model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<MovieModel>>
}