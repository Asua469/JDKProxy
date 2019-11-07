import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyExample  implements InvocationHandler{
	//真实对象
	private Object target = null;
	
	/**
	   *建立代理对象和真实对象的代理关系，返回代理对象
	 * @param target 真实对象
	 * @return 代理对象
	 **/
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	/**
	 * 代理方法逻辑
	 * @param proxy 代理对象
	 * @param method 当前调度方法
	 * @param args 当前参数
	 * @return 代理返回结果
	 * @throws Throwable异常
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进入代理逻辑方法");
		System.out.println("在调度真实对象前的服务");
		Object obj = method.invoke(target, args);//相当于调用sayHelloWorld方法
		System.out.println("在调度真实对象后的服务");
		return obj;
		
	}

}
