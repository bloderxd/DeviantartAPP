package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationJson;

/**
 * Created by denis on 25/11/15.
 */
public class DeviationListJson {

   @SerializedName("results") public final List<DeviationJson> deviationList;

    public DeviationListJson(List<DeviationJson> deviationList) {
        this.deviationList = deviationList;
    }

}
