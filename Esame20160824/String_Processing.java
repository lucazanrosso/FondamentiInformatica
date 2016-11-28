import java.util.Scanner;
public class String_Processing
{
	public static String [] a;
	
	public static String ccc(String inputString)
	{
		String caratteriCentrali = "";
		int size = inputString.length();
		if(size%2 == 0)
		{
			// Stringhe di lunghezza PARI -> Estraggo due caratteri centrali
			caratteriCentrali = inputString.substring(size/2-1, size/2+1);
		}
		else
		{
			// Stringhe di lunghezza DISPARI -> Estraggo un solo carattere centrale
			caratteriCentrali =inputString.substring(size/2,size/2+1);
		}
		return caratteriCentrali;
	}
	
	public static String inv_String(String inputString)
	{
		String inversa = "";
    
		for(int i=inputString.length()-1; i>=0; i--)
		{
			inversa = inversa + inputString.charAt(i);
		}
    
		return inversa;
	}
	
	public static boolean testPalindroma(String inputString)
	{
		boolean flag = true;
		int i = 0;
		
		while(flag && i<inputString.length()/2)
		{
			if(inputString.charAt(i) != inputString.charAt(inputString.length()-1-i))
			flag = false;
			i++;
		}
    
		return flag;
	}
	
	public static void ggg()
	{
		for(int i=1;i<(a.length); i++)
		{
			String w=a[i];
			int j=i-1;
			
			while(j>=0 && w.compareTo(a[j])>0)
			{
				a[j+1]=a[j];
				j--;
			}
			
			a[j+1]=w;
		}
	}


	public static void main(String args[])
	{
		
		a=new String[7];
		a[0]="I";
		a[1]="N";
		a[2]="G";
		a[3]="E";
		a[4]="G";
		a[5]="N";
		a[6]="I";
	
		//si ricavi la stringa pal concatenando i singoli elementi del vettore a 
		String pal="";
		pal="I"+"N"+"G"+"E"+"G"+"N"+"I";
		
		//si verifichi che pal è palindroma applicando il metodo testPal
		System.out.println(testPalindroma(pal));
	
		System.out.println(ccc(pal));
	
		System.out.println(inv_String(pal));
		
		ggg();
	
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
}
