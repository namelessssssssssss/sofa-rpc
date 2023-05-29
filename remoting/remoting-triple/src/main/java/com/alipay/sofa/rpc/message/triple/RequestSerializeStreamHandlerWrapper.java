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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.rpc.message.triple;

import com.alipay.sofa.rpc.codec.Serializer;
import com.alipay.sofa.rpc.transport.StreamHandler;
import triple.Request;

/**
 *  将 StreamHandler的请求信息序列化并转换为 Request。
 */
public class RequestSerializeStreamHandlerWrapper<T> implements StreamHandler<T> {

    private StreamHandler<Request> nextHandler;

    private Serializer             serializer;

    public RequestSerializeStreamHandlerWrapper(StreamHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void onMessage(T message) {
        serializer.encode(message, null);
        Request request = Request.getDefaultInstance();

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onException(Throwable throwable) {

    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }
}
