import java.util.Scanner;
class Caeser{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Plain Text");
		String plainText=sc.next();
		System.out.println("Enter key");
		int key = sc.nextInt();
		key = checkKey(key);
		System.out.println(key);
		String cipherText = encryption(plainText,key);
		System.out.println(cipherText);
		String decPlainText = decryption(cipherText,key);
		System.out.println(decPlainText);
	}
	public static String encryption(String plainText ,int key){
		int length = plainText.length();
		String ct ="";
		for(int i = 0;i < length;i++){
			ct += (char)((((plainText.charAt(i) -97) + key)% 26)+97 );
		}
	return ct;
	}
		public static String decryption(String cipherText ,int key){
			int length = cipherText.length();
			String pt ="";
			for(int i = 0;i < length;i++){
				int p =cipherText.charAt(i) -key;
				if(p<97){
					p= p +26;
				}
			pt += (char)p;
			}
			return pt;
		}
		public static int checkKey(int key){
			if(key>=0 && key<26){
				return key;
			}
			else if(key<0 || key>=26){
				return (key%26);
			}
		}
	}
}

