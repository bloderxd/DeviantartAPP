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
    @GET("/browse/popular?access_token=53147da7cc6567d04b713ade6f3ba190268eb1e060791664fa")
    DeviationList getPopularDeviations();

}
