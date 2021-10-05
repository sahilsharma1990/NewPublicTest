package com.java.basic;

public class StringTest {

	public static void main(String[] args) {
		String[] arr = { "Sapient", "I", "from", "am" };
		// String [] out = { "I", "am","from","Sapient"}

		String[] out = { "frae", "am", "I", "frad" };
		String temp;
		for (int i = 0; i < out.length; i++) {
			for (int j = 0; j < out.length - i - 1; j++) {
				if (out[j].length() > out[j + 1].length()) {
					temp = out[j];
					out[j] = out[j + 1];
					out[j + 1] = temp;
				} else if (out[j].length() == out[j + 1].length()) {	
						
						//out[j].compareTo(out[j+1]);
					
					for (int k = 0; k < out[j].length(); k++) {
						if (out[j].charAt(k) > out[j + 1].charAt(k)) {
							temp = out[j];
							out[j] = out[j + 1];
							out[j + 1] = temp;
						}
						else if (out[j].charAt(k) == out[j + 1].charAt(k)) {
							continue;
						}
						
						
					}
				}

			}

		}
		for (String a : out) {
			System.out.println(a);
		}
		String s="Sahil";
		
	}

}
