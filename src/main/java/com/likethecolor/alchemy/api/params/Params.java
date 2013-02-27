/**
 * File: Params.java
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
package com.likethecolor.alchemy.api.params;

import com.likethecolor.alchemy.api.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Params {
	private String html;
	private String text;
	private String url;
	private int timeout;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		if (html != null) {
			html = html.trim();
		}
		this.html = html;
	}

	public String getOutputMode() {
		return Constants.DEFAULT_OUTPUT_FORMAT;
	}

	public void setText(String text) {
		if (text != null) {
			text = text.trim();
		}
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setTimeout(int timeout) {
		if (timeout < 0) {
			timeout = Constants.DEFAULT_CLIENT_TIMEOUT;
		}
		this.timeout = timeout;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setURL(String url) {
		if (url != null) {
			url = url.trim();
		}
		this.url = url;
	}

	public String getURL() {
		return url;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append(createParam(Constants.PARAM_HTML, encode(html)))
			.append(createParam(Constants.PARAM_TEXT, encode(text)))
			.append(createParam(Constants.PARAM_URL, encode(url)))
			.append(createParam(Constants.PARAM_OUTPUT_FORMAT, Constants.DEFAULT_OUTPUT_FORMAT))
			.toString();
	}

	protected String createParam(final String paramName, final String paramValue) {
		final StringBuilder param = new StringBuilder();
		if (!StringUtils.isBlank(paramValue)) {
			param.append("&")
				.append(paramName)
				.append("=")
				.append(paramValue.trim());
		}
		return param.toString();
	}

	protected String createParam(final String paramName, final int paramValue) {
		return new StringBuilder()
			.append("&")
			.append(paramName)
			.append("=")
			.append(paramValue)
			.toString();
	}

	protected String encode(final String value) {
		String encodedValue = "";
		if (StringUtils.isBlank(value)) {
			return encodedValue;
		}

		try {
			encodedValue = URLEncoder.encode(value, Constants.DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodedValue;
	}
}
