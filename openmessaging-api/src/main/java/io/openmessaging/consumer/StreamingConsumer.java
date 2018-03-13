/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.openmessaging.consumer;

import io.openmessaging.KeyValue;
import io.openmessaging.OMSBuiltinKeys;
import io.openmessaging.ServiceLifecycle;
import java.util.List;

/**
 * A {@code StreamingConsumer} provides low level APIs to open multiple streams
 * from a specified queue and then retrieve messages from them through @{code MessageIterator}.
 *
 * A {@code Queue} is consists of multiple streams, the {@code Stream} is an abstract concept and
 * can be associated with partition in most messaging systems.
 *
 * @version OMS 1.0
 * @see Stream
 * @since OMS 1.0
 */
public interface StreamingConsumer extends ServiceLifecycle {
    /**
     * Returns the attributes of this {@code StreamingConsumer} instance.
     * Changes to the return {@code KeyValue} are not reflected in physical {@code StreamingConsumer}.
     * <p>
     * There are some standard attributes defined by OMS for {@code StreamingConsumer}:
     * <ul>
     * <li> {@link OMSBuiltinKeys#CONSUMER_ID}, the unique consumer id for a consumer instance.
     * <li> {@link OMSBuiltinKeys#OPERATION_TIMEOUT}, the default timeout period for operations of {@code
     * StreamingConsumer}.
     * </ul>
     *
     * @return the attributes
     */
    KeyValue properties();

    /**
     * Returns all the streams of the related queue.
     *
     * @return the name list of streams
     */
    List<String> streams();

    /**
     * Returns all the attached consumers of the related queue.
     *
     * @return the id list of consumers
     */
    List<String> consumers();

    /**
     * Creates a {@code Stream} instance from a specified stream name.
     *
     * @param streamName a specified stream name
     * @return a {@code Stream} instance
     */
    Stream stream(String streamName);

    /**
     * Creates a {@code Stream} instance from a specified stream name with some preset attributes.
     *
     * @param streamName a specified streamName
     * @return a {@code Stream} instance
     * @see Stream#properties()
     */
    Stream stream(String streamName, KeyValue properties);
}
