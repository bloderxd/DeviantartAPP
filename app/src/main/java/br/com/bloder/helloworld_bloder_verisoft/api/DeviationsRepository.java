package br.com.bloder.helloworld_bloder_verisoft.api;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.BuildConfig;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

public class DeviationsRepository {

    public static List<Deviation> fetchPopularDeviations() {
        return DeviantartAPI.getServices(BuildConfig.API_URL)
                .getPopularDeviations(getAccessToken())
                .toDeviationList();
    }

    private static String getAccessToken() {
        return DeviantartAPI.getServices(BuildConfig.ACCESS_TOKEN_URL).getAccessToken().accessToken;
    }

}
