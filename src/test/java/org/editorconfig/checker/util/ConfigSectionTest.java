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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test case for {@link ConfigSection}
 *
 * <p>Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class ConfigSectionTest {

    private ConfigSection section;

    /**
     * Sets up the test environment.
     * @throws Exception If the setup fails
     */
    @Before
    public void setUp() throws Exception {
        section = new ConfigSection(
                "*", IndentStyle.SPACE, 4, EndOfLine.LF, Charset.UTF_8, true, false
        );
    }

    @Test
    public void getWildcard() throws Exception {
        assertEquals("*", this.section.getWildcard());
    }

    @Test
    public void getIndentStyle() throws Exception {
        assertEquals(IndentStyle.SPACE, this.section.getIndentStyle());
    }

    @Test
    public void getIndentSize() throws Exception {
        assertEquals(4, this.section.getIndentSize());
    }

    @Test
    public void getEol() throws Exception {
        assertEquals(EndOfLine.LF, this.section.getEol());
    }

    @Test
    public void getCharset() throws Exception {
        assertEquals(Charset.UTF_8, this.section.getCharset());
    }

    @Test
    public void isTrimTrailingWhitespace() throws Exception {
        assertTrue(this.section.isTrimTrailingWhitespace());
    }

    @Test
    public void isInsertFinalNewline() throws Exception {
        assertFalse(this.section.isInsertFinalNewline());
    }

}
