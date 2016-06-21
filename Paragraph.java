import java.util.Scanner; // Importing all the java utilities
import java.io.*;
import java.util.*;

/**
   The Paragraph class uses an ArrayList to store a collection 
   of String object, and provides different methods to format the 
   paragraph in different Style.
*/

public class Paragraph
{
   List<String> wordList = new ArrayList<String>();           // Instantiation of an ArrayList called wordList
   
   private String completeParagraph;

   
   /**
      This constructor initializes an empty list of words to the list
   */

   public Paragraph()
   {
      completeParagraph="";
   }
   
   /**
      This constructor initializes a list of words with all of the strings
      in the array passed as argument.
      @param arrayOfWords An array of words to to be set in the list
   */

   public Paragraph(String[] arrayOfWords)
   {
      for( int i = 0 ; i<arrayOfWords.length;i++)
      {
         wordList.add(arrayOfWords[i]);
         completeParagraph+= (arrayOfWords[i] +" ");
      }
      
   }

   
   /**
      The readParagraph method adds to the list of all of the 
      words contained in the file with name passed as parameter.
      @param filename The name of the file to be read by scanner
      @return True if the file is opened successfully
      @return False if the file is not opened successfully
   */

   public boolean readParagraph(String filename)  
   {
    
      try
      {
         Scanner reader = new Scanner(new File(filename));
      
         while( reader.hasNext())
         {
            String word = reader.next();
            if(! word.equals("end_of_data"))
               wordList.add(word);
            completeParagraph+= (word+" ");
         }
         
         return true;
      }
      catch (IOException ex)            // This catch block catches the IOException and returns false 
      {
         
         return false;
      }
   }
   
   /**
      The count method counts the total number of words stored in the list
      @return The value of the size of the wordList.
   */

   public int count()
   {
      return wordList.size();
   }
   
   /**
      The totalLength method calculates and returns the total length of the words
      stored in the list
      @retun The value of length field which is the total length of words in the list.
   */

   public int totalLength()
   {
      int length =0;
      for ( int i = 0 ; i<wordList.size(); i++)
      {
         length+= wordList.get(i).length();
      }
      return length;
   }
   
  /*****************************************************************************************************************************/
  // format left method 
  
   public String formatLeft( int maxwidth )
   {
   
      String result="";
      String currentline="";
   
      for( int i = 0; i< wordList.size(); i++)
      {
         if(wordList.get(i).length() <= maxwidth- currentline.length())
         {
            currentline+= wordList.get(i)+" ";
         }
         else
         {
            currentline+="\n";
            result+=currentline;
            currentline=wordList.get(i)+" ";
         }
      
      
      }   
      result+=currentline;
      completeParagraph=result;
      return completeParagraph;
   
   }
   
   public String formatRight(int maxWidth)
   {
      String result="";
      String currentline="";
   
      for( int i = 0; i< wordList.size(); i++)
      {
         if(wordList.get(i).length() <= maxWidth- currentline.length())
         {
            currentline+= wordList.get(i)+" ";
         }
         else
         {
            String spaces="";
            for(int j = 0; j<(maxWidth-(currentline.length()-1)); j++)
            {
               spaces+=" ";
            }
            
            result+=(spaces+currentline+"\n");
            currentline=wordList.get(i)+" ";
         }
      
      
      }   
      String spaces=" ";
      for(int k = 0; k<(maxWidth-currentline.length()); k++)
      {
         spaces+=" ";
      }
            
      result+=(spaces+currentline);
      
      return result;
   
   }
   
   public String toString()
   {
      return formatLeft(80);
   
   }
   
   public void trim(int minLength)
   {
      
      for ( int q = 0 ; q<wordList.size(); q++)
      {
         String temp;
         temp = wordList.get(q);
         if( ((int)(temp.charAt(temp.length()-1)))< 97 || ((int)(temp.charAt(temp.length()-1)))> 122)
         {
         temp = temp.substring(0, (temp.length())-1);
         wordList.set(q, temp);
         } 
         
      }

      for( int p = 0; p<wordList.size(); p++)
      {
         if(wordList.get(p).length()<= minLength)
         {
            wordList.remove(p);
            p--;
         }
      }
         }
}