/**
 * File: Client.java
 * Original Author: Dan Brown <dan.brown@answers.com>
 * Copyright 2012 Answers.com
 */
package com.likethecolor.alchemy.api;

import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.params.Params;
import com.likethecolor.alchemy.api.validator.ApiKeyValidator;
import com.likethecolor.alchemy.api.validator.OutputStatusValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
  private static final String API_KEY = "apikey";
  private static final String HEADER_CONTENT_LENGTH = "Content-Length";
  private static final String DEFAULT_URL = "http://access.alchemyapi.com/calls/";

  private String apiKey;
  private String requestUri = DEFAULT_URL;

  public Client() throws IOException {
  }

  public Client(final String apiKey) throws IOException {
    setAPIKey(apiKey);
  }

  public void setAPIKey(final String apiKey) {
    ApiKeyValidator.validate(apiKey);

    LOGGER.debug("api key: " + apiKey);
    this.apiKey = apiKey.trim();
  }

  public Response call(final AbstractCall call) throws IOException {
    final Params params = call.getParams();
    call.getCallType().setValuesOnParams(params);
    final String callName = call.getCallType().getPrefix() + call.getName();
    final String callPrefix = call.getCallType().getType();

    String jsonString;
    if(Constants.CALL_TYPE_URL.equals(call.getCallType().getType())) {
      jsonString = get(callName, callPrefix, params);
    }
    else {
      jsonString = post(callName, callPrefix, params);
    }
    LOGGER.debug("json string: " + jsonString);
    return call.parse(jsonString);
  }

  private String get(final String callName, String callPrefix, Params params) throws IOException {
    String jsonString = null;
    StringBuilder uri = new StringBuilder()
        .append(requestUri).append(callPrefix).append('/').append(callName)
        .append('?').append(API_KEY).append("=").append(this.apiKey)
        .append(params.toString());

    LOGGER.debug("GET: uri: " + uri);
    HttpURLConnection handle = null;
    try {
      URL url = new URL(uri.toString());
      handle = (HttpURLConnection) url.openConnection();
      handle.setDoOutput(true);
      jsonString = doRequest(handle);
    }
    finally {
      if(handle != null) {
        handle.disconnect();
      }
    }

    return jsonString;
  }

  private String post(final String callName, String callType, Params params) throws MalformedURLException {
    String jsonString = null;
    URL url = new URL(requestUri + callType + "/" + callName);

    StringBuilder data = new StringBuilder()
        .append(API_KEY).append("=").append(apiKey)
        .append(params.toString());

    LOGGER.debug("POST: url: " + url);
    LOGGER.debug("POST: data: " + data.toString());
    LOGGER.debug("POST: " + HEADER_CONTENT_LENGTH + ": " + data.length());

    DataOutputStream dataOutputStream = null;
    HttpURLConnection handle = null;
    try {
      handle = (HttpURLConnection) url.openConnection();
      handle.setDoOutput(true);
      handle.addRequestProperty(HEADER_CONTENT_LENGTH, Integer.toString(data.length()));

      dataOutputStream = new DataOutputStream(handle.getOutputStream());
      dataOutputStream.write(data.toString().getBytes());
      jsonString = doRequest(handle);
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    finally {
      if(dataOutputStream != null) {
        try {
          dataOutputStream.close();
        }
        catch(IOException e) {
          // ignore
        }
      }
      if(handle != null) {
        handle.disconnect();
      }
    }

    return jsonString;
  }

  private String doRequest(HttpURLConnection handle) throws IOException {
    if(handle == null) {
      return null;
    }

    StringBuilder builder = new StringBuilder();
    BufferedReader bufferedReader = null;
    DataInputStream dataInputStream;
    try {
      String line;
      dataInputStream = new DataInputStream(handle.getInputStream());
      bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
      while((line = bufferedReader.readLine()) != null) {
        builder.append(line.trim());
      }
    }
    finally {
      if(bufferedReader != null) {
        try {
          bufferedReader.close();
        }
        catch(IOException e) {
          // ignore
        }
      }
    }
    OutputStatusValidator.validate(builder.toString());

    return builder.toString();
  }
}
