package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationJson;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

public class DeviationListJson {

   @SerializedName("results") private final List<DeviationJson> deviationList;

    public DeviationListJson(List<DeviationJson> deviationList) {
        this.deviationList = deviationList;
    }

    public List<Deviation> toDeviationList() {
        List<Deviation> deviations = new ArrayList<>();

        for (DeviationJson deviationJson : deviationList) {
            try {
                deviations.add(deviationJson.toDeviation());
            }catch (Exception ex){

            }
        }
        return deviations;
    }
}
