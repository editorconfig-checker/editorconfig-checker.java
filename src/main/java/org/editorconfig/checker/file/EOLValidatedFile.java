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

import org.editorconfig.checker.exception.EOLValidationException;
import org.editorconfig.checker.exception.ValidationException;
import org.editorconfig.checker.util.EndOfLine;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Valentin Brandl on 26.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class EOLValidatedFile extends SourceFile {

    private final SourceFile file;
    private final EndOfLine eol;

    public EOLValidatedFile(final SourceFile file, final EndOfLine eol) {
        this.file = file;
        this.eol = eol;
    }

    @Override
    public void validate() throws ValidationException, IOException {
        this.file.validate();
        try (final DataInputStream stream = new DataInputStream(
                this.getStream()
        )) {
            int line = 1, r;
            while ((r = stream.read()) != -1) {
                char c = (char) r;
                if (LINE_SEPARATORS.contains(c)) {
                    for (final char x :
                            this.eol.getEol().toCharArray()) {
                        if (x != c) {
//                            LOG.warning("Wrong EOL in " + this.file.getName() + " in line " + line);
                            throw new EOLValidationException(this.fileName(), line);
                        }
                        c = (char) stream.read();
                    }
                    line++;
                }
            }
        }
    }

    @Override
    public InputStream getStream() throws IOException {
        return this.file.getStream();
    }

    @Override
    public String fileName() {
        return this.file.fileName();
    }
}
