package dbconnection;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM Sample Java Programs\\ThreadTest.java";
		
		int last = test.lastIndexOf("\\");
		String fileName = test.substring(last + 1);
		System.out.println("last: " + last);
		System.out.println("Filename : " + fileName);

	}

}
