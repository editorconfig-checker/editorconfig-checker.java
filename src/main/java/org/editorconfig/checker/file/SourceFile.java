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

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.editorconfig.checker.exception.WrappedValidationException;

/**
 * Created by Valentin Brandl on 26.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public abstract class SourceFile {

    /**
     * Returns an {@link InputStream} for the wrapped file.
     * @return An InputStream to read from the file
     * @throws IOException If an IO operation failed
     */
    public abstract InputStream getStream() throws IOException;

    /**
     * Validates a file.
     * @throws WrappedValidationException If the validation failed
     * @throws IOException If some IO operation failed
     */
    public abstract void validate() throws WrappedValidationException, IOException;

    /**
     * Returns the name of the wrapped file.
     * @return The filename
     */
    public abstract String fileName();

    static final Set<Character> LINE_SEPARATORS = new HashSet<>(
            Arrays.asList(
                new Character[] {
                    '\n', '\r'
                }
            )
    );
}
