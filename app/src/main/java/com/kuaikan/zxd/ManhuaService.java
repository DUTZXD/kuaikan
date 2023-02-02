package com.kuaikan.zxd;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @auther: zhangxiaodong91
 * @date: 2023/2/2
 */
public interface ManhuaService {

    @GET("/daily/topics")
    Call<ManhuaBean> getDailyUpdate(@Query("pos") int pos);
}
