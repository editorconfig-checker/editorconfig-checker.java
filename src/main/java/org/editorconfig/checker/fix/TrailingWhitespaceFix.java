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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Valentin Brandl on 23.06.17.
 *
 * @author Valentin Brandl
 * @version $Id$
 */
public final class TrailingWhitespaceFix implements EditorconfigFix {

    private static final Pattern RTRIM = Pattern.compile("\\s+$");

    private final SourceFile file;

    TrailingWhitespaceFix(final SourceFile file) {
        this.file = file;
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
                out.write(RTRIM.matcher(line).replaceAll(""));
                out.newLine();
            }
        }
        return temp;
    }
}
