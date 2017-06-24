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

package org.editorconfig.checker.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper for ValidationExceptions to build an exception stack when checking a file.
 *
 * @author Valentin Brandl
 * @version $Id$
 */
public final class WrappedValidationException extends Exception {

    private final List<ValidationException> exceptions = new ArrayList<>();

    public WrappedValidationException() {
        super();
    }

    public WrappedValidationException(final ValidationException ve) {
        this.exceptions.add(ve);
    }

    public WrappedValidationException(final WrappedValidationException wve) {
        this.exceptions.addAll(wve.exceptions);
    }

    public boolean addExceptions(final ValidationException... ve) {
        return this.exceptions.addAll(Arrays.asList(ve));
    }

    public boolean addExceptions(final WrappedValidationException wve) {
        return this.exceptions.addAll(wve.exceptions);
    }

    public String getErrorMessage() {
        return this.exceptions.stream().map(e -> e.getMessage()).collect(Collectors.joining("\n"));
    }

    public boolean hasExceptions() {
        return !this.exceptions.isEmpty();
    }
}
