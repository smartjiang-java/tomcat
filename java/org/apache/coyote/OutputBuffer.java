/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.coyote;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Output buffer. This class is used internally by the protocol implementation. All writes from higher level code should
 * happen via Response.doWrite().
 *
 * @author Remy Maucherat
 */
public interface OutputBuffer {

    /**
     * Write the given data to the response. The caller owns the chunks.
     *
     * @param chunk data to write
     *
     * @return The number of bytes written which may be less than available in the input chunk
     *
     * @throws IOException an underlying I/O error occurred
     */
    public int doWrite(ByteBuffer chunk) throws IOException;


    /**
     * Bytes written to the underlying socket. This includes the effects of chunking, compression, etc.
     *
     * @return Bytes written for the current request
     */
    public long getBytesWritten();
}
