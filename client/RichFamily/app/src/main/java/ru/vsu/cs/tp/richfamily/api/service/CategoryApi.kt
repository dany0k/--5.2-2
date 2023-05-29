package ru.vsu.cs.tp.richfamily.api.service

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Path
import retrofit2.http.Body
import ru.vsu.cs.tp.richfamily.api.model.category.Category
import ru.vsu.cs.tp.richfamily.api.model.category.CategoryRequestBody

interface CategoryApi {
    @Headers("Content-type: application/json")
    @GET("categories/")
    suspend fun getCategories(@Header("Authorization") token: String) : Response<List<Category>>

    @Headers("Content-type: application/json")
    @DELETE("categories/{id}/")
    suspend fun deleteCategory(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ) : Response<ResponseBody>

    @Headers("Content-type: application/json")
    @POST("categories/")
    suspend fun addCategory(
        @Header("Authorization") token: String,
        @Body categoryRequestBody: CategoryRequestBody
    ) : Response<Category>

    @Headers("Content-type: application/json")
    @PUT("categories/{id}/")
    suspend fun updateCategory(
        @Header("Authorization") token: String,
        @Body categoryRequestBody: CategoryRequestBody,
        @Path("id") id: Int
    ) : Response<Category>

    companion object {
        fun getCategoryApi() : CategoryApi? {
            return ClientApi.client?.create(CategoryApi::class.java)
        }
    }
}
