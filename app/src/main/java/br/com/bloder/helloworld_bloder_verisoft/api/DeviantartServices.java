package br.com.bloder.helloworld_bloder_verisoft.api;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by denis on 25/11/15.
 */
public interface DeviantartServices {

    @Headers("Accept: application/json")
    @GET("/browse/popular?access_token=e9a1864cc4dfd22ba0792fcde8224c86ffaf03d606243aebe4")
    DeviationListJson getPopularDeviations();

}
