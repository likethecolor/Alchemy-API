/**
 * File: NumberUtilTest.java
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
package com.likethecolor.alchemy.api.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NumberUtilTest {
  @Test
  public void testMinFromRange_One() {
    int minimum = 4;
    String number = "4";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Ten() {
    int minimum = 65;
    String number = "65";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Hundred() {
    int minimum = 645;
    String number = "645";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Thousand() {
    int minimum = 6450;
    String number = "6.45 thousand";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Millions() {
    int minimum = 6454454;
    String number = "6454454";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);

    number = "6.454454 million";

    actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Range_One() {
    int minimum = 3;
    String number = "3-4";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Range_Hundred() {
    int minimum = 542;
    String number = "542-666";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Range_Thousand() {
    int minimum = 309000;
    String number = "309-400 thousand";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_Range_Millions() {
    int minimum = 309000000;
    String number = "309-400 million";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_MoreThanTwoTerms_UnitIgnored() {
    int minimum = 309;
    String number = "309-400 thousand foo";

    int actualMinimum = NumberUtil.minimumFromRange(number);

    assertEquals(minimum, actualMinimum);
  }

  @Test
  public void testMinFromRange_NullEmptyValue() {
    final int minimum = 0;

    // null
    assertEquals(minimum, NumberUtil.minimumFromRange(null));

    // empty string
    assertEquals(minimum, NumberUtil.minimumFromRange(""));

    // empty white space string
    assertEquals(minimum, NumberUtil.minimumFromRange("\t  \r\n"));

    // non-numeric single/one
    assertEquals(minimum, NumberUtil.minimumFromRange("a"));

    // non-numeric double/ten
    assertEquals(minimum, NumberUtil.minimumFromRange("ab"));

    // non-numeric triple/hundred
    assertEquals(minimum, NumberUtil.minimumFromRange("abc"));

    // non-numeric long value
    assertEquals(minimum, NumberUtil.minimumFromRange("abcdefghijlmnopqrstuvwxyz"));

    // non-numeric range single/one
    assertEquals(minimum, NumberUtil.minimumFromRange("a-b"));

    // non-numeric range double/ten
    assertEquals(minimum, NumberUtil.minimumFromRange("ab-cd"));

    // non-numeric range triple/hundred
    assertEquals(minimum, NumberUtil.minimumFromRange("abc-def"));

    // non-numeric with unit
    assertEquals(minimum, NumberUtil.minimumFromRange("a thousand"));

    // non-numeric range with unit
    assertEquals(minimum, NumberUtil.minimumFromRange("ab-cd million"));

    // non-numeric with unknown unit
    assertEquals(minimum, NumberUtil.minimumFromRange("bbb mill"));

    // 3 terms
    assertEquals(minimum, NumberUtil.minimumFromRange("bbb million foo"));
  }



  @Test
  public void testMaxFromRange_Ten() {
    int maximum = 65;
    String number = "65";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Hundred() {
    int maximum = 645;
    String number = "645";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Thousand() {
    int maximum = 6450;
    String number = "6.45 thousand";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Millions() {
    int maximum = 6450000;
    String number = "6.45 million";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Range_One() {
    int maximum = 9;
    String number = "8-9";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Range_Ten() {
    int maximum = 62;
    String number = "49-62";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Range_Hundred() {
    int maximum = 999;
    String number = "309-999";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Range_Thousand() {
    int maximum = 400000;
    String number = "309-400 thousand";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_Range_Millions() {
    int maximum = 400000000;
    String number = "309-400 million";

    int actualMaximum = NumberUtil.maximumFromRange(number);

    assertEquals(maximum, actualMaximum);
  }

  @Test
  public void testMaxFromRange_NullEmptyValue() {
    final int maximum = 0;

    // null
    assertEquals(maximum, NumberUtil.maximumFromRange(null));

    // empty string
    assertEquals(maximum, NumberUtil.maximumFromRange(""));

    // empty white space string
    assertEquals(maximum, NumberUtil.maximumFromRange("\t  \r\n"));

    // non-numeric single/one
    assertEquals(maximum, NumberUtil.maximumFromRange("a"));

    // non-numeric double/ten
    assertEquals(maximum, NumberUtil.maximumFromRange("ab"));

    // non-numeric triple/hundred
    assertEquals(maximum, NumberUtil.maximumFromRange("abc"));

    // non-numeric long value
    assertEquals(maximum, NumberUtil.maximumFromRange("abcdefghijlmnopqrstuvwxyz"));

    // non-numeric range single/one
    assertEquals(maximum, NumberUtil.maximumFromRange("a-b"));

    // non-numeric range double/ten
    assertEquals(maximum, NumberUtil.maximumFromRange("ab-cd"));

    // non-numeric range triple/hundred
    assertEquals(maximum, NumberUtil.maximumFromRange("abc-def"));

    // non-numeric with unit
    assertEquals(maximum, NumberUtil.maximumFromRange("a thousand"));

    // non-numeric range with unit
    assertEquals(maximum, NumberUtil.maximumFromRange("ab-cd million"));

    // non-numeric with unknown unit
    assertEquals(maximum, NumberUtil.maximumFromRange("bbb mill"));

    // 3 terms
    assertEquals(maximum, NumberUtil.maximumFromRange("bbb million foo"));
  }
}
