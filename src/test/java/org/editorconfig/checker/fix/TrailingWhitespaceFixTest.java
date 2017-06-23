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

package org.editorconfig.checker.fix;

import org.editorconfig.checker.file.TrailingWsValidatedFile;
import org.editorconfig.checker.file.UncheckedFile;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Valentin Brandl on 23.06.17.
 *
 * @author Valentin Brandl
 * @since 0.1.0
 * @version $Id$
 */
public class TrailingWhitespaceFixTest {
    @Test
    public void fix() throws Exception {
        final File fix = new TrailingWhitespaceFix(
                new TrailingWsValidatedFile(
                        new UncheckedFile(
                                new File(
                                        this.getClass().getResource(
                                                "/org/editorconfig/checker/validate/trailing_whitespace"
                                        ).toURI()
                                )
                        )
                )
        ).fix();

        new TrailingWsValidatedFile(
                new UncheckedFile(
                        fix
                )
        ).validate();
    }

    @Test
    public void fix2() throws Exception {
        final File fix = new TrailingWhitespaceFix(
                new TrailingWsValidatedFile(
                        new UncheckedFile(
                                new File(
                                        this.getClass().getResource(
                                                "/org/editorconfig/checker/validate/trailing_whitespace2"
                                        ).toURI()
                                )
                        )
                )
        ).fix();

        new TrailingWsValidatedFile(
                new UncheckedFile(
                        fix
                )
        ).validate();
    }
}