package eg.edu.alexu.csd.datastructure.hangman.cs56;
import java.util.*; //function random
import java.io.*;
public class hangman implements IHangman{
	private static int muxguess;
	private static String[] dic;
	private static char[] fill;
	private static String fill2;
	private static String secword;
	
		public String[] read(String path)
		{
			String[] arrofstrings = new String[1000];
			try
			{
				BufferedReader read = new BufferedReader(new FileReader(path));
			for(int i=0;i<1000;i++)
			{
				arrofstrings[i]=read.readLine();
			}
			read.close();
			}
			catch(IOException k)
			{
				System.out.println("ERROR!!");
				k.printStackTrace();
			}
			return arrofstrings;
		}
		public void setDictionary(String[] words)
		{
			dic = words;
		}
		public String selectRandomSecretWord()
		{
			Random robject = new Random();
			int R =robject.nextInt(1001);
			String temp = dic[R];
			secword = temp; //pick a word from dictionary
			fill = new char[secword.length()]; //show blanks for users by for loop
			for(int i=0;i<secword.length();i++)
			{
				fill[i]='-';
				if(secword.charAt(i)==' ')
				{
					fill[i]=' ';
				}
			}
			return temp; //the secword
			
		}
		public String guess(Character c) throws Exception
		{
			if(c>='A' && c<'z') //A is the least ascii in chars & z is the largest 
			{
				if(secword.contains(Character.toLowerCase(c)+""))//check if the char is exist
				{
					for(int i=0;i<secword.length();i++)//how many times the char is exist
					{
						if(secword.toLowerCase().charAt(i)==Character.toLowerCase(C))
						{
							fill[i]=Character.toLowerCase(c);
						}
					}
				}
				else
				{
					muxguess--;
				}
				fill2 = new String (fill);
				if(fill2.equals(secword))
				{
					System.out.println("YOU WON!");
					return null;
				}
				if(muxguess==0)
				{
					System.out.println("you have lost:'");
					return null;
				}
				    return fill2;
			}
			else
				throw new Exception("invalid character");
					
		}
		public void setMaxWrongGuesses(Integer max)
		{
			muxguess=max;
			if(max==null || max < 1) //if the tester put invalid number
			{
				muxguess=1;
			}
		}
}
