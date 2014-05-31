/**
 * File: AbstractParser.java
 * Original Author: Dan Brown <dan@likethecolor.com>
 * Copyright 2012 Dan Brown <dan@likethecolor.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.likethecolor.alchemy.api.parser.json;

import com.likethecolor.alchemy.api.entity.AbstractAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class that parsers should inherit from. As a template pattern it
 * provides some template methods that are used by most subclasses.
 */
public abstract class AbstractParser<T extends AbstractAlchemyEntity> {
  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractParser.class);
  private JSONObject jsonObject;

  public Response<T> parse(final String jsonString) {
    jsonObject = getJSONObject(jsonString);
    Response<T> response = parseHeader();
    populateResponse(response);
    return response;
  }

  protected abstract void populateResponse(final Response<T> response);

  private Response<T> parseHeader() {
    Response<T> response = new Response<T>();
    response.setLanguage(getString(JSONConstants.RESULTS_LANGUAGE, getJSONObject()));
    response.setStatus(getString(JSONConstants.RESULTS_STATUS, getJSONObject()));
    response.setStatusInfo(getString(JSONConstants.RESULTS_STATUS_INFO, getJSONObject()));
    response.setText(getString(JSONConstants.RESULTS_TEXT, getJSONObject()));
    response.setURL(getString(JSONConstants.RESULTS_URL, getJSONObject()));
    response.setUsage(getString(JSONConstants.RESULTS_USAGE, getJSONObject()));
    return response;
  }

  /**
   * Return the json object that was created in the {@link #parse(String)}
   * method.
   *
   * @return json object that was created in the {@link #parse(String)} method
   */
  public JSONObject getJSONObject() {
    return jsonObject;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a boolean. If no key is found null is returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return boolean value corresponding to the key or null if key not found
   */
  protected Boolean getBoolean(final String key, final JSONObject jsonObject) {
    Boolean value = null;
    if(hasKey(key, jsonObject)) {
      try {
        value = jsonObject.getBoolean(key);
      }
      catch(JSONException e) {
        LOGGER.error("Could not get boolean from JSONObject for key: {}.", key, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a double. If no key is found null is returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return double value corresponding to the key or null if key not found
   */
  protected Double getDouble(final String key, final JSONObject jsonObject) {
    Double value = null;
    if(hasKey(key, jsonObject)) {
      try {
        value = jsonObject.getDouble(key);
      }
      catch(JSONException e) {
        LOGGER.error("Could not get Double from JSONObject for key: {}.", key, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a integer. If no key is found null is returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return integer value corresponding to the key or null if key not found
   */
  protected Integer getInteger(final String key, final JSONObject jsonObject) {
    Integer value = null;
    if(hasKey(key, jsonObject)) {
      try {
        value = jsonObject.getInt(key);
      }
      catch(JSONException e) {
        LOGGER.error("Could not get Integer from JSONObject for key: {}.", key, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a long. If no key is found null is returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return long value corresponding to the key or null if key not found
   */
  protected Long getLong(final String key, final JSONObject jsonObject) {
    Long value = null;
    if(hasKey(key, jsonObject)) {
      try {
        value = jsonObject.getLong(key);
      }
      catch(JSONException e) {
        LOGGER.error("Could not get Long from JSONObject for key: {}.", key, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a string. If no key is found "" is returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return string value corresponding to the key or null if key not found
   */
  protected String getString(final String key, final JSONObject jsonObject) {
    String value = null;
    if(hasKey(key, jsonObject)) {
      try {
        value = jsonObject.getString(key);
      }
      catch(JSONException e) {
        LOGGER.error("Could not get String from JSONObject for key: {}.", key, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a string. If no key is found "" is returned.
   *
   * @param index index of the field to fetch from the json array
   * @param jsonArray array from which to fetch the value
   *
   * @return string value corresponding to the index or null if index not found
   */
  protected String getString(final int index, final JSONArray jsonArray) {
    String value = null;
    if(jsonArray != null && index > -1 && jsonArray.length() > index) {
      try {
        Object o = jsonArray.get(index);
        if(o != null) {
          value = o.toString();
        }
      }
      catch(JSONException e) {
        LOGGER.error("Could not get String from JSONObject for index: {}.", index, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a JSONArray. If no key is found an empty JSONArray is
   * returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return json array value corresponding to the key or "" if key not found
   */
  protected JSONArray getJSONArray(final String key, final JSONObject jsonObject) {
    JSONArray value = new JSONArray();
    if(hasKey(key, jsonObject)) {
      try {
        value = jsonObject.getJSONArray(key);
      }
      catch(JSONException e) {
        LOGGER.error("Could not get JSONArray from JSONObject for key: {}.", key, e);
      }
    }
    return value;
  }

  /**
   * Check to make sure the JSONObject has the specified key and if so return
   * the value as a JSONObject. If no key is found null is returned.
   *
   * @param key name of the field to fetch from the json object
   * @param jsonObject object from which to fetch the value
   *
   * @return json object value corresponding to the key or null if key not found
   */
  protected JSONObject getJSONObject(final String key, final JSONObject jsonObject) {
    JSONObject json = null;
    try {
      if(hasKey(key, jsonObject)) {
        json = jsonObject.getJSONObject(key);
      }
    }
    catch(JSONException e) {
      LOGGER.error("Could not get JSONObject from JSONObject for key: {}.", key, e);
    }
    return json;
  }

  /**
   * Return a json object from the provided array.  Return an empty object if
   * there is any problems fetching the named entity data.
   *
   * @param jsonArray array of data
   * @param index of the object to fetch
   *
   * @return json object from the provided array
   */
  protected JSONObject getJSONObject(final JSONArray jsonArray, final int index) {
    JSONObject object = new JSONObject();
    try {
      object = (JSONObject) jsonArray.get(index);
    }
    catch(JSONException e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Fetch a JSONObject from the provided string.
   *
   * @param jsonString json string
   *
   * @return json object representing the string or null if there is an exception
   */
  protected JSONObject getJSONObject(final String jsonString) {
    JSONObject json = new JSONObject();
    try {
      json = new JSONObject(jsonString);
    }
    catch(NullPointerException e) {
      LOGGER.error("JSON string cannot be null.", e);
    }
    catch(JSONException e) {
      LOGGER.error("Could not parse string into JSONObject.", e);
    }
    return json;
  }

  /**
   * Does the JSONObject have a specified key?
   *
   * @param key key to check
   * @param jsonObject object to check
   *
   * @return true if the key exists
   */
  protected boolean hasKey(final String key, final JSONObject jsonObject) {
    return jsonObject != null
           && jsonObject.has(key);
  }
}
