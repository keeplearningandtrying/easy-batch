/**
 * The MIT License
 *
 *   Copyright (c) 2020, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package org.easybatch.flatfile;

import org.easybatch.core.reader.AbstractFileRecordReader;
import org.easybatch.core.reader.AbstractMultiFileRecordReader;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Reader for multiple flat files in one shot.
 * Files must have the same format.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class MultiFlatFileRecordReader extends AbstractMultiFileRecordReader {

    /**
     * Create a new {@link MultiFlatFileRecordReader}.
     *
     * @param files to read
     * @deprecated This constructor is deprecated since v5.3 and will be removed in v6.
     * It will be replaced with a constructor that accepts a {@code List<java.nio.file.Path>}
     */
    @Deprecated
    public MultiFlatFileRecordReader(final List<File> files) {
        this(files, Charset.defaultCharset());
    }

    /**
     * Create a new {@link MultiFlatFileRecordReader}.
     *
     * @param files to read
     * @param charset of the files
     * @deprecated This constructor is deprecated since v5.3 and will be removed in v6.
     * It will be replaced with a constructor that accepts a {@code List<java.nio.file.Path>}
     */
    @Deprecated
    public MultiFlatFileRecordReader(final List<File> files, final Charset charset) {
        super(files, charset);
    }

    @Override
    protected AbstractFileRecordReader createReader() {
        return new FlatFileRecordReader(currentFile, charset.name());
    }
}
