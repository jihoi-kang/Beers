package com.jay.beers.api

import retrofit2.http.GET
import retrofit2.http.Query

interface BeerService {

    @GET("/v2/beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
    ): GetBeersResponse

}