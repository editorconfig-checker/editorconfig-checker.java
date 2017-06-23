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

package org.editorconfig.checker.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.ini4j.Ini;
// import org.ini4j.IniPreferences;
import org.ini4j.Profile;

/**
 * Represents a {@code .editorconfig} file
 * Created by Valentin Brandl on 14.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class ConfigFile {

    // private final String projectDir;
    // private final IniPreferences prefs;
    private final Ini ini;

    /**
     * Ctor.
     * @param projectDir Path to project root
     * @throws IOException If an error occurs
     */
    public ConfigFile(final String projectDir) throws IOException {
        // this.projectDir = projectDir;
        this.ini = new Ini(
                new File(
                        projectDir + File.separator + ".editorconfig"
                )
        );
        // this.prefs = new IniPreferences(ini);
    }

    public void filteredStreams() {
        final Iterator<Profile.Section> iterator = this.ini.values().iterator();
        while (iterator.hasNext()) {
            final Profile.Section s = iterator.next();
            System.out.println(s.getName());
            System.out.println(s.get("indent_style"));
        }
        // try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(
        //         Paths.get(this.projectDir), "Test?/sample*.txt")) {
        //     dirStream.forEach(path -> System.out.println(path));
        // }
    }
}
