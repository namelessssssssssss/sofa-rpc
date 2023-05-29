import com.alipay.sofa.rpc.transport.StreamHandler;

public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello() {
        System.out.println("Get hello from consumer!");
    }

    @Override
    public void sayHello(String msg) {
        System.out.println("Get "+msg + "from consumer");
    }

    @Override
    public String sayHelloAndResponse(String message) {
        System.out.println("Get hello from consumer and try response...");
        return "Hello too, "+ message;
    }

    @Override
    public StreamHandler<String> sayHelloBiStream(StreamHandler<String> streamHandler) {
        streamHandler.onMessage("Hello 1");
        streamHandler.onMessage("Hello 2");

        return new StreamHandler<String>() {
            @Override
            public void onMessage(String message) {
                System.out.println("stream handler get server reply:"+message);
                streamHandler.onMessage("Server reply for message:"+message);
            }

            @Override
            public void onFinish() {
                System.out.println("server reply stream finish");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("get exception");
                throwable.printStackTrace();
            }
        };
    }
}
