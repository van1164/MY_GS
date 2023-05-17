package com.van133.my_gs

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Search_Barcode {
    @GET("search_barcode")
    fun getSearchBarcode(
        @Query("barcode") barcode: String,
        @Query("Cid") Cid: String,
    ): Call<ResultBarcode>

    @GET("add_barcode")
    fun getAddBarcode(
        @Query("barcode") barcode: String,
        @Query("name") name : String
    ): Call<ResultBarcode>


}