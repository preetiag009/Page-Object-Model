package extra;

import org.testng.annotations.Test;

public class BasicTest2 {

	
		@Test (priority=4)
		public void test5() {
			System.out.println("This is the basic test from basic test 2");
			throw new ArithmeticException();
		}
		@Test (priority=3, enabled= true)
		public void test6() {
			System.out.println("This is test2 from basic test 2.");
		}
		
		@Test (priority=2)
		public void test7() {
			System.out.println("This is test3 from basic test 2.");
		}
		
		@Test (priority=1, enabled= false)
		public void test8() {
			System.out.println("This is test4 from basic test 2.");
		}
	
}
