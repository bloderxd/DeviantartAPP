package br.com.bloder.helloworld_bloder_verisoft.api;

import br.com.bloder.helloworld_bloder_verisoft.api.json.AccessTokenJson;
import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by denis on 25/11/15.
 */
public interface DeviantartServices {

    @Headers("Accept: application/json")
    @GET("/browse/popular")
    DeviationListJson getPopularDeviations(@Query("access_token") String accessToken, @Query("limit") int limit, @Query("offset") int offset);

    @GET("/token?grant_type=client_credentials&client_id=3943&client_secret=296fa3d32129b85561a5fc4bb9045747")
    AccessTokenJson getAccessToken();

}
