package br.com.bloder.helloworld_bloder_verisoft.api;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.BuildConfig;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

public class DeviationsRepository {

    private final static int limit = 10;

    public static List<Deviation> fetchPopularDeviations(int page) {
        return DeviantartAPI.getServices(BuildConfig.API_URL)
                .getPopularDeviations(getAccessToken(), limit, page * limit)
                .toDeviationList();
    }

    private static String getAccessToken() {
        return DeviantartAPI.getServices(BuildConfig.ACCESS_TOKEN_URL).getAccessToken().accessToken;
    }
}
