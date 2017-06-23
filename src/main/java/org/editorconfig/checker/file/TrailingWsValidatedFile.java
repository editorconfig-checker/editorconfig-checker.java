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

import org.editorconfig.checker.exception.TrailingWsValidationException;
import org.editorconfig.checker.exception.ValidationException;
import org.editorconfig.checker.util.IndentStyle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Valentin Brandl on 26.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class TrailingWsValidatedFile extends SourceFile {

    private final SourceFile file;
    public TrailingWsValidatedFile(final SourceFile file) {
        this.file = file;
    }

    @Override
    public InputStream getStream() throws IOException {
        return this.file.getStream();
    }

    @Override
    public void validate() throws ValidationException, IOException {
        this.file.validate();
        try (final Scanner scanner = new Scanner(
                this.getStream()
        )) {
            int lineNo = 1;
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                for (final IndentStyle whitespace :
                        IndentStyle.values()) {
                    if (whitespace == IndentStyle.NONE) {
                        continue;
                    }
                    if (line.endsWith(
                            String.valueOf(
                                    whitespace.getIndent()
                            )
                    )) {
//                        LOG.warning("Trailing whitespace in " + this.file.getName() + " in line " + lineNo);
                        throw new TrailingWsValidationException(this.fileName(), lineNo);
                    }
                }
                lineNo++;
            }
        }
    }

    @Override
    public String fileName() {
        return this.file.fileName();
    }
}
