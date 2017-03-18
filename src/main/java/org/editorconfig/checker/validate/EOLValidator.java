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

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * End of line validator
 *
 * <p>Validates if the EOL markers in a file match the one defined in a {@code .editorconfig}
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class EOLValidator extends Validator {

    private final EndOfLine eol;

    /**
     * Ctor.
     * @param file the file to validate
     * @param eol the end of line marker
     */
    public EOLValidator(final File file, final EndOfLine eol) {
        super(file);
        this.eol = eol;
    }

    @Override
    public boolean validate() throws IOException {
        if (this.eol == EndOfLine.NONE) {
            return true;
        }
        try(final DataInputStream stream = new DataInputStream(
                new FileInputStream(
                        this.file
                )
        )) {
            int r;
            while ((r = stream.read()) != -1) {
                char c = (char) r;
                if (LINE_SEPARATORS.contains(c)) {
                    for (final char x :
                            this.eol.getEol().toCharArray()) {
                        if (x != c) {
                            return false;
                        }
                        c = (char) stream.read();
                    }
                }
            }
        }
        return true;
    }
}
