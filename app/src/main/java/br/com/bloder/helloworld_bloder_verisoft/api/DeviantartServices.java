package br.com.bloder.helloworld_bloder_verisoft.api;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by denis on 25/11/15.
 */
public interface DeviantartServices {

    @Headers("Accept: application/json")
    @GET("/browse/popular?access_token=08049b529c3e7736be211dc14e0e2a6105253bc1a2547c2404")
    DeviationListJson getPopularDeviations();

}
