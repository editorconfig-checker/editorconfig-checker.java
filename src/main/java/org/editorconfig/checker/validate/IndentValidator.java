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

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Indentation validator
 *
 * <p>Validates if the indentation in a file matches the {@code .editorconfig}
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
final class IndentValidator extends Validator {
    private static final Set<Character> INDENTS = new HashSet<>(
            Arrays.asList(
                    new Character[] {
                            ' ', '\t'
                    }
            )
    );
    private static final Logger LOG = Logger.getLogger(IndentValidator.class.getName());

    private final IndentStyle indent;
    private final int indentSize;

    /**
     * Ctor.
     * @param file the file to validate
     * @param indent the {@link IndentStyle}
     * @param indentSize the amount of indents
     */
    IndentValidator(final File file, final IndentStyle indent, final int indentSize) {
        super(file);
        this.indent = indent;
        this.indentSize = indentSize;
    }

    @Override
    boolean validate() throws IOException {
        if (this.indent == IndentStyle.NONE) {
            return true;
        }
        try(final DataInputStream stream = new DataInputStream(
                new FileInputStream(
                        this.file
                )
        )) {
            boolean result = true;
            int line = 1, r;
            while ((r = stream.read()) != -1) {
                char c = (char) r;
                if (LINE_SEPARATORS.contains(c)) {
                    while ((r = stream.read()) != -1) {
                        c = (char) r;
                        if (!LINE_SEPARATORS.contains(c)) {
                            break;
                        }
                    }
                    line++;
                    if (r == -1) {
                        break;
                    }
                    if (INDENTS.contains(c)) {
                        for (int idx = 0; idx < indentSize; idx++) {
                            if (c != this.indent.getIndent()) {
                                LOG.warning("Wrong indentation in " + this.file.getName() + " in line " + line);
                                result = false;
                            }
                            c = (char) stream.read();
                        }
                    }
                }
            }
            return result;
        }
    }
}
