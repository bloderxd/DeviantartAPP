package br.com.bloder.helloworld_bloder_verisoft.ReqInterface;

import br.com.bloder.helloworld_bloder_verisoft.repo.values.DeviationList;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by denis on 25/11/15.
 */
public interface ReqInterface {

    @GET("/browse/popular?access_token=b7b2129eaf81c1bf721280fac14443cfe8cdd331ce642863f0")
    void getDeviation(Callback<DeviationList> response);

}
