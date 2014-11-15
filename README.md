# Java Alchemy API

## About

Java Alchemy API is an interface to the [Alchemy API](http://www.alchemyapi.com/api/)

To access Alchemy's API you will need to [Register for an API Key](http://www.alchemyapi.com/api/register.html).

The Java SDK that Alchemy provides seemed very basic and incomplete to me so I created my own.

- They provide classes called "test" but they are examples.  They are not actual unit tests.

- The return object is always a dom Document.

- The source code format does not follow the Java standard.  For instance, method names begin with or contain
nothing but capital letters (e.g, GetInstanceFromFile, GET, POST).  Others are proper (e.g., getNodeValue)

- It gives the client the ability to specify the return format from the call to the service (either RDF or XML).
If you return objects there is no need for the client to specify or even care what the output format is.

### Be sure to see the [Changelog](https://github.com/likethecolor/Alchemy-API/blob/master/CHANGELOG.md)

### Note

A recent change (maven 1.1.0) has removed from the `Client` the loading of the API key from an external resource.

* `new Client()` does nothing

* `new Client(String)` expects the argument to be the API key

Removed:

* `new Client(String)` where the String is the classpath to a resource containing the API key

## Build

This project uses [Apache Maven](https://maven.apache.org/) to build.  To build and install into your local Maven repository:

        mvn clean install

## Maven Dependency

        <dependency>
            <groupId>com.likethecolor</groupId>
            <artifactId>alchemy</artifactId>
            <version>1.1.5</version>
        </dependency>

## Dependencies

You can look at the pom.xml to find the dependencies.  In short:

- [Apache Commons Lang](https://commons.apache.org/lang/)

- [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org/)

- [JSON](http://www.json.org/java/index.html)

Note that for testing the slf4j-log4j12 artifact is a dependency (scope: test).  Logging is available when running unit tests if needed.

## Code Examples

### Using Default Parameters

        final String apiKey = "0a1b2c3d4e5f6g7h8i9j0a1b2c3d4e5f6g7h8i9j";
        final Client client = new Client(apiKey);

        OR

        final Client client = new Client();
        client.setAPIKey(apiKey);

        final AbstractCall<AuthorAlchemyEntity> authorCall = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
        final Response response = client.call(authorCall);
        System.out.println(response);
        System.out.println();

which is slightly more verbose version of this:

        final AbstractCall<AuthorAlchemyEntity> authorCall = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
        System.out.println(client.call(authorCall));
        System.out.println();

More examples:

        final AbstractCall<LanguageAlchemyEntity> languageCall = new LanguageCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(languageCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<MicroformatAlchemyEntity> microformatCall = new MicroformatDataCall(new CallTypeUrl("http://microformats.org/wiki/hcard"));
        System.out.println(client.call(microformatCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<TaxonomyAlchemyEntity> rankedTaxonomyCall = new RankedTaxonomyCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(rankedTaxonomyCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<ConceptAlchemyEntity> rankedConceptsCall = new RankedConceptsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(rankedConceptsCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<KeywordAlchemyEntity> rankedKeywordsCall = new RankedKeywordsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(rankedKeywordsCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<HeaderAlchemyEntity> rawTextCall = new RawTextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(rawTextCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<RelationAlchemyEntity> relationsCall = new RelationsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(relationsCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(new CallTypeUrl("http://www.answers.com/article/3b7a1506797deda268075f0886eac4d8"));
        System.out.println(client.call(rawTextCall).toString(ToStringStyle.MULTI_LINE_STYLE);

        final AbstractCall<HeaderAlchemyEntity> textSentimentCall = new TextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(textSentimentCall).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall<TitleAlchemyEntity> titleCall = new TitleCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(titleCall).toString(ToStringStyle.MULTI_LINE_STYLE));

### Setting Optional Values

        final TargetedSentimentParams targetedSentimentParams = new TargetedSentimentParams();
        targetedSentimentParams.setTarget("Schrenker");

        final AbstractCall<SentimentAlchemyEntity> targetedSentimentCall = new TargetedSentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"), targetedSentimentParams);
        System.out.println(client.call(targetedSentimentCall));

        final NamedEntityParams namedEntityParams = new NamedEntityParams();
        namedEntityParams.setIsCoreference(true);
        namedEntityParams.setIsDisambiguate(true);
        namedEntityParams.setIsLinkedData(true);
        namedEntityParams.setIsQuotations(true);
        namedEntityParams.setIsSentiment(true);
        namedEntityParams.setIsShowSourceText(true);

        final AbstractCall<NamedEntityAlchemyEntity> rankedNamedEntitiesCall = new RankedNamedEntitiesCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"), namedEntityParams);
        final Response<NamedEntityAlchemyEntity> rankedNamedEntitiesResponse = client.call(rankedNamedEntitiesCall);
        System.out.println(rankedNamedEntitiesResponse.toString(ToStringStyle.MULTI_LINE_STYLE));

### Complete Example

        final String apiKey = "0a1b2c3d4e5f6g7h8i9j0a1b2c3d4e5f6g7h8i9j";
        final Client client = new Client(apiKey);

        // Big Blue's Bet on Big Data
        final AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(new CallTypeUrl("http://www.answers.com/article/3b7a1506797deda268075f0886eac4d8"));
        final Response<SentimentAlchemyEntity> sentimentResponse = client.call(sentimentCall);

        System.out.println("Language: " + sentimentResponse.getLanguage());
        System.out.println("Status: " + sentimentResponse.getStatus());
        System.out.println("Status Info: " + sentimentResponse.getStatusInfo());
        System.out.println("Text: " + sentimentResponse.getText());
        System.out.println("Usage: " + sentimentResponse.getUsage());
        System.out.println("URL: " + sentimentResponse.getURL());

        SentimentAlchemyEntity entity;
        final Iterator<SentimentAlchemyEntity> iter = sentimentResponse.iterator();
        while(iter.hasNext()) {
          entity = iter.next();
          System.out.println("isMixed: " + (entity.isMixed() ? "true" : "false"));
          System.out.println("Score: " + entity.getScore());
          System.out.println("Type: " + entity.getType());
        }

## Thanks

Thank you to the following for providing a second set of eyes and helping me
make this project better.

- [Amir Raminfar](findamir@gmail.com) [amir20](https://github.com/amir20)
- [bellorap](https://github.com/bellorap)
- [Yair Liberzon](yair.liberzon@zoomd.com) and [Sivan Ravid](sivan.ravid@zoomd.com)

## Authors

Dan Brown (<dan@likethecolor.com>)

## External API

- [Alchemy API](http://www.alchemyapi.com/api/)

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
