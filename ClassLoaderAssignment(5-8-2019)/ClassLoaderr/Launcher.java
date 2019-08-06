package ClassLoaderr;

import java.lang.reflect.Method;

public class Launcher {

	public static void main(String[] args) throws Exception {

		CustomClassLoader loader = new CustomClassLoader();

		System.out.println("Loader name::" + loader.getParent().getClass().getName());

		Class<?> c = loader.loadClass("ClassLoaderr.Test");
		System.out.println("Loaded class name : "+c.getName());
		Object ob = c.newInstance();
		Method md = c.getMethod("show");
		md.invoke(ob);
		
		md = null;

		System.gc();
	}
	
}