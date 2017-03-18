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

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Trailing whitespace validator
 *
 * <p>Validates if whitespace characters preceding newline characters are trimmed
 * Created by Valentin Brandl on 18.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
final class TrailingWhitespaceValidator extends Validator {

    /**
     * Ctor.
     * @param file the file to validate
     */
    TrailingWhitespaceValidator(final File file) {
        super(file);
    }

    @Override
    boolean validate() throws IOException {
        try(final Scanner scanner = new Scanner(
                this.file
        )) {
            while(scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                System.out.println(line);
                for (final IndentStyle whitespace :
                        IndentStyle.values()) {
                    if (whitespace == IndentStyle.NONE) {
                        continue;
                    }
                    if (line.endsWith(String.valueOf(
                            whitespace.getIndent()
                    ))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
