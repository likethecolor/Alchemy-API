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

## Build

This project uses [Apache Maven](https://maven.apache.org/) to build.  To build and install into your local Maven repository:

        mvn clean install

## Dependencies

You can look at the pom.xml to find the dependencies.  In short:

- [Apache Commons Lang](https://commons.apache.org/lang/)

- [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org/)

- [JSON](http://www.json.org/java/index.html)

Note that for testing the slf4j-log4j12 artifact is a dependency (scope: test).  Logging is available when running unit tests if needed.

## Code Examples

### Using Default Parameters

        final Client client = new Client("/key-provided-by-alchemy.txt");

        final AbstractCall call = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
        System.out.println(client.call(call));

which is the same thing as this more verbose version:

        final AbstractCall call = new AuthorCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"));
        final Response response = client.call(call);
        System.out.println(response);

More examples:

        final AbstractCall call = new CategoryCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new LanguageCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new MicroformatDataCall(new CallTypeUrl("http://microformats.org/wiki/hcard"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new RankedCategoryCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new RankedConceptsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new RankedKeywordsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new RawTextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new RelationsCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new SentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call));

        final AbstractCall call = new TextCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

        final AbstractCall call = new TitleCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"));
        System.out.println(client.call(call).toString(ToStringStyle.MULTI_LINE_STYLE));

### Setting Optional Values

        final TargetedSentimentParams targetedSentimentParams = new TargetedSentimentParams();
        targetedSentimentParams.setTarget("Schrenker");

        final AbstractCall call = new TargetedSentimentCall(new CallTypeUrl("http://www.cnn.com/2009/CRIME/01/13/missing.pilot/index.html"), targetedSentimentParams);
        System.out.println(client.call(call));


        final NamedEntityParams namedEntityParams = new NamedEntityParams();
        namedEntityParams.setIsCoreference(true);
        namedEntityParams.setIsDisambiguate(true);
        namedEntityParams.setIsLinkedData(true);
        namedEntityParams.setIsQuotations(true);
        namedEntityParams.setIsSentiment(true);
        namedEntityParams.setIsShowSourceText(true);

        final AbstractCall call = new RankedNamedEntitiesCall(new CallTypeUrl("http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html"), namedEntityParams);
        response = client.call(call);
        System.out.println(response.toString(ToStringStyle.MULTI_LINE_STYLE));

### Complete Example

        // Big Blue's Bet on Big Data
        final AbstractCall call = new SentimentCall(new CallTypeUrl("http://www.answers.com/article/3b7a1506797deda268075f0886eac4d8"));
        final Response response = client.call(call);

        System.out.println("Language: " + response.getLanguage());
        System.out.println("Status: " + response.getStatus());
        System.out.println("Status Info: " + response.getStatusInfo());
        System.out.println("Text: " + response.getText());
        System.out.println("Usage: " + response.getUsage());
        System.out.println("URL: " + response.getURL());

        SentimentAlchemyEntity entity;
        final Iterator<SentimentAlchemyEntity> iter = response.iterator();
        while(iter.hasNext()) {
          entity = iter.next();
          System.out.println("isMixed: " + (entity.isMixed() ? "true" : "false"));
          System.out.println("Score: " + entity.getScore());
          System.out.println("Type: " + entity.getType());
        }

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
