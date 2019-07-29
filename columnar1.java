import java.util.*;
class columnar1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter Plain Text : ");
		String plainText = s.nextLine();
		System.out.print("Enter key : ");
		String key = s.nextLine();

		String cipherText = encrypt(plainText,key);
           System.out.println("Cipher Text ="+cipherText);

           String decPlainText = decrypt(cipherText,key);
           System.out.println("Plain Text ="+decPlainText);	
	}
	public static String encrypt(String plainText,String key){
		int row = plainText.length()/key.length();
		int column = key.length() ;
		char[][] cipherText = new char[row][column];
		String ct = "";
		int count = 0;
		for(int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
cipherText[i][(int)key.charAt(j) - 49] = plainText.charAt(count++);
			}
		}
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				ct += cipherText[j][i];
			}
		}
		return ct;
	}
	public static String decrypt(String cipherText,String key){
		String pt ="";
		int row = cipherText.length()/key.length();
		for (int i = 0;i < row ; i++) {
			for(int j =0 ; j < key.length() ;j++){
				pt +=cipherText.charAt((((int)key.charAt(j)-49)*row) +i);
			}
		}
		return pt;
	}
}
