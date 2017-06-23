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
import org.editorconfig.checker.exception.IndentValidationException;
import org.editorconfig.checker.util.IndentStyle;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Valentin Brandl on 26.03.17.
 *
 * @author Valentin Brandl
 * @version $Id$
 */
public class IndentValidatedFileTest {
    private File indent1Tab;
    private File indent2Tab;
    private File indent4Space;
    private File indentMisc;

    /**
     * Sets up resource files.
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
     * Validate tab indented files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateTab() throws Exception {
        final SourceFile tabValidator = new IndentValidatedFile(
                new UncheckedFile(
                        this.indent1Tab
                ),
                IndentStyle.TAB,
                1
        );
        tabValidator.validate();

        final SourceFile tabValidator2 = new IndentValidatedFile(
                new UncheckedFile(
                        this.indent2Tab
                ),
                IndentStyle.TAB,
                2
        );
        tabValidator2.validate();

        final SourceFile falseValidator = new IndentValidatedFile(
                new UncheckedFile(
                        this.indent1Tab
                ),
                IndentStyle.TAB,
                2
        );
        boolean ex = false;
        try {
            falseValidator.validate();
        } catch (IndentValidationException ive) {
            ex = true;
        }
        assertTrue(ex);

        final SourceFile falseValidator2 = new IndentValidatedFile(
                new UncheckedFile(
                        this.indent1Tab
                ),
                IndentStyle.SPACE,
                1
        );
        ex = false;
        try {
            falseValidator2.validate();
        } catch (IndentValidationException ive) {
            ex = true;
        }
        assertTrue(ex);
    }

    /**
     * Validate space indented files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateSpace() throws Exception {
        final SourceFile spaceValidator = new IndentValidatedFile(
                new UncheckedFile(
                        this.indent4Space
                ),
                IndentStyle.SPACE,
                4
        );
        spaceValidator.validate();
    }

    /**
     * Validate misc indented files.
     * @throws Exception If the test fails
     */
    @Test
    public void validateMisc() throws Exception {
        final SourceFile miscValidator = new IndentValidatedFile(
                new UncheckedFile(
                        this.indentMisc
                ),
                IndentStyle.NONE,
                5
        );
        miscValidator.validate();

        final SourceFile miscValidator2 = new IndentValidatedFile(
                new UncheckedFile(
                        this.indentMisc
                ),
                IndentStyle.TAB,
                1
        );
        boolean ex = false;
        try {
            miscValidator2.validate();
        } catch (IndentValidationException ive) {
            ex = true;
        }
        assertTrue(ex);
    }

}
