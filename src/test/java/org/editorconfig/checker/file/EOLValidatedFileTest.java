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

package org.editorconfig.checker.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import org.editorconfig.checker.exception.EOLValidationException;
import org.editorconfig.checker.util.EndOfLine;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Valentin Brandl on 26.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class EOLValidatedFileTest {
    private File eolLf;
    private File eolCr;
    private File eolCrLf;
    private File eolMixed;

    /**
     * Set up test resources.
     * @throws Exception if an error occurred
     */
    @Before
    public void setUp() throws Exception {
        this.eolLf = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/eol_lf"
                ).toURI()
        );
        this.eolCr = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/eol_cr"
                ).toURI()
        );
        this.eolCrLf = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/eol_crlf"
                ).toURI()
        );
        this.eolMixed = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/eol_mixed"
                ).toURI()
        );
    }

    /**
     * Test LF files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateLf() throws Exception {
        final SourceFile val = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolLf
                ),
                EndOfLine.LF
        );
        val.validate();
        final SourceFile falseValidator = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolLf
                ),
                EndOfLine.CR
        );
        try {
            falseValidator.validate();
        } catch (EOLValidationException eve) {
            return;
        }
        throw new Exception();
    }

    /**
     * Test CR files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateCr() throws Exception {
        final SourceFile validator = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolCr
                ),
                EndOfLine.CR
        );
        validator.validate();
    }

    /**
     * Test CRLF files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateCrLf() throws Exception {
        final SourceFile validator = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolCrLf
                ),
                EndOfLine.CRLF
        );
        validator.validate();
        final SourceFile falseValidator = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolCrLf
                ),
                EndOfLine.LF
        );
        try {
            falseValidator.validate();
        } catch (EOLValidationException eve) {
            return;
        }
        throw new Exception();
    }

    /**
     * Test mixed files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateMixed() throws Exception {
        final SourceFile validator = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolMixed
                ),
                EndOfLine.CRLF
        );
        boolean ex = false;
        try {
            validator.validate();
        } catch (EOLValidationException eve) {
            ex = true;
        }
        assertTrue(ex);
        final SourceFile noneValidator = new EOLValidatedFile(
                new UncheckedFile(
                        this.eolMixed
                ),
                EndOfLine.NONE
        );
        noneValidator.validate();
    }

}
