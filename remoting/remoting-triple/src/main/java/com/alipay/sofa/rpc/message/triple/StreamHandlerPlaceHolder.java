package com.alipay.sofa.rpc.message.triple;

import com.alipay.sofa.rpc.transport.StreamHandler;

/**
 * A placeholder for true stream handler.
 * @param <T>
 */
public class StreamHandlerPlaceHolder<T> implements StreamHandler<T> {

    private StreamHandler<T> trueHandler;

    public void setTrueHandler(StreamHandler<T> trueHandler) {
        this.trueHandler = trueHandler;
    }

    @Override
    public void onMessage(T message) {trueHandler.onMessage(message);}

    @Override
    public void onFinish() {trueHandler.onFinish();}

    @Override
    public void onException(Throwable throwable) {trueHandler.onException(throwable);}
}
