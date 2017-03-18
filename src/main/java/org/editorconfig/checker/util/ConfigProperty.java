/*
 * MIT License
 *
 * Copyright (c) 2017
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies and substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANNY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USER OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.editorconfig.checker.util;

/**
 * Created by Valentin Brandl on 15.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public enum ConfigProperty {
    /**
     * {@code indent_style} property
     */
    INDENT_STYLE("indent_style"),
    /**
     * {@code indent_size} property
     */
    INDENT_SIZE("indent_size"),
    /**
     * {@code tab_width} property
     */
    TAB_WIDTH("tab_width"),
    /**
     * {@code end_of_line} property
     */
    END_OF_LINE("end_of_line"),
    /**
     * {@code charset} property
     */
    CHARSET("charset"),
    /**
     * {@code trim_trailing_whitespace} property
     */
    TRIM_TRAILING_WHITESPACE("trim_trailing_whitespace"),
    /**
     * {@code insert_final_newline} property
     */
    INSERT_FINAL_NEWLINE("insert_final_newline"),
    /**
     * {@code max_line_length} property
     */
    MAX_LINE_LENGTH("max_line_length"),
    /**
     * Unknown or invalid property
     */
    NONE("");

    private final String value;

    /**
     * Ctor.
     * @param value the enum value
     */
    ConfigProperty(final String value) {
        this.value = value;
    }

    /**
     * Returns the enum representing a given value. This method is case insensitive.
     * @param value the value to convert
     * @return the corresponding {@link ConfigProperty} or {@link ConfigProperty#NONE}
     */
    public static ConfigProperty fromString(final String value) {
        for(final ConfigProperty cp : ConfigProperty.values()) {
            if (value.equalsIgnoreCase(cp.value)) {
                return cp;
            }
        }
        return NONE;
    }
}
