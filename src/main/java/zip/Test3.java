package zip;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Test3 {

	public static void main(String[] args) {
		try {
			// Encode a String into bytes
			Base64.Encoder encode = Base64.getEncoder();
			String inputString = "blahblahblahaaaaa";
			byte[] input = inputString.getBytes("UTF-8");
			System.out.println(input.length);
			String str = new String(encode.encode(input));
			System.out.println(str.length());
			Base64.Decoder decode=Base64.getDecoder();
			byte[] output=decode.decode(str);
			System.out.println(output.length);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
