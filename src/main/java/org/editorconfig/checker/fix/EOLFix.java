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

import org.editorconfig.checker.file.SourceFile;
import org.editorconfig.checker.util.EndOfLine;

import java.io.*;
import java.util.Scanner;

/**
 * Fixes end of line chars
 *
 * @author Valentin Brandl
 * @since 0.1.0
 * @version $Id$
 */
public final class EOLFix implements EditorconfigFix {

    private final SourceFile file;
    private final EndOfLine eol;

    /**
     * Ctor.
     * @param file
     * @param eol
     */
    public EOLFix(final SourceFile file, final EndOfLine eol) {
        this.file = file;
        this.eol = eol;
    }

    @Override
    public File fix() throws IOException {
        final File temp = File.createTempFile(this.file.fileName(), ".tmp");
        temp.deleteOnExit();
        try (final Scanner scanner = new Scanner(this.file.getStream());
             final BufferedWriter out = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream(
                                     temp
                             )
                     )
             )
        ) {
            while(scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                out.write(line);
                out.write(eol.getEol());
            }
        }
        return temp;
    }
}
