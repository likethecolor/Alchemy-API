/**
 * File: OutputStatusValidatorTest.java
 * Original Author: <dan@likethecolor.com>
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
package com.likethecolor.alchemy.api.validator;

import org.junit.Test;

import java.io.IOException;

public class OutputStatusValidatorTest {
  @Test
  public void testValidate() throws IOException {
    final String jsonString = getJson();

    OutputStatusValidator.validate(jsonString);
  }

  @Test(expected = IOException.class)
  public void testValidate_StatusError() throws IOException {
    final String jsonString = getJsonStatusIsNotOK();

    OutputStatusValidator.validate(jsonString);
  }

  @Test(expected = IOException.class)
  public void testValidate_StatusIsMissing() throws IOException {
    final String jsonString = getJsonStatusIsMissing();

    OutputStatusValidator.validate(jsonString);
  }

  @Test(expected = IOException.class)
  public void testValidate_StatusErrorStatusInfoMessageExists() throws IOException {
    final String jsonString = getJsonStatusIsNotOkStatusInfoError();

    OutputStatusValidator.validate(jsonString);
  }

  private String getJson() {
    return "{"
           + "\"status\": \"OK\""
           + "}";
  }

  private String getJsonStatusIsNotOK() {
    return "{"
           + "\"status\": \"ERROR\""
           + "}";
  }

  private String getJsonStatusIsMissing() {
    return "{}";
  }

  private String getJsonStatusIsNotOkStatusInfoError() {
    return "{"
           + "\"status\": \"ERROR\","
           + "\"statusInfo\": \"Error doing some IO thing\""
           + "}";
  }
}
