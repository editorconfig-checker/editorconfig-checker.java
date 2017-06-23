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
public enum EndOfLine {
    /**
     * Linefeed.
     */
    LF("\n"),
    /**
     * Carriage return.
     */
    CR("\r"),
    /**
     * Carriage return followed by linefeed.
     */
    CRLF("\r\n"),
    /**
     * Dummy value.
     */
    NONE("");

    private final String eol;

    /**
     * Ctor.
     * @param eol end of line marker
     */
    EndOfLine(final String eol) {
        this.eol = eol;
    }

    /**
     * Getter for the end of line marker.
     * @return The end of line value
     */
    public String getEol() {
        return this.eol;
    }

    /**
     * Returns the enum representing a given value. This method is case insensitive
     * @param value the value to convert
     * @return the corresponding {@link EndOfLine} or {@link EndOfLine#NONE}
     */
    public static EndOfLine fromString(final String value) {
        switch (value.toLowerCase()) {
            case "lf":
                return LF;
            case "cr":
                return CR;
            case "crlf":
                return CRLF;
            default:
                return NONE;
        }
    }
}
