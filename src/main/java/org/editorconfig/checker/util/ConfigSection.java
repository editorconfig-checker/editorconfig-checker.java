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
 * Config section
 *
 * <p>Describes a section from a {@code .editorconfig} file
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class ConfigSection {

    private final String wildcard;
    private final IndentStyle indentStyle;
    private final int indentSize;
    private final EndOfLine eol;
    private final Charset charset;
    private final boolean trimTrailingWhitespace;
    private final boolean insertFinalNewline;

    public String getWildcard() {
        return wildcard;
    }

    public IndentStyle getIndentStyle() {
        return indentStyle;
    }

    public int getIndentSize() {
        return indentSize;
    }

    public EndOfLine getEol() {
        return eol;
    }

    public Charset getCharset() {
        return charset;
    }

    public boolean isTrimTrailingWhitespace() {
        return trimTrailingWhitespace;
    }

    public boolean isInsertFinalNewline() {
        return insertFinalNewline;
    }

    /**
     * Ctor.
     * @param wildcard filename wildcard (section name)
     * @param indentStyle indent style for this section
     * @param indentSize indent size for this section
     * @param eol end of line pattern for this section
     * @param charset charset
     * @param trimTrailingWhitespace trimTrailingWhitespace
     * @param insertFinalNewline insertFinalNewline
     */
    public ConfigSection(final String wildcard, final IndentStyle indentStyle, final int indentSize,
            final EndOfLine eol, final Charset charset, final boolean trimTrailingWhitespace,
            final boolean insertFinalNewline) {
        this.wildcard = wildcard;
        this.indentStyle = indentStyle;
        this.indentSize = indentSize;
        this.eol = eol;
        this.charset = charset;
        this.trimTrailingWhitespace = trimTrailingWhitespace;
        this.insertFinalNewline = insertFinalNewline;
    }
}
