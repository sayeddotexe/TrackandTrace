    import java.util.Scanner;
    import java.io.*;
    import java.util.*;
    
    public class TrackAndTrace {
       
       public static Scanner input = new Scanner(System.in);
       public static Scanner Stinput = new Scanner(System.in);
       private static Scanner x;
       
       public static boolean overlap(int Start1,int End1,int Start2,int End2) {
      boolean infected = false;
      if (Start1 < End1 && Start2 < End2){ // BEFORE MIDNIGHT TIMES
        if (Start2 <= Start1 && (End2 >= End1 || (End2<=End1 && End2 > Start1) )) {
        infected = true;
        }
        else if(Start2>=Start1 && Start2<End1){
        infected = true;
        }
        }
        else if(Start1>End1 || Start2>End2){
        
        if ((End2<=End1)||(Start2>=Start1)||((Start2<=Start1 && End2>End1)&& (Start2>End2))||(Start2<=Start1 && End2>Start1)){
            infected = true;
        }
        }
        return infected;
        }
        
       
       public static int getOverlaps(int star,int en){
       
       
       int test=0;

       
       
       System.out.println("Enter the number of customers:");
       int Customers = input.nextInt();
       
       int counter = Customers;
       boolean inputed = false;
       
       for (int i = 0;i<Customers;i++) {
       
       System.out.println("Enter the customer's name:");
       String name = Stinput.nextLine();
       
       System.out.println("Enter the arrival time:");
       int start = input.nextInt();
       System.out.println("Enter the departure time:");
       int end = input.nextInt();
       inputed = true;
       
       if (overlap(star,en,start,end) == true) {
       System.out.println(name+" needs a test.");
       test++;
       }else {
        System.out.println(name+" does not need a test.");
        }
       
       
       }
       
    
           
        return test;
       
       
       }
       
       
   
   
        public static void main(String[] args) {
        int length = args.length;
        String file = "None";
        
        int test=0;
        
        
        
        
        System.out.println("Enter the start time:");
        int infstart = input.nextInt();
           
        System.out.println("Enter the end time:");
        int infend = input.nextInt();
        
        if (length==0){
        
        System.out.println("There are "+getOverlaps(infstart,infend)+" tests needed.");
         }else{
         
         for (String arg:args){
        file= arg;
         
         
         try{
         x=new Scanner(new File(file));
         while (x.hasNext()){
         String N = x.next();
         String S = x.next();
         String E = x.next();
         
         if (overlap(infstart,infend,Integer.parseInt(S),Integer.parseInt(E)) == true){
         System.out.println(N+" needs a test.");
         test++;
         }else{
         
         }
         
         }
         
         
         }catch(Exception e){
         System.out.println("WARNING: "+file+" not found.");
         }
         }

         System.out.println("There are "+test+" tests needed.");

         }  

        }    
    }
