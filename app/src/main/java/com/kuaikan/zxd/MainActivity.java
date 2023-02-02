package com.kuaikan.zxd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.manhuaRv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.kuaikanmanhua.com/v2/pweb/daily/topics")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ManhuaService manhuaService = retrofit.create(ManhuaService.class);
        Call<ManhuaBean> call = manhuaService.getManhuaUpdate(0);
        call.enqueue(new Callback<ManhuaBean>() {
            @Override
            public void onResponse(Call<ManhuaBean> call, Response<ManhuaBean> response) {
                ManhuaBean bean = response.body();
                if (bean != null) {
                    JSONObject data = bean.data;
//                    data.optJSONArray();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ManHuaAdapter adapter = (ManHuaAdapter) recyclerView.getAdapter();
                            adapter.setData();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ManhuaBean> call, Throwable t) {

            }
        });
        ManHuaAdapter adapter = new ManHuaAdapter();
    }
}