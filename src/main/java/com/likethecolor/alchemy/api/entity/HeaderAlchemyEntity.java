/**
 * File: AlchemyHeader.java
 *
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
package com.likethecolor.alchemy.api.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class HeaderAlchemyEntity extends AbstractAlchemyEntity {
  private String language;
  private Response.STATUS status;
  private String statusInfo;
  private String text;
  private String url;
  private String usage;

  public HeaderAlchemyEntity() {
    status = Response.STATUS.UNSET;
  }

  public void setLanguage(String language) {
    if(language != null) {
      language = language.trim();
    }
    this.language = language;
  }

  public String getLanguage() {
    return language;
  }

  public void setStatus(String status) {
    if(Response.STATUS.OK.toString().equalsIgnoreCase(status)) {
      this.status = Response.STATUS.OK;
    }
    if(Response.STATUS.ERROR.toString().equalsIgnoreCase(status)) {
      this.status = Response.STATUS.ERROR;
    }
    if(Response.STATUS.UNSET.toString().equalsIgnoreCase(status)) {
      this.status = Response.STATUS.UNSET;
    }
  }

  public Response.STATUS getStatus() {
    return status;
  }

  public void setStatusInfo(String statusInfo) {
    if(statusInfo != null) {
      statusInfo = statusInfo.trim();
    }
    this.statusInfo = statusInfo;
  }

  public String getStatusInfo() {
    return statusInfo;
  }

  public void setText(String text) {
    if(text != null) {
      text = text.trim();
    }
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setURL(String url) {
    if(url != null) {
      url = url.trim();
    }
    this.url = url;
  }

  public String getURL() {
    return url;
  }

  public void setUsage(String usage) {
    if(usage != null) {
      usage = usage.trim();
    }
    this.usage = usage;
  }

  public String getUsage() {
    return usage;
  }

  public HeaderAlchemyEntity clone() {
    final HeaderAlchemyEntity clone = new HeaderAlchemyEntity();
    clone.setLanguage(getLanguage());
    clone.setStatus(getStatus().toString());
    clone.setStatusInfo(getStatusInfo());
    clone.setText(getText());
    clone.setURL(getURL());
    clone.setUsage(getUsage());
    return clone;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    HeaderAlchemyEntity response = (HeaderAlchemyEntity) o;
    if(language != null ? !language.equals(response.language)
                        : response.language != null) {
      return false;
    }
    if(status != response.status) {
      return false;
    }
    if(statusInfo != null ? !statusInfo.equals(response.statusInfo)
                          : response.statusInfo != null) {
      return false;
    }
    if(text != null ? !text.equals(response.text) : response.text != null) {
      return false;
    }
    if(url != null ? !url.equals(response.url) : response.url != null) {
      return false;
    }
    if(usage != null ? !usage.equals(response.usage) : response.usage != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = language != null ? language.hashCode() : 0;
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (statusInfo != null ? statusInfo.hashCode() : 0);
    result = 31 * result + (text != null ? text.hashCode() : 0);
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + (usage != null ? usage.hashCode() : 0);
    return result;
  }

  /**
   * @return string representing this object
   *
   * @see #toString(org.apache.commons.lang.builder.ToStringStyle)
   */
  @Override
  public String toString() {
    return toString(ToStringStyle.DEFAULT_STYLE);
  }

  /**
   * @return string representing this object
   *
   * @see org.apache.commons.lang.builder.ToStringBuilder
   */
  public String toString(final ToStringStyle style) {
    // note - do not do super.toString
    // it will result in a StackOverflowError from ToStringStyle
    return new ToStringBuilder(this, style)
        .append("language", getLanguage())
        .append("status", getStatus())
        .append("text", getText())
        .append("url", getURL())
        .append("usage", getUsage())
        .toString();
  }}
