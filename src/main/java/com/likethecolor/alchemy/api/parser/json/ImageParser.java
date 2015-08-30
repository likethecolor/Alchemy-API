package com.likethecolor.alchemy.api.parser.json;

import com.likethecolor.alchemy.api.entity.ImageEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ainurminibaev on 30.08.15.
 */
public class ImageParser extends AbstractParser<ImageEntity> {
    @Override
    protected void populateResponse(Response<ImageEntity> response) {
        JSONObject jsonObject = getJSONObject();
        JSONArray imageKeywords = getJSONArray(JSONConstants.IMAGE_KEYWORDS_KEY, jsonObject);
        for (int i = 0; i < imageKeywords.length(); i++) {
            JSONObject keyword = getJSONObject(imageKeywords, i);
            ImageEntity imageEntity = new ImageEntity(getDouble(JSONConstants.IMAGE_KEYWORD_SCORE_KEY, keyword), getString(JSONConstants.IMAGE_KEYWORD_TEXT_KEY, keyword));
            response.addEntity(imageEntity);
        }
    }
}
