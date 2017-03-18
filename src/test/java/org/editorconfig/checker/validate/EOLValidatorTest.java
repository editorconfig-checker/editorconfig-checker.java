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
 * Created by Valentin Brandl on 18.03.17.
 *
 * @author Valentin Brandl
 * @version $Id$
 */
public class EOLValidatorTest {
    private File eolLf, eolCr, eolCrLf, eolMixed;
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

    @Test
    public void validateLf() throws Exception {
        final Validator validator = new EOLValidator(
                this.eolLf, EndOfLine.LF
        );
        assertTrue(validator.validate());
        final Validator falseValidator = new EOLValidator(
                this.eolLf, EndOfLine.CR
        );
        assertFalse(falseValidator.validate());
    }

    @Test
    public void validateCr() throws Exception {
        final Validator validator = new EOLValidator(
                this.eolCr, EndOfLine.CR
        );
        assertTrue(validator.validate());
    }

    @Test
    public void validateCrLf() throws Exception {
        final Validator validator = new EOLValidator(
                this.eolCrLf, EndOfLine.CRLF
        );
        assertTrue(validator.validate());
        final Validator falseValidator = new EOLValidator(
                this.eolCrLf, EndOfLine.LF
        );
        final boolean test = falseValidator.validate();
        System.out.println(test);
        assertFalse(test);
    }

    @Test
    public void validateMixed() throws Exception {
        final Validator validator = new EOLValidator(
                this.eolMixed, EndOfLine.CRLF
        );
        assertFalse(validator.validate());
        final Validator noneValidator = new EOLValidator(
                this.eolMixed, EndOfLine.NONE
        );
        assertTrue(noneValidator.validate());
    }
}