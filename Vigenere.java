import java.util.Scanner;
class Vigenere{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Plain Text");
        String plainText=sc.next();
        System.out.println("Enter key");
        String key = sc.next();
        String cipherText = encryption(plainText,key);
        System.out.println(cipherText);
        String decPlainText = decrypt(cipherText,key);
        System.out.println(decPlainText);
    }
     public static String encryption(String plainText ,String key){
     	int length = plainText.length();
     	int keyCount = 0;
        String ct ="";
        for(int i = 0;i < length;i++){
           ct+=(char)((((int)(plainText.charAt(i)-97) + (int)(key.charAt(keyCount)-97)) %26) +97);

			if(keyCount == (key.length()-1))
				keyCount=0;
			else
				keyCount++;
        }
        return ct;
    }
    public static String decrypt(String cipherText ,String key){
    	int length = cipherText.length();
     	int keyCount = 0;
        String pt ="";
        for(int i = 0;i < length;i++){
			if(((int)(cipherText.charAt(i)-97) - (int)(key.charAt(keyCount)-97))<0)
				pt+=(char)((((int)(cipherText.charAt(i)-97) - (int)(key.charAt(keyCount)-97)) +26) + 97);
			else
			pt+=(char)((((int)(cipherText.charAt(i)-97) - (int)(key.charAt(keyCount)-97)) %26) + 97);

			if(keyCount == (key.length()-1))
				keyCount=0;
			else
				keyCount++;
		}			  
		return pt;
            }
}