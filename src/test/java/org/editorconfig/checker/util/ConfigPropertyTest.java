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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by Valentin Brandl on 15.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class ConfigPropertyTest {
    /**
     * Test method for {@link ConfigProperty#fromString(String)}.
     * @throws Exception If the test fails
     */
    @Test
    public void fromString() throws Exception {
        assertEquals(ConfigProperty.CHARSET, ConfigProperty.fromString("charsEt"));
        assertEquals(ConfigProperty.END_OF_LINE, ConfigProperty.fromString("end_of_lIne"));
        assertEquals(ConfigProperty.INDENT_SIZE, ConfigProperty.fromString("indent_siZe"));
        assertEquals(ConfigProperty.INDENT_STYLE, ConfigProperty.fromString("inDent_style"));
        assertEquals(ConfigProperty.INSERT_FINAL_NEWLINE, ConfigProperty.fromString("Insert_final_newline"));
        assertEquals(ConfigProperty.MAX_LINE_LENGTH, ConfigProperty.fromString("Max_Line_Length"));
        assertEquals(ConfigProperty.TAB_WIDTH, ConfigProperty.fromString("tAb_width"));
        assertEquals(ConfigProperty.TRIM_TRAILING_WHITESPACE, ConfigProperty.fromString("triM_trailing_whitespace"));
        assertEquals(ConfigProperty.NONE, ConfigProperty.fromString("invalid_property"));
    }

}
