package br.com.bloder.helloworld_bloder_verisoft.api;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by denis on 25/11/15.
 */
public interface DeviantartServices {

    @Headers("Accept: application/json")
    @GET("/browse/popular?access_token=a6f0313b1f90839cd7a2c4af87c64fac8823ca00d94b2de6b8")
    DeviationListJson getPopularDeviations();

}
