package com.likethecolor.alchemy.api.call;

import com.likethecolor.alchemy.api.Constants;
import com.likethecolor.alchemy.api.call.type.CallTypeUrl;
import com.likethecolor.alchemy.api.entity.ImageEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.parser.json.ImageParser;

import java.util.IllegalFormatException;

/**
 * Created by ainurminibaev on 30.08.15.
 */
public class ImageCall extends AbstractCall<ImageEntity> {
    public ImageCall(CallTypeUrl callType) throws IllegalFormatException {
        super(callType);
    }

    @Override
    public String getName() {
        return Constants.CALL_NAME_IMAGE_RANKED_KEYWORDS;
    }

    @Override
    public Response<ImageEntity> parse(String jsonString) {
        return new ImageParser().parse(jsonString);
    }
}
