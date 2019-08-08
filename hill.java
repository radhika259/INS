import java.util.Scanner;
import java.lang.Math;
class hill{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Plain Text =");
        String plainText=sc.next();
        System.out.print("Enter key =");
        String key = sc.next();
                
       String cipherText = encrypt(plainText,key);
       System.out.println("cipherText = "+cipherText);

       System.out.print("Enter key Inverse =");
         key = sc.next();
        String decPlainText = decrypt(cipherText,key);
        System.out.println("Decrypt PlainText = "+decPlainText);
    
    }

    public static int[][] keyMatrix(String key){        
        int count = 0;
        int n = (int)Math.sqrt(key.length());
        int keyMat[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                keyMat[i][j] = (int)(key.charAt(count))-97;
                count++;
            }               
        }
        System.out.println("Key Matrix =");
        for (int i =0 ;i < n ;i++ ) {
            for (int j =0 ;j < n ;j++ ) {
                System.out.print(keyMat[i][j]+ " ");
            }
            System.out.println("");
        }
        return keyMat;
    }
    public static String encrypt(String plainText ,String key){
        int keyMat[][] = keyMatrix(key);
        String ct = "";
        int n =keyMat.length;
        int[] temp = new int[n];
        int countP =0;
        while(countP<plainText.length()){
            for(int i=0; i<n; i++){
                temp[i] = (int)(plainText.charAt(countP))-97;
                countP++;
            }
            for(int i=0; i<n; i++){
                int tempSum = 0;
                for(int j=0; j<n; j++)
                    tempSum += (keyMat[i][j] * temp[j]);
                tempSum %= 26;
                tempSum += 97;
                ct += (char)tempSum;
            }           
        }
        return ct;
    }    
    public static String decrypt(String cipherText ,String key){	  
        int keyMat[][] = keyMatrix(key);
        String pt = "";
        int n =keyMat.length;
        int countC = 0;
        int[] temp = new int[n];
        while(countC<cipherText.length()){
            for(int i=0; i<n; i++){
                temp[i] = (int)(cipherText.charAt(countC))-97;
                countC++;
            }
            for(int i=0; i<n; i++){
                int tempSum = 0;
                for(int j=0; j<n; j++)
                    tempSum += (keyMat[i][j] * temp[j]);
                tempSum %= 26;
                tempSum += 97;
                pt += (char)tempSum;
            }           
        }	
       return pt; 
    }
}
