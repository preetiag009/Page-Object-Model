package extra;

import java.rmi.AccessException;

import org.testng.annotations.Test;


public class BasicTest {
	
	@Test (priority=4)
	public void test1() {
		System.out.println("This is the basic test.");
		throw new ArithmeticException();
	}
	@Test (priority=3, enabled= true)
	public void test2() {
		System.out.println("This is test2.");
	}
	
	@Test (priority=2)
	public void test3() {
		System.out.println("This is test3.");
	}
	
	@Test (priority=1, enabled= false)
	public void test4() {
		System.out.println("This is test4.");
	}
}
