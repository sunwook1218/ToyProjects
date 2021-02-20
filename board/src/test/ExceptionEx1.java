package test;

import java.sql.SQLException;

public class ExceptionEx1 {
	
	public void main() {
		A a = new B();
		try {
			a.method();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class B implements A {
	
	@Override
	public void method() {
		
		
	}
	
}

interface A {
	void method() throws SQLException;
}
