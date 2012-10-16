 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.util.StringTokenizer;

 public class ReadCSVFile {

   public static void main(String[] args) {

     try { 
			
       String csvFile = args[0];

       //create BufferedReader to read csv file
       BufferedReader br = new BufferedReader(new FileReader(csvFile));
       String line = "";
       StringTokenizer st = null;

       int lineNumber = 0; 
       int tokenNumber = 0;

       //read comma separated file line by line
       while ((line = br.readLine()) != null) {
         lineNumber++;

         if(lineNumber!=1){
         //use comma as token separator
         st = new StringTokenizer(line, ",");

         while (st.hasMoreTokens()) {
           tokenNumber++;

           //display csv values
           System.out.print(st.nextToken() + "  ");
         }
       }
         System.out.println();

         //reset token number
         tokenNumber = 0;
       }

     } catch (Exception e) {
       System.err.println("CSV file cannot be read : " + e);
     }
   }

 }
