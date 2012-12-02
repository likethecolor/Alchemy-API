/**
 * File: NumberUtil.java
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

import org.apache.commons.lang.StringUtils;

public class NumberUtil {
  private static final String UNIT_MILLION = "million";
  private static final String UNIT_THOUSAND = "thousand";
  private static final String RANGE_UNIT_PATTERN = "\\s+";
  private static final String RANGE_PATTERN = "\\s*-\\s*";

  /**
   * Return the minimum value for the given range.  Examples:
   * <p/>
   * <pre>
   * NumberUtil.minimumFromRange(null)             = 0
   * NumberUtil.minimumFromRange("")               = 0
   * NumberUtil.minimumFromRange(" ")              = 0
   * NumberUtil.minimumFromRange("ab2c")           = 0
   * NumberUtil.minimumFromRange("ab-c")           = 0
   * NumberUtil.minimumFromRange("ab2c thousand")  = 0
   * NumberUtil.minimumFromRange("ab-c million")   = 0
   * NumberUtil.minimumFromRange("5")              = 5
   * NumberUtil.minimumFromRange("5-6")            = 5
   * NumberUtil.minimumFromRange("50")             = 50
   * NumberUtil.minimumFromRange("50-60")          = 50
   * NumberUtil.minimumFromRange("500")            = 500
   * NumberUtil.minimumFromRange("500-600")        = 500
   * NumberUtil.minimumFromRange("400")            = 400
   * NumberUtil.minimumFromRange("400-500")        = 400
   * NumberUtil.minimumFromRange("4-5 thousand")   = 4000
   * NumberUtil.minimumFromRange("4-5 million")    = 4000000
   * </pre>
   *
   * @return minimum value for the given range
   */
  public static int minimumFromRange(String range) {
    final boolean getMaximumValue = false;
    return getValue(range, getMaximumValue);
  }

  /**
   * Return the maximum value for the given range.  Examples:
   * <p/>
   * <pre>
   * NumberUtil.maximumFromRange(null)             = 0
   * NumberUtil.maximumFromRange("")               = 0
   * NumberUtil.maximumFromRange(" ")              = 0
   * NumberUtil.maximumFromRange("ab2c")           = 0
   * NumberUtil.maximumFromRange("ab-c")           = 0
   * NumberUtil.maximumFromRange("ab2c thousand")  = 0
   * NumberUtil.maximumFromRange("ab-c million")   = 0
   * NumberUtil.maximumFromRange("5")              = 5
   * NumberUtil.maximumFromRange("5-6")            = 6
   * NumberUtil.maximumFromRange("50")             = 50
   * NumberUtil.maximumFromRange("50-60")          = 60
   * NumberUtil.maximumFromRange("500")            = 500
   * NumberUtil.maximumFromRange("500-600")        = 600
   * NumberUtil.maximumFromRange("400")            = 400
   * NumberUtil.maximumFromRange("400-500")        = 500
   * NumberUtil.maximumFromRange("4-5 thousand")   = 5000
   * NumberUtil.maximumFromRange("4-5 million")    = 5000000
   * </pre>
   *
   * @return maximum value for the given range
   */
  public static int maximumFromRange(String range) {
    final boolean getMaximumValue = true;
    return getValue(range, getMaximumValue);
  }

  /**
   * Return the specified value from the string.
   *
   * @param str string to parse; assume it is either a single value or a range (delimited by "-")
   * @param getMaximumValue if true return the maximum value
   * @return specified value from the string
   */
  private static int getValue(String str, boolean getMaximumValue) {
    int multiplier = 1;
    String upperOrLowerValue = null;

    final String[] rangeUnit = splitRangeUnit(str);

    if(rangeUnit.length == 2) {
      multiplier = getMultiplier(rangeUnit[1]);
    }

    String[] range = splitRange(rangeUnit[0]);
    upperOrLowerValue = range[0];

    if(range.length == 2) {
      if(getMaximumValue) {
        upperOrLowerValue = range[1];
      }
    }
    return (int) (convertStringToDouble(upperOrLowerValue) * multiplier);
  }

  /**
   * Return the string array that has been split using {@link #RANGE_UNIT_PATTERN}
   *
   * @param str string to split
   *
   * @return string array that has been split using {@link #RANGE_UNIT_PATTERN}
   */
  private static String[] splitRangeUnit(final String str) {
    if(StringUtils.isBlank(str)) {
      return new String[]{""};
    }
    return str.split(RANGE_UNIT_PATTERN);
  }

  /**
   * Return the string array that has been split using {@link #RANGE_PATTERN}
   *
   * @param str string to split
   *
   * @return string array that has been split using {@link #RANGE_PATTERN}
   */
  private static String[] splitRange(final String str) {
    if(StringUtils.isBlank(str)) {
      return new String[]{""};
    }
    return str.split(RANGE_PATTERN);
  }

  /**
   * Return the double value for the given string value.  If the value cannot be
   * converted (e.g., is not a number) 0 will be returned.
   *
   * @param value value to convert
   *
   * @return double value for the given string value
   */
  private static double convertStringToDouble(final String value) {
    double doubleValue = 0;
    if(!StringUtils.isBlank(value)) {
      try {
        doubleValue = Double.parseDouble(value.trim());
      }
      catch(Exception e) {
        // do nothing
      }
    }
    return doubleValue;
  }

  /**
   * Return the multiplier based on the unit.  It must be one of {@link #UNIT_THOUSAND}
   * or {@link #UNIT_MILLION}.
   *
   * @param unit unit to key off of
   *
   * @return multiplier based on the unit
   */
  private static int getMultiplier(final String unit) {
    int multiplier = 1;
    if(!StringUtils.isBlank(unit)) {
      if(UNIT_MILLION.equalsIgnoreCase(unit.trim())) {
        multiplier = 1000000;
      }
      if(UNIT_THOUSAND.equalsIgnoreCase(unit.trim())) {
        multiplier = 1000;
      }
    }
    return multiplier;
  }
}
