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
 * Created by Valentin Brandl on 14.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public enum IndentStyle {
    /**
     * Use spaces for indentation.
     */
    SPACE(' '),
    /**
     * Use tabs for indentation.
     */
    TAB('\t'),
    /**
     * No indentation style specified.
     */
    NONE('\0');

    private final char indent;

    /**
     * Ctor.
     * @param indent The indentation character
     */
    IndentStyle(final char indent) {
        this.indent = indent;
    }

    /**
     * Getter for the indent value.
     * @return The indentation character
     */
    public char getIndent() {
        return this.indent;
    }

    /**
     * Get a {@link IndentStyle} object from a editorconfig setting string.
     * This method is case insensitive
     * @param value {@code space | tab} or rubbish
     * @return the corresponding {@link IndentStyle} or {@link IndentStyle#NONE}
     */
    public static IndentStyle fromString(final String value) {
        switch (value.toLowerCase()) {
            case "space":
                return SPACE;
            case "tab":
                return TAB;
            default:
                return NONE;
        }
    }
}
