package br.com.bloder.helloworld_bloder_verisoft.values;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;

/**
 * Created by bloder on 30/11/15.
 */
public class InsertDeviation {

    public static List<Deviation> InsertDeviation(DeviationListJson deviationListJson){
        List<Deviation> deviationList = new ArrayList<>();
        for(int i = 0; i<deviationListJson.deviationList.size(); i++){
            deviationList.add(new Deviation(deviationListJson.deviationList.get(i).title,deviationListJson.deviationList.get(i).content.src,deviationListJson.deviationList.get(i).author.username,deviationListJson.deviationList.get(i).author.usericon));
        }
        return deviationList;
    }

}
