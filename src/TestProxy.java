
public class TestProxy {
	public static void main(String[] args) {
		testJdkProxy();
	}
	
	public static void testJdkProxy() {
		JDKProxyExample jdk = new JDKProxyExample();
		// �󶨹�ϵ����Ϊ���ڽӿ�HelloWorld�£����������������HelloWorld proxy
		HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
		// ע�⣬��ʱHelloWorld�����Ѿ���һ���������������������߼�����invoke��
		proxy.sayHelloWorld();
	}

}
