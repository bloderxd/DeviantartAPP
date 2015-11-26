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
    @GET("/browse/popular?access_token=33c270fa1b05b1dd16a6cf76fd9570a965b872f49cc295cbee")
    DeviationList getPopularDeviations();

}
