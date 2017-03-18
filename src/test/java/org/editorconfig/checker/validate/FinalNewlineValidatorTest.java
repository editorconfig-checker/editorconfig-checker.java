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

import org.editorconfig.checker.util.EndOfLine;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Test case for {@link FinalNewlineValidator}
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class FinalNewlineValidatorTest {

    private File finalNewlineLf, finalNewlineCrlf, noFinalNewline;

    /**
     * Set up test resources
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.finalNewlineLf = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/finalnewline_lf"
                ).toURI()
        );
        this.finalNewlineCrlf = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/finalnewline_crlf"
                ).toURI()
        );
        this.noFinalNewline = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/nofinalnewline"
                ).toURI()
        );
    }

    /**
     * Test for files with final newline
     * @throws Exception
     */
    @Test
    public void validateNl() throws Exception {
        final Validator nlLfValidator = new FinalNewlineValidator(
                this.finalNewlineLf, true, EndOfLine.LF
        );
        assertTrue(nlLfValidator.validate());

        final Validator nlCrlfValidator = new FinalNewlineValidator(
                this.finalNewlineCrlf, true, EndOfLine.CRLF
        );
        assertTrue(nlCrlfValidator.validate());

        final Validator nlMiscValidator = new FinalNewlineValidator(
                this.finalNewlineLf, true, EndOfLine.NONE
        );
        assertTrue(nlMiscValidator.validate());

        final Validator falseValidator = new FinalNewlineValidator(
                this.noFinalNewline, true, EndOfLine.NONE
        );
        assertFalse(falseValidator.validate());
    }

    /**
     * Test for files withozt final newline
     * @throws Exception
     */
    @Test
    public void validateNoNL() throws Exception {
        final Validator noNlValidator = new FinalNewlineValidator(
                this.noFinalNewline, false, EndOfLine.CRLF
        );
        assertTrue(noNlValidator.validate());

        final Validator falseValidator = new FinalNewlineValidator(
                this.finalNewlineCrlf, false, EndOfLine.NONE
        );
        assertFalse(falseValidator.validate());
    }
}