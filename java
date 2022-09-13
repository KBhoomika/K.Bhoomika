   
   1)  import java.lang.*;
       import java.io.FileInputStream;
       import java.util.Scanner;
       class q1{

          public static void main(String args[]){

                     int[] number ;
                     int number2= 0;
                     number = new int[1];
                     number[0] = 3;

           try{
                     
                     int number4 = number[0]+number[1];
               }      
                //The catch block has exception handler code

                catch(ArrayIndexOutOfBoundsException excep_obj){
 
                      System.out.println("Array index is out of bound");
               }

          try{
                      int number3 = number[0]/number2;
             }
 
                catch(ArithmeticException excep_obj){

                        System.out.println(excep_obj.toString());
               }

           try{
        
                FileInputStream f1 = new FileInputStream("file123.txt");
                Scanner sc = new Scanner(f1);
         
              }catch(FileNotFoundException ob1){
                     System.out.println(ob1);
                    }
                                   
          
                            System.out.println("The Exceptions are caught,the execution of the program           continues");
}       
}

2)import java.util.Scanner;
import java.lang.*;
import java.io.*;

//creating a class of customized exception by extending exception class
class NegativeNumberNotAllowedException extends Exception{
 String str1;
            NegativeNumberNotAllowedException(String str1){
                  super(str1);
            }
 }

 class NumberNotPrimeException extends Exception{
          NumberNotPrimeException(){
               System.out.println("The number is not a prime");
          }
 }           
class Assignment1_q2{
        public static void check(int num) throws NegativeNumberNotAllowedException{
               if(num<0){
                              throw new NegativeNumberNotAllowedException("Negative Number Not Allowed")
                }
        }
       public static void main(String[] args){
             //Asking for the input 
             System.out.println("Enter the number");
             Scanner sc = new Scanner(System.in);
             int num = sc.nextInt();

             try{
                    check(num);
                     int remainder,flag=0;
                         for(int i=2;i<=num/2;i++){
                                  remainder=num%i;
                                  if(remainder==0)
                                  { 
                                         flag=1;
                                         break;
                                   }
                           }

                     if(flag==1){
                                throw new NumberNotPrimeException();
                     }
                     else {
                          System.out.println("The number is prime");  
                     }

      }catch(NegativeNumberNotAllowedException e){
                              System.out.println(e.getMessage());
             }
        catch(NumberNotPrimeException e){

                             System.out.println(e.toString());
         }
    System.out.println(".............");
    }
 }


3)import java.util.Scanner;
import java.lang.*;
import java.io.*;

class SubStringNotFoundException extends Exception{
           String str1;

            SubStringNotFoundException(String str1){
                  super(str1);
            }
 }

class Assignment1_q3{

 public static void main(String[] args){
             //Asking for the input 
             System.out.println("Enter the String");
 
             Scanner sc = new Scanner(System.in);
             String str1 = sc.nextLine();

             String str2 = "SDMCET";
             str1 = str1.toUpperCase();

             try{
                     if(str1.contains(str2)){
                               System.out.println("The sub String SDMCET is present in the given string");
                     } 

                     else{

                              throw new SubStringNotFoundException("Sub String Not Found Exception");
                     }
              }catch(SubStringNotFoundException e){

                            System.out.println(e.getMessage()); 
                 }    
    }
 }


4)import java.io.FileInputStream;
import java.io.FileOutputStream;
  public class q4{
   public static void main(String[] args){
	FileInputStream fin=null;
	FileOutputStream fout=null;
	try{
	  fin=new FileInputStream("C:/Users/acer/Desktop/java/Alphabets.txt");
	  fout=new FileOutputStream("C:/Users/acer/Desktop/java/Consonants.txt");
	  int ch;
	  while((ch=fin.read())!=-1){
	    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
	         throw new VowelNotAllowedException();
            else 
	         fout.write(ch);
          }
        }catch(Exception e){
	    System.out.println("File not found Exception:"+e);
	 }
        
    }
 }

 class VowelNotAllowedException extends Exception{
	public String toString(){
	   return "Exception:VowelNotAllowedException";
        }
 }



5) import java.util.*;
import java.util.Scanner;
import java.io.*;


public class Assignment_5 {
    
  public static void main(String[] args) {
    try{
    FileWriter w = new FileWriter("Integer.txt"); 
    Scanner sc= new Scanner(System.in);
 
 
    System.out.println("Enter the value of n Integer to write on a file :");
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
        System.out.print("Enter the " + (i + 1) +  "to write :" );
        int input = sc.nextInt();
        w.write(input + "\t");
  }w.close();
  int i=0;
  int arr[] = new int[n];
 File file = new File("Integer.txt");
 Scanner read = new Scanner(file);
 while(read.hasNext()){
  arr[i++] = Integer.valueOf(read.next()); 
 }


 Thread t1= new Thread(){
  
    public void run(){
      Arrays.sort(arr, 0, (arr.length/3));
      for (int j = 0; j < (arr.length/3); j++) {
        System.out.println(arr[j]);
      }
      
    }

 };
 Thread t2= new Thread(){
   
   public void run(){
     Arrays.sort(arr, (arr.length/3), (2*(arr.length/3)));
     for (int j =  (arr.length/3); j < (2*(arr.length/3)); j++) {
       System.out.println(arr[j]);
      }
    }
    
  };
  Thread t3= new Thread(){
    
    public void run(){
      Arrays.sort(arr,  (2*(arr.length/3)),(n-1));
      for (int j = (2*(arr.length/3)); j < n; j++) {
        System.out.println(arr[j]);
      }   
    }
  };
  Thread t4= new Thread(){
    
    public void run(){
      Arrays.sort(arr);
      // Arrays.sort(arr,  0,n);

      StringBuilder s = new StringBuilder();
      try{
      FileWriter write  =new FileWriter("SortedInteger.txt"); 
      System.out.println("t4 is printing");
      for (int j = 0; j < n; j++) {
      
        s.append(String.valueOf(arr[j]) + "\t");
      
      }
      write.write(s.toString());
      write.close();
    }catch (Exception e){
      System.out.println(e);
    }      
    }
    
  };
  t1.start();
  t1.join();
  t2.start();
  t2.join();
  t3.start();
  t3.join();
  t4.start();

 }catch(Exception e){
        System.out.println(e);
    }
  }

}

