package br.com.bloder.helloworld_bloder_verisoft.api;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by denis on 25/11/15.
 */
public interface DeviantartServices {

    @Headers("Accept: application/json")
    @GET("/browse/popular?access_token=1eb72759c828c48ab57543dd5b96ddb4247826434996602f12")
    DeviationListJson getPopularDeviations();

}
