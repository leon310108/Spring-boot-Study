package zip;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Test2 {

	public static void main(String[] args) {

		try {
			
			String encodedText = "AQAAAAAAAADAYQAAAAAAAENvbXByZXNzZWRUaXRsZQB4nO1daVMbPRLWT3Ht9+AjnFWzvEU4NqklIYV5E/iUMsaAdx3ba5sE9sfvbvfT0uicsYEkHjYuymD1pZbU3eqRRuK//8nUH+pefVUDVVPfVE9N1FT11UgN1V/VX1RTrakG/a0RZqi6BL8i7FDdAPunOlNH6hVRbYLmD7WrMrVHNCN1SRxf1Cl9G6lZBD8jKTOqswfMJ6/eXdWiOhtqmz5b9GkRRT2iydR7SJbyF9Um/Axl1m4Kio9UQ0c9EPaIqCbqO5UmpMUu0U3UHXGw5GKqjKTOUJoR1tTTpXIP/bGrrgk7oNpE0jxq1miS98uAfnapfaJDCM/UIcmaAvoO3EIZQpluSNpyjdf0U65hOS3rNyLaWVLDGOPqeEL9OUtoaeAMnT9i9RIr4fZOoW8f+Ik6xriNUMOU7O9Tof0yv0sdlg/RHz2SPkM91wRPyWtpWS79GUkZQ0fT9hRO9Gfv6Uaj4mJYrz71R4e47zA204g+RZGpt+hJlnMAfB+9EvIWUYnc8h4Je40lfIXtmD4q67OxOicreke/D0lKm2BNePk26o6xzHFB39+pDwQT+h3EBqH3cUzdVvtknYf084Hs6BQcQhtjMmr7hHT8Tu24RUsmurUmwhj8KfrpFu3l8hAy53GH/Rn3Vdibe/AGsW4um3FtEw2PhPWGPdTWAZbL19rz1nR7LSyj3yNqv4s1kAx1ScsEvwO8C81IlxH0GpH2LpUPl+hXpqfB7jm9VNyOhtoobYnBl7VlY8HWbMxpT5HG9YVG7w3RdNU/tb3cwfdSXrKuvaRNunaIhvGnaH0PdfLsy3FknbTe0T4zjzaj6BvPASfa9sYE5VhgIvAplfkvcw4xE34Fn9tK8aZiPsanWsyYA2jYIciAeHmufMhje3FLtyAz3bp6qUwfd0ale/hhL59Fxp6//hgd5tfzN4J1CHaLiH9C9vIPHTt8SWI/PfTfPjjsbDJV/yKqDnRhHdJUGUkeYZQMbJ8kj2AJPCZ2fFhGOW0s6wS/h3PlWDr2csb01Gf6e4XYuZt7eozJyAL78KUJ5jwpGY40LqOYLDPcG8L9m76Lp4VeUESVOa3ZhxcMgTsimgFsS0bmNVnFGmlS+0HfJFYtUnNGtjKAVY0xNr9ay8VrZ+rHWbvxnn1ENh6hFJUbnczc0cmfTEweFkIl+t/DS4bQi+fv0C7SNGxVIzwVfNbt8Z8hYmwG7+E4yL10rK17SvlNWGMxXZGMiwVlXOjnrgHmwKHOP9hLzLwqGXeMz/Akc4mMnecXN7J+1m2V+beIKoNPjiG7C988A20b80c3H5UmnvVY1mL0RXJt1HPbNo82w9PaIOpPAzX9YKzZL4V2KLbz4YVbp8v5NNucL2FlmT/XMtOWeJmPRjVsNJyRV1b6u1lpkT1Oda1DXcvLs8/VHP//YaOhJdYXzFHLnwPTq5VmDaCct5Z4EhVueVY1MqT9bfzuaq/q07NOD88Fm3pELIz74V69pe92xcSOXIwT+r9DD7s+7cPYI2Ul2PRhG08CZqVH/LGYYnHP53rb+gmYR2ArXyHy4SFlaoUkRWH4BogbM6+9LlTo/sRTHPeCtZ24jhSV8LtPwf4Y+M/HwicxIY4XLi4jbJ+ednnt/irX3ocJzTt4gPiTS+fDhfYaNj+g+N1BZNl11u/3ECcvQf8KNnsDal61MDJjfiN3hP48ApyfKh+SddS8WqzUMm6/BjeeFekYU/oybKzZjLjcOHQNLTtYtbhBhH1QvJrB3riNva4d7KUZGTGtxJ/Ys+tzYsYiNGa12bQyLNfIAg4SkcZSvNGeXBbbZnl/bMCurW3bfhpj3amfa3aAVVm25k6+8mZ2AeZT2lUnWYvgqGHmwJTHpOgy7H1JKyX6+muDMTaDbNaAV/4ZP8KMc+74VBG+iPdiDu+F1lRWhTmv+UKlEWKpZAuyJmQifzldhvGYADPUnj+DFZq+T2MfF5UOabwuEf0HaMttnqG09cx0Co+MI+hjOHln06xay2p5B1mD9U6xXRNF5lGb3V7f7hl+BNu5yXU51iOU8okN7RMhjz9Xx/O07N5yjXYe8mGZkjX5gSPBhWSYxWVHN+xXF5NB+0NEjZ6era7yfQe2nFh3X9rj+XnNO4SGe6xlFOw9Pu4EfRNqVkSVIeMT/3qr50YeuZC/iEr6nteGZojfJgJv0nhzrN/ORyOmKarb3el5p/vxHjGoRTFonT6bFIla+W7W46S4e0GMe0/f75F58Jrvz/vt7ya5NTMmZRnP85TmAr7yinpz45f6i7sOUSVvcfValq9svRhfaZA9P+fzeF+IoWaukazM6l82BzUL951rwSz4gazhq37zxn2vYxpx7gYZhotJ71s/TYPXS9dgfekabCxdg82la7C1dA22l67BztI1aOZv2i1Th2YFdFh+ZGxWIDY2KxAdm6XxsYV1F1mH2EFu8Ct0elVqo6FOG7/MdxuV8F/Wogo+3MCb59XQowq+zHpUwZ8bePezGnosP/MRPZaf/zT1iY1q6FGNXKga+VCjIjlRoyJ5UaMiuVGjIvlRY06O9BQ9fLi7KuGumofladSGGFK2s9TVGjA+/b58miJD3/Cam5ym8VuexmU4CzfAvsuJt8+2rmtKY/0+lp1ld50txmZYg+x7+xp2JTOFczlknc7fKSjC8nsSss8hZ73OlJytMDvpaWzI9Ua55yhaSV6fxkrYi/YsUpgM9stnFQfYeZG9d3dXsBhv69onq+sm63Ix8q51BztivDfkWm9Dj3QR3tYVrsfG8AzvUYvFmH3dmurn645s52Y2YTu8cmSZnbQbfJc37c1IW4i8/Xfn9ZIpZ1QDrz1OcpwtcynWbTGNmy9O49aL0/j1i9N4PdC4hafdYq0tvkhzS/Fc7W1sjGNRGudGIxuDwzjkRmcLTZ0bDDnTZwst/iPe4Yh3x1MULl/cvjTObx/PTmM9A4UttLiQh3vNf3+rGO/yyjnX28SeW5rG5X2POVROpbkzbJpC5mWxrdQbYSE2zHGen6ek16Iel7G4b6Ss8pZV3lLNvKWFvdeyeG/wxfG+lZ9CXuUwqxxmlcOscphVDlO9HGbjCTnM01ZdzJz2c7OXVe7yu+cuP2dm4pXxrVXO8qI0fvk5y7I1XuUpqzzlqXmKD/FPXLp3ovmwVEZj9s6fvqLiw805M4M3b9bEEkJKyW54jjJnmtwTLHZ9pogiw7jKHY4z+JxPGZ/MKKfmd7PvkDGIhgPtGaGcIiqX37y7HVpImoItpIs6eurcaWFT20cK5/OkaH2aixK5FwVyL5K0YgP9vBa3fS7cUoW3D7jwTMlZKj6rHbc9jfN52gS/dLCNiDOkCG34HCcEBxiRdEbuU7j1x/2axvk883SOKUKdL+bqfBHo7GPtmZeY076JzxqNEXnauQW47YxxYT17OdU3siI+Kf1QUGua0s3cU/gwh0/L8DPoMz3Xhp5dRBW2KX2GOqbgsxPckzLvTXUuMFP2nsY0lnF+JE/BJOIfUyS5QRwTGr8sd9nZOcOWuXSAfvuOdybsfXYpqKk5BbP3AkheZkp8x+tIjXXEfUjORubNpafcRfExj942d2GrfY07M9fwFkRTZ2eMY0vYwjmbNZyKkVnOnDJOSXMzK/EVlsnc5lSblWxPrRuJLveip/qrcP/Lc+4U+V1u2KiX2LnvBcJrsjP+7r8flIIVcYu/mfEqunu2pviuAHPrnDnD3gRmnHNMlZy58ym4HnO6129XHxZSdqqXb2uwJ4O3sWuxhjUyE+3vvZPD59rnUh5rcfNP9n7LNZRZyPRTaLPFdJnXY8dJXy2jYHxZrzHFIdaHBjrKMJ97N6C1LXtHEEtdlOupN+KckozjqKcMlG3uFP45ydv6VskJ9BHBxX5DigxZyxC9xBC+u0PaIf5+pe17Ag+V9/SKbpNdjLKma+Ss/g5tM086NSe6SL7u3+dQy62gCHue3+4i7TOrZIIzt4QX0RiriO96CSnr2o5+XN/NMFe794AM9XdbW0xTj+KMD/Vn+3oyM7BPvzI33ClzF40t19RN/j2MQGP0QZdqOqMPz1rx+dqYIoPfdXTMtllmCM08H+K6+T8BdPTqjo2Vpo+szlIubl09yK/qUf71Kb/r+0g/A8V7BWWnVq81V+hx9UIM99h+ntfu6v8uEEINnViZ/xTvYxhSrLvgbSv9O6MFwqeLy+6139XxKvVfFf4HGP1CBg==";
			Base64.Decoder decoder = Base64.getDecoder();
			
			//解码字符串，返回字节数组
			byte[] output = decoder.decode(encodedText);
			
			System.out.println(new String(output));
			
			//得到字节数组长度 3172
			int output_length = output.length;
			
			ByteArrayOutputStream xmlout = new ByteArrayOutputStream (10000);
			
			//解压
			Inflater decompress = new Inflater();		
			decompress.setInput(output, 32, output_length-32);
			boolean b1 = decompress.needsDictionary();
			boolean b2 = decompress.needsInput();
			int a1 = decompress.getTotalIn();
			int a2 = decompress.getTotalOut();
			do {
				 
		         byte[] result = new byte[1000];	
		         int ab = decompress.getAdler();
		         int resultLength = decompress.inflate(result);		 
		         xmlout.write(result, 0, resultLength);
		 
			} while (!decompress.finished());
		 
			int finalsize = (int)decompress.getBytesWritten();
			
			//得到解压缩后的字符串：<?xml version="1.0" encoding="UTF-16" ?><Adobe_Root><Adobe_Title><Version>20。。。。。</Adobe_Root>
			String finalStr = new String(xmlout.toByteArray(),0,finalsize, "unicode");
						
			//再次执行压缩操作	
			byte[] input = finalStr.getBytes("unicode");
			
			byte[] input_result = new byte[100000];
			Deflater compresser = new Deflater();
			
			//compresser.setInput(input);
			compresser.setInput(input, 0, input.length);
			compresser.finish();
			
			  
			//得到压缩的字符串长度：3140,比未解压缩之前少了32字节
			int compressedDataLength = compresser.deflate(input_result);  
            byte[] contentByte = new byte[compressedDataLength];  
            
            System.arraycopy(input_result, 0, contentByte, 0, compressedDataLength);  
            
            String s2 = new String(contentByte);
            

			//编码
			Base64.Encoder encoder = Base64.getEncoder();
			
			byte[] result2 = encoder.encode(contentByte);
			String a = new String(contentByte);
			System.out.println(a.length());
			
			System.out.println(new String(result2));
			System.out.println(new String(result2));
			
			//new String(xmlout.toByteArray(),0,)
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
