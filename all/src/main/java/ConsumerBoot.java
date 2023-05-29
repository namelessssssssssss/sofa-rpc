import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.alipay.sofa.rpc.transport.StreamHandler;


public class ConsumerBoot {

    public static void main(String[] args) {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName())
                .setProtocol("tri")
                .setDirectUrl("triple://127.0.0.1:12200") .setTimeout(100000);
        // 生成代理类
        HelloService helloService = consumerConfig.refer();


        while (true) {
            try {
//                helloService.sayHello();
//                helloService.sayHello("greeting!");
//                helloService.sayHelloAndResponse("greeting!");
                final StreamHandler streamHandler  = helloService.sayHelloBiStream(new StreamHandler<String>() {
                    @Override
                    public void onMessage(String message) {
                        System.out.println("get reply from provider:"+message);
                    }
                    @Override
                    public void onFinish() {
                        System.out.println("provider message finish");
                    }
                    @Override
                    public void onException(Throwable throwable) {
                        System.out.println("error：");
                        throwable.printStackTrace();
                    }
                });
                streamHandler.onMessage("Hello from client stream!");

                Thread.sleep(3000);
            } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
        }
    }
}
