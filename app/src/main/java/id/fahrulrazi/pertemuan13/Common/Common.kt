package id.fahrulrazi.pertemuan13.Common

import id.fahrulrazi.pertemuan13.Network.APIService
import id.fahrulrazi.pertemuan13.Network.Retrofit

object Common {
    private const val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val getAPIService: APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}