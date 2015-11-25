package br.com.bloder.helloworld_bloder_verisoft.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.bloder.helloworld_bloder_verisoft.BuildConfig;
import br.com.bloder.helloworld_bloder_verisoft.ReqInterface.ReqInterface;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.DeviationList;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by denis on 23/11/15.
 */
public class RetrofitBuilder {

    RestAdapter retrofit;
    Gson gson;

  public void getDeviation() {
      
            gson = new GsonBuilder()
              .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
              .create();

            retrofit = new RestAdapter.Builder()
              .setEndpoint(BuildConfig.API_URL)
              .setLogLevel(RestAdapter.LogLevel.FULL)
              .setConverter(new GsonConverter(gson))
              .build();

  }
}
