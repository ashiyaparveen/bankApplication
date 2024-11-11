package test;
import org.junit.jupiter.api.Test;


import user.Admin;
public class TestAdmin {
	Admin admin= new Admin();
	
	
	@Test
	public void testLogin() {
		String password;
		String username;
		int actualOup = admin.login(username="Ashiya", password="ashi");
		int expectedoutput=-1;
		assertEquals(expectedoutput,actualOup);
	}


	private void assertEquals(int expectedoutput, int actualOup) {
		// TODO Auto-generated method stub
		
	}

}
