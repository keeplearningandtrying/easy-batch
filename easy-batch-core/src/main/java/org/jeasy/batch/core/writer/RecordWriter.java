/*
 * The MIT License
 *
 *   Copyright (c) 2021, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
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
package org.jeasy.batch.core.writer;

import org.jeasy.batch.core.record.Batch;

/**
 * Interface for all record writers.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 * @param <P> type of the record's payload
 */
public interface RecordWriter<P> {

    /**
     * Open the writer.
     *
     * @throws Exception if an error occurs during opening the writer
     */
    default void open() throws Exception {
        // no-op
    }

    /**
     * Write a batch of records to a data sink.
     *
     * @param batch of records to write.
     * @throws Exception if an error occurs during record writing
     */
    void writeRecords(Batch<P> batch) throws Exception;

    /**
     * Close the writer
     *
     * @throws Exception if an error occurs during closing the writer
     */
    default void close() throws Exception {
        // no-op
    }
}
