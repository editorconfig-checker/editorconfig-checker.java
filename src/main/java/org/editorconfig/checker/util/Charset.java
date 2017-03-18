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
public enum Charset {
    /**
     * latin1
     */
    LATIN1,
    /**
     * utf-8
     */
    UTF_8,
    /**
     * utf-8-bom
     */
    UTF_8_BOM,
    /**
     * utf-16be
     */
    UTF_16BE,
    /**
     * utf-16le
     */
    UTF_16LE,
    /**
     * Dummy value
     */
    NONE;

    public static Charset fromString(final String value) {
        switch(value.toLowerCase()) {
            case "latin1":
                return LATIN1;
            case "utf-8":
                return UTF_8;
            case "utf-8-bom":
                return UTF_8_BOM;
            case "utf-16be":
                return UTF_16BE;
            case "utf-16le":
                return UTF_16LE;
            default:
                return NONE;
        }
    }
}
