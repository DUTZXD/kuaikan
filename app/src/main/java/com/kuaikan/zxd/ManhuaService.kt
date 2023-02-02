package com.kuaikan.zxd

import retrofit2.http.GET
import com.kuaikan.zxd.ManhuaBean
import retrofit2.Call
import retrofit2.http.Query

/**
 * @auther: zhangxiaodong91
 * @date: 2023/2/2
 */
interface ManhuaService {

    @GET("/daily/topics")
    fun getDailyUpdate(@Query("pos") pos: Int): Call<ManhuaBean>
}