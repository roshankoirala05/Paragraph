	
	/**
    * This program can be used to test the Paragraph class methods.
  	 *
	 * @author Dr.C.
    */
   public class ParagraphTest
   {
      public static void main(String[] args)
      {    
      	Paragraph words = new Paragraph();
			System.out.println("Number of words is " + words.count() + "  ... EXPECTED: 0");
         System.out.println("Total length is    " + words.totalLength() + "  ... EXPECTED: 0");
			
			String [] anthem = {"Oh", "say", "can", "you", "see" }; 	
         words =	new Paragraph(anthem);	
         System.out.println("Number of words is " + words.count() + "  ... EXPECTED: 5");
         System.out.println("Total length is    " + words.totalLength() + " ... EXPECTED: 14");
         System.out.println(words);
                  
         words =	new Paragraph();	
         words.readParagraph("cs.txt");
         System.out.println("\nNumber of words is " +  words.count() + "  ... EXPECTED: 22");
         System.out.println("Total length is    " + words.totalLength() + " ... EXPECTED: 159 \n");
         printNumberScale(80);
         System.out.println(words + "\n");
         printNumberScale(52);
         System.out.println(words.formatLeft(52));
         printNumberScale(52);
         System.out.println(words.formatRight(52));
         words.trim(3);
         System.out.println("\nAfter trimming ... \n");
         System.out.println("Number of words is " + words.count() + "  ... EXPECTED: 17");
         System.out.println("Total length is    " + words.totalLength() + " ... EXPECTED: 141 \n");
         System.out.println(words + "\n");
         
         words =	new Paragraph();	
         words.readParagraph("beatlesbio.txt");
         System.out.println("\nNumber of words is " + words.count() + "  ... EXPECTED: 167");
         System.out.println("Total length is    " + words.totalLength() + "  ... EXPECTED: 827 \n");
         printNumberScale(80);
         System.out.println(words + "\n");
         printNumberScale(52);
         System.out.println(words.formatLeft(52));
         printNumberScale(52);
         System.out.println(words.formatRight(52));
         words.trim(4);
         System.out.println("\nAfter trimming ... \n");
         System.out.println("Number of words is " + words.count() + "  ... EXPECTED: 66");
         System.out.println("Total length is    " + words.totalLength() + " ... EXPECTED: 499 \n");
         System.out.println(words + "\n");
      }
      
  /**
      Displays two lines of output.  The first line contains increasing positive
      integers corresponding to the "tens" magnitude.  The second line contains
      repetitions of the digits up to and including the integer argument.
      @param max the integer limit used for display purposes
  */     
      public static void printNumberScale (int max)
      {
         String temp = "";
         for (int i = 1; i <= max; ++i)
            if (i % 10 == 0)
               temp = temp + (i / 10);
            else
               temp = temp + ' ';
         System.out.println(temp);
         temp = "";
         for (int i = 1; i <= max; ++i)
            temp = temp + (i % 10);
         System.out.println(temp); 
      }     
   }