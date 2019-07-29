import java.util.*;

class playfair{
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Plain Text in even length	:");
		String plainText=s.nextLine();
		System.out.println("\nEnter Key:");
		String key=s.nextLine();

		char[][] matrix=new char[5][5];
		int l=key.length();
		int count=0;
		char[] keychar=new char[l];
	
		int p=0;	
		String flag="";

		for(int i=0;i<l;i++)
		{
			if(key.charAt(i)=='j'){
				keychar[i]='i';
			}
			else{
				keychar[i]=key.charAt(i);
			}
		}
		key=String.valueOf(keychar);
		for (int i=0;i<l;i++ ) {
			if(flag.indexOf(key.charAt(i))==-1)
			{		
				keychar[p]=key.charAt(i);
				p++;
				flag=flag+key.charAt(i);
			}	
		}
		key=String.valueOf(keychar);
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(count<flag.length())
				{
					matrix[i][j]=keychar[count];
					count++;
				}
			}
		}
		System.out.println("\n");
		int i=0;
		int j=0;
		l=flag.length();
		char a='a';
		i=l/5;
		int q=l%5;
		for(p=i;p<5;p++)
		{
			while(q<5)
			{
				if(a=='j'){
					a++;
				}
				if(key.indexOf(a)==-1)
				{
					matrix[p][q]=a;
					q++;
				}
				a++;	
			}
			q=0;
		}
		for (int m =0 ; m < 5  ; m++ ) {
			for (int k = 0 ; k < 5  ; k++ ) {
				System.out.print(matrix[m][k]);
			}
			System.out.println(" ");
		}
		String cipherText = encrypt(matrix,plainText);
        System.out.println("Cipher Text =" + cipherText);
        String decPlainText = decrypt(matrix,cipherText);
        System.out.println("Decrypt Plain Text =" + decPlainText);
	}

	public static String encrypt(char matrix[][], String pt){
        int length = pt.length();
        String ct ="";
        int l,k,m,n;
        l =k = m =n = 0;
        for(int p = 0; p < length ; p = p + 2){
	        for (int i =0 ; i < 5  ; i++ ) {
				for (int j = 0 ; j < 5  ; j++ ) {
					if(pt.charAt(p)==matrix[i][j]){
							l = i;
							k = j;
					}
					if(pt.charAt(p + 1)==matrix[i][j]){
							m = i;
							n = j;
					}
				}
			}
			if(l == m){
				ct = ct+matrix[l][(k+1) % 5]+matrix[l][(n+1) % 5];
			}
			else if(k == n){
				ct = ct+matrix[(l+1)%5][k] + matrix[(m+1) % 5][k];	
			}
			else{
				ct = ct + matrix[l][n] + matrix[m][k];
			}
		}	
        return ct;
    }
    public static String decrypt(char matrix[][], String ct){
    	int length = ct.length();
        String pt ="";
        int l,k,m,n;
        l =k = m =n = 0;
        for(int p = 0; p < length ; p = p + 2){
	        for (int i =0 ; i < 5  ; i++ ) {
				for (int j = 0 ; j < 5  ; j++ ) {
					if(ct.charAt(p)==matrix[i][j]){
							l = i;
							k = j;
					}
					if(ct.charAt(p + 1)==matrix[i][j]){
							m = i;
							n = j;
					}
				}
			}
			if(l == m){
				if(k == 0 )
					k = 5;
				if(n == 0)
					n = 5;
					pt = pt+matrix[l][(k-1)] + matrix[l][(n-1)];

			}
			else if(k == n){
				if(l == 0 )
					l = 5;
				if(m == 0)
					m = 5;
				pt = pt + matrix[(l-1)][k] + matrix[(m-1)][k];	
			}
			else{
				pt = pt + matrix[l][n] + matrix[m][k];
			}
		}	
        return pt;
    }
}