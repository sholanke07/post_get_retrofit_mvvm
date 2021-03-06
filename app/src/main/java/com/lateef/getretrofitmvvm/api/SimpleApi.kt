package com.lateef.getretrofitmvvm.api

import com.lateef.getretrofitmvvm.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    //using this to request from server
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    //to get result from server
    @GET("posts/{postNumber}")
    suspend fun getPost2(
            @Path("postNumber") number: Int
    ): Response<Post>

    //using custom query to get list of post
    @GET("posts")
    suspend fun getCustomPost(
            @Query("userId") userId: Int
    ): Response<List<Post>>

    //how to add multiple query
    //using this getCustomMultiplePost to display result in recyclerView
    @GET("posts")
    suspend fun getCustomMultiplePost(
            @Query("userId")userId: Int,
            @Query("_sort") sort: String,
            @Query("_order") order: String
    ): Response<List<Post>>

    //how to use query map it will help to reduce the number of query preramitas
    // we can use it to add multiple queries
    @GET("posts")
    suspend fun getCustomQueryMap(
            @Query("userId")userId: Int,
            @QueryMap options: Map<String, String>
    ): Response<List<Post>>


    //to post to server
    @POST("posts")
    suspend fun pushPost(@Body post: Post): Response<Post>


    //to post to server
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
            @Field("userId") userId: Int,
            @Field("id") id: Int,
            @Field("title") title: String,
            @Field("body") body: String
    ): Response<Post>


}