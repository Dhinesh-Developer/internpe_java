import java.util.Random;
import java.util.*;


public class Guess_java{
    public static void main(String[] args) {
      Scanner input  = new Scanner(System.in);
      int n = (int)(Math.random()*10)+1;
      int nt = 0;
      int z;
      boolean win = false;
      while(!win)
      {
        System.out.println("Guess number 1 to 10");
         z = input.nextInt();
        nt++;
        if (z==n) 
        {
          win=true; 
        }
        else if(z<n)
        {
          System.out.println("Your guess is low");
        }
        else if(z>n)
        {
          System.out.println("Your guess is high");
        }
      }
     
      System.out.println("you are won");
      System.out.println("the number was"+n);
      System.out.println("number of tries"+nt);


    }
}