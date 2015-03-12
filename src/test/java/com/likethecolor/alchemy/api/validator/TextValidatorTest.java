/**
 * File: TextValidatorTest.java
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

public class TextValidatorTest {
  @Test(expected = IllegalArgumentException.class)
  public void testValidate_NullText() {
    TextValidator.validate(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_TextLessThanMinimumLength() {
    TextValidator.validate("a");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidate_TextTrimmedLessThanMinimumLength() {
    TextValidator.validate("\ta\r\n  ");
  }

  @Test
  public void testValidate_TextEqualsMinimumLength() {
    TextValidator.validate("ok");
  }

  @Test
  public void testValidate() {
    TextValidator.validate("What is the speed of an unladen swallow?");
  }
}
