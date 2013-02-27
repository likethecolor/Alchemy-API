package com.likethecolor.alchemy;

import com.likethecolor.alchemy.api.Client;
import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.call.SentimentCall;
import com.likethecolor.alchemy.api.call.type.CallTypeUrl;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws IOException {
		AbstractCall<SentimentAlchemyEntity> call;
		final Client<SentimentAlchemyEntity> client = new Client<SentimentAlchemyEntity>("/key.txt");

		//    call = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
		//    System.out.println(client.call(call));
		//    System.out.println();
		//
		//    call = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
		//    Response response = client.call(call);
		//    System.out.println(response);
		//    System.out.println();
		//
		////More examples:
		//
		//    call = new CategoryCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new LanguageCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new MicroformatDataCall(new CallTypeUrl("http://microformats.org/wiki/hcard"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new RankedCategoryCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new RankedConceptsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new RankedKeywordsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new RawTextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new RelationsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		// Big Blue's Bet on Big Data
		call = new SentimentCall(new CallTypeUrl("http://www.answers.com/article/3b7a1506797deda268075f0886eac4d8"));
		Response<SentimentAlchemyEntity> response = client.call(call);

		System.out.println("Language: " + response.getLanguage());
		System.out.println("Status: " + response.getStatus());
		System.out.println("Status Info: " + response.getStatusInfo());
		System.out.println("Text: " + response.getText());
		System.out.println("Usage: " + response.getUsage());
		System.out.println("URL: " + response.getURL());

		SentimentAlchemyEntity entity;
		Iterator<SentimentAlchemyEntity> iter = response.iterator();
		while (iter.hasNext()) {
			entity = iter.next();
			System.out.println("isMixed: " + (entity.isMixed() ? "true" : "false"));
			System.out.println("Score: " + entity.getScore());
			System.out.println("Type: " + entity.getType());
		}

		//    call = new SentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call));
		//    System.out.println();
		//
		//    call = new TextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		//    call = new TitleCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
		//    System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));
		//    System.out.println();
		//
		////Setting Optional Values
		////-----------------------
		//    final TargetedSentimentParams params = new TargetedSentimentParams();
		//    params.setTarget("Schrenker");
		//    call = new TargetedSentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"), params);
		//    System.out.println(client.call(call));
		//    System.out.println();
		//
		//    final NamedEntityParams namedEntityParams = new NamedEntityParams();
		//    namedEntityParams.setIsCoreference(true);
		//    namedEntityParams.setIsDisambiguate(true);
		//    namedEntityParams.setIsLinkedData(true);
		//    namedEntityParams.setIsQuotations(true);
		//    namedEntityParams.setIsSentiment(true);
		//    namedEntityParams.setIsShowSourceText(true);
		//    call = new RankedNamedEntitiesCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"), namedEntityParams);
		//    response = client.call(call);
		//    System.out.println(response.toString(ToStringStyle.MULTI_LINE_STYLE));
	}

	// utility function
	private static String getFileContents(String filename) throws IOException, FileNotFoundException {
		File file = new File(filename);
		StringBuilder contents = new StringBuilder();

		BufferedReader input = null;

		try {
			input = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = input.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

		return contents.toString();
	}
}
