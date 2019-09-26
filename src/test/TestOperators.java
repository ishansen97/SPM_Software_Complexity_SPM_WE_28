package test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestOperators {

	public static void main(String[] args) {
		String line = "if (number == 0 | number == 1)";
		String line1 = "=";
		
		String[] parts = line.split(" ");
		
		for (String s: parts) {
			if (s.equals("=")) {
				System.out.println("Index: " + s.indexOf(s));
			}
		}
	}
}
