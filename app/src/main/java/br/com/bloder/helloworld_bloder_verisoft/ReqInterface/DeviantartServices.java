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
    @GET("/browse/popular?access_token=41c2e73eb977b14ad20419de9abc994fd0aa777fd0ac9cff59")
    DeviationList getPopularDeviations();

}
