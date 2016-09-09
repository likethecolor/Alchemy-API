/**
 * Original Author: Dan Brown <dan@likethecolor.com>
 * Copyright 2015 Dan Brown <dan@likethecolor.com>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.likethecolor.alchemy;

import com.likethecolor.alchemy.api.Client;
import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.call.AuthorCall;
import com.likethecolor.alchemy.api.call.ImageCall;
import com.likethecolor.alchemy.api.call.LanguageCall;
import com.likethecolor.alchemy.api.call.MicroformatDataCall;
import com.likethecolor.alchemy.api.call.RankedConceptsCall;
import com.likethecolor.alchemy.api.call.RankedKeywordsCall;
import com.likethecolor.alchemy.api.call.RankedNamedEntitiesCall;
import com.likethecolor.alchemy.api.call.RankedTaxonomyCall;
import com.likethecolor.alchemy.api.call.RawTextCall;
import com.likethecolor.alchemy.api.call.RelationsCall;
import com.likethecolor.alchemy.api.call.SentimentCall;
import com.likethecolor.alchemy.api.call.TargetedSentimentCall;
import com.likethecolor.alchemy.api.call.TextCall;
import com.likethecolor.alchemy.api.call.TitleCall;
import com.likethecolor.alchemy.api.call.type.CallTypeUrl;
import com.likethecolor.alchemy.api.entity.AuthorAlchemyEntity;
import com.likethecolor.alchemy.api.entity.ConceptAlchemyEntity;
import com.likethecolor.alchemy.api.entity.HeaderAlchemyEntity;
import com.likethecolor.alchemy.api.entity.ImageEntity;
import com.likethecolor.alchemy.api.entity.KeywordAlchemyEntity;
import com.likethecolor.alchemy.api.entity.LanguageAlchemyEntity;
import com.likethecolor.alchemy.api.entity.MicroformatAlchemyEntity;
import com.likethecolor.alchemy.api.entity.NamedEntityAlchemyEntity;
import com.likethecolor.alchemy.api.entity.RelationAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import com.likethecolor.alchemy.api.entity.TaxonomyAlchemyEntity;
import com.likethecolor.alchemy.api.entity.TitleAlchemyEntity;
import com.likethecolor.alchemy.api.params.Language;
import com.likethecolor.alchemy.api.params.NamedEntityParams;
import com.likethecolor.alchemy.api.params.TargetedSentimentParams;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.IOException;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) throws IOException {
    final Client client = new Client("random0alchemy0api0key");

    AbstractCall<AuthorAlchemyEntity> authorCall = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
    System.out.println(client.call(authorCall));
    System.out.println();

    authorCall = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
    Response response = client.call(authorCall);
    System.out.println(response);
    System.out.println();
//
////More examples:
//
    AbstractCall<LanguageAlchemyEntity> languageCall = new LanguageCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(languageCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

    AbstractCall<MicroformatAlchemyEntity> microformatCall = new MicroformatDataCall(new CallTypeUrl("http://microformats.org/wiki/hcard"));
    System.out.println(client.call(microformatCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

		AbstractCall<TaxonomyAlchemyEntity> rankedTaxonomyCall = new RankedTaxonomyCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		System.out.println(client.call(rankedTaxonomyCall).toString(ToStringStyle.MULTI_LINE_STYLE));
		System.out.println();

		AbstractCall<ConceptAlchemyEntity> rankedConceptsCall = new RankedConceptsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(rankedConceptsCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

    AbstractCall<KeywordAlchemyEntity> rankedKeywordsCall = new RankedKeywordsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(rankedKeywordsCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

    AbstractCall<HeaderAlchemyEntity> rawTextCall = new RawTextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(rawTextCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

    AbstractCall<RelationAlchemyEntity> relationsCall = new RelationsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(relationsCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

    // Big Blue's Bet on Big Data
    AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(new CallTypeUrl("http://www.answers.com/article/3b7a1506797deda268075f0886eac4d8"));
    Response<SentimentAlchemyEntity> sentimentResponse = client.call(sentimentCall);

    System.out.println("Language: " + sentimentResponse.getLanguage());
    System.out.println("Status: " + sentimentResponse.getStatus());
    System.out.println("Status Info: " + sentimentResponse.getStatusInfo());
    System.out.println("Text: " + sentimentResponse.getText());
    System.out.println("Usage: " + sentimentResponse.getUsage());
    System.out.println("URL: " + sentimentResponse.getURL());

    SentimentAlchemyEntity entity;
    Iterator<SentimentAlchemyEntity> iter = sentimentResponse.iterator();
    while(iter.hasNext()) {
      entity = iter.next();
      System.out.println("isMixed: " + (entity.isMixed() ? "true" : "false"));
      System.out.println("Score: " + entity.getScore());
      System.out.println("Type: " + entity.getType());
    }

    sentimentCall = new SentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(sentimentCall));
    System.out.println();

    AbstractCall<HeaderAlchemyEntity> textSentimentCall = new TextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(textSentimentCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();

    AbstractCall<TitleAlchemyEntity> titleCall = new TitleCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(titleCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();
//
////Setting Optional Values
////-----------------------
    final TargetedSentimentParams params = new TargetedSentimentParams();
    params.setTarget("Schrenker");

    AbstractCall<SentimentAlchemyEntity> targetedSentimentCall = new TargetedSentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"), params);
    System.out.println(client.call(targetedSentimentCall));


    final NamedEntityParams namedEntityParams = new NamedEntityParams();
    namedEntityParams.setIsCoreference(true);
    namedEntityParams.setIsDisambiguate(true);
    namedEntityParams.setIsLinkedData(true);
    namedEntityParams.setIsQuotations(true);
    namedEntityParams.setIsSentiment(true);
    namedEntityParams.setIsShowSourceText(true);
    namedEntityParams.setLanguage(Language.ENGLISH);

    AbstractCall<NamedEntityAlchemyEntity> rankedNamedEntitiesCall = new RankedNamedEntitiesCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"), namedEntityParams);
    Response<NamedEntityAlchemyEntity> rankedNamedEntitiesResponse = client.call(rankedNamedEntitiesCall);
    System.out.println(rankedNamedEntitiesResponse.toString(ToStringStyle.MULTI_LINE_STYLE));

    AbstractCall<ImageEntity> imageCall = new ImageCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
    System.out.println(client.call(imageCall).toString(ToStringStyle.MULTI_LINE_STYLE));
    System.out.println();
  }
}
