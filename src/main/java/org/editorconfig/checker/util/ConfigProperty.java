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
    INDENT_STYLE("indent_style"),
    INDENT_SIZE("indent_size"),
    TAB_WIDTH("tab_width"),
    END_OF_LINE("end_of_line"),
    CHARSET("charset"),
    TRIM_TRAILING_WHITESPACE("trim_trailing_whitespace"),
    INSERT_FINAL_NEWLINE("insert_final_newline"),
    MAX_LINE_LENGTH("max_line_length"),
    NONE(null);

    private final String value;
    ConfigProperty(final String value) {
        this.value = value;
    }

    public static ConfigProperty fromString(final String value) {
        for(final ConfigProperty cp : ConfigProperty.values()) {
            if (value.equalsIgnoreCase(cp.value)) {
                return cp;
            }
        }
        return NONE;
    }
}
