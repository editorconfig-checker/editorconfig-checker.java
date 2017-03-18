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

package org.editorconfig.checker.validate;

import org.editorconfig.checker.util.Charset;
import org.editorconfig.checker.util.ConfigSection;
import org.editorconfig.checker.util.EndOfLine;
import org.editorconfig.checker.util.IndentStyle;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Test case for {@link FileValidator}
 *
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class FileValidatorTest {
    @Test
    public void validate() throws Exception {
        final File noTrailingWsLfNoFinalNlTab = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/no_trailing_ws_lf_no_final_nl_tab"
                ).toURI()
        );
        final File trailingWsCrlfFinalNl4Space = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/trailing_ws_crlf_final_nl_4space"
                ).toURI()
        );

        final ConfigSection section = new ConfigSection(
                "*", IndentStyle.TAB, 1, EndOfLine.LF, Charset.UTF_8, true, false
        );
        assertTrue(
                new FileValidator(
                        noTrailingWsLfNoFinalNlTab, section
                ).validate()
        );

        final ConfigSection falseSection = new ConfigSection(
                "*", IndentStyle.SPACE, 4, EndOfLine.LF, Charset.UTF_8, true, false
        );
        assertFalse(
                new FileValidator(
                        noTrailingWsLfNoFinalNlTab, falseSection
                ).validate()
        );

        final ConfigSection section2 = new ConfigSection(
                "*", IndentStyle.SPACE, 4, EndOfLine.CRLF, Charset.UTF_8, false, true
        );
        assertTrue(
                new FileValidator(
                        trailingWsCrlfFinalNl4Space, section2
                ).validate()
        );
    }

}