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

import org.editorconfig.checker.util.ConfigSection;

import java.io.File;
import java.io.IOException;

/**
 * File validator
 *
 * <p>Validates a whole file using a given {@link org.editorconfig.checker.util.ConfigSection}
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class FileValidator extends Validator {

    private final ConfigSection section;

    /**
     * Ctor.
     * @param file the file to validate
     * @param section the configuration to validate against
     */
    public FileValidator(final File file, final ConfigSection section) {
        super(file);
        this.section = section;
    }

    @Override
    boolean validate() throws IOException {
        final boolean indent = new IndentValidator(
                this.file, this.section.getIndentStyle(), this.section.getIndentSize()
        ).validate();

        final boolean eol = new EOLValidator(
                this.file, this.section.getEol()
        ).validate();

        final boolean trailingWs = !this.section.isTrimTrailingWhitespace() ||
                new TrailingWhitespaceValidator(
                        this.file
                ).validate();

        final boolean finalNl = new FinalNewlineValidator(
                this.file, this.section.isInsertFinalNewline(), this.section.getEol()
        ).validate();

        return indent && eol && trailingWs && finalNl;
    }
}
