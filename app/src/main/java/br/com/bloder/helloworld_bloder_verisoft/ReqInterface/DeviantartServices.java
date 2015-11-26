package br.com.bloder.helloworld_bloder_verisoft.ReqInterface;

import br.com.bloder.helloworld_bloder_verisoft.repo.values.Deviation;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.DeviationList;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by denis on 25/11/15.
 */
public interface DeviantartServices {

    @Headers("Accept: application/json")
    @GET("/browse/popular?access_token=e5c20f1ac5d3b1a2f67862a7128c8d6970464afd2411ab8e35")
    DeviationList getPopularDeviations();

}
