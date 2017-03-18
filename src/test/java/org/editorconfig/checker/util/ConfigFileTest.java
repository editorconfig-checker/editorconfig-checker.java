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

import org.junit.Test;

import java.io.File;

/**
 * Created by Valentin Brandl on 14.03.17.
 * @author Valentin Brandl
 * @since 0.1
 * @version $Id$
 */
public final class ConfigFileTest {

    @Test
    public void testCtor() throws Exception {
        // we need to load `.editorconfig` explicit and strip the filename
        final String absolutePath = new File(
                this.getClass().getResource(
                        "/org/editorconfig/checker/util/.editorconfig"
                ).toURI()
        ).getAbsolutePath();
        final ConfigFile cf = new ConfigFile(
                absolutePath.substring(0,absolutePath.lastIndexOf(File.separator))
        );
        cf.filteredStreams();
    }

}