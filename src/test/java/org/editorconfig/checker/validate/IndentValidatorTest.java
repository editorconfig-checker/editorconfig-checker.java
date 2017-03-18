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

import org.editorconfig.checker.util.IndentStyle;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class IndentValidatorTest {

    private File indent1Tab, indent2Tab, indent4Space, indentMisc;

    /**
     * Sets up resource files
     * @throws Exception if an error occured
     */
    @Before
    public void setUp() throws Exception {
        this.indent1Tab = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/indent_1tab"
                ).toURI()
        );
        this.indent2Tab = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/indent_2tab"
                ).toURI()
        );
        this.indent4Space = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/indent_4space"
                ).toURI()
        );
        this.indentMisc = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/validate/indent_misc"
                ).toURI()
        );
    }

    /**
     * Validate tab indented files
     * @throws Exception
     */
    @Test
    public void validateTab() throws Exception {
        final Validator tabValidator = new IndentValidator(
                indent1Tab, IndentStyle.TAB, 1
        );
        assertTrue(tabValidator.validate());

        final Validator tabValidator2 = new IndentValidator(
                indent2Tab, IndentStyle.TAB, 2
        );
        assertTrue(tabValidator2.validate());

        final Validator falseValidator = new IndentValidator(
                indent1Tab, IndentStyle.TAB, 2
        );
        assertFalse(falseValidator.validate());

        final Validator falseValidator2 = new IndentValidator(
                indent1Tab, IndentStyle.SPACE, 1
        );
        assertFalse(falseValidator2.validate());
    }

    /**
     * Validate space indented files
     * @throws Exception
     */
    @Test
    public void validateSpace() throws Exception {
        final Validator spaceValidator = new IndentValidator(
                indent4Space, IndentStyle.SPACE, 4
        );
        assertTrue(spaceValidator.validate());
    }

    /**
     * Validate misc indented files
     * @throws Exception
     */
    @Test
    public void validateMisc() throws Exception {
        final Validator miscValidator = new IndentValidator(
                indentMisc, IndentStyle.NONE, 5
        );
        assertTrue(miscValidator.validate());

        final Validator miscValidator2 = new IndentValidator(
                indentMisc, IndentStyle.TAB, 1
        );
        assertFalse(miscValidator2.validate());
    }

}