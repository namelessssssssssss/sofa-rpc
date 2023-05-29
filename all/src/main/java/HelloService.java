import com.alipay.sofa.rpc.transport.StreamHandler;

public interface HelloService {

    void sayHello();


    void sayHello(String msg);



    String sayHelloAndResponse(String message);


    StreamHandler<String> sayHelloBiStream(StreamHandler<String> streamHandler);
}
