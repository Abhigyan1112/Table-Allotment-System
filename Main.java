import Seats.*;
import java.util.*;
public class Main {
    static boolean validInput=false;
    static int seatType;
    static int seatNo=1;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        OccupanyCheck object=new OccupanyCheck();
        object.Seatfile();
        System.out.println("\n\n||  Step into our cozy restaurant, where great food and warm hospitality await your delightful evening  ||");
        System.out.println("\n\n");
        System.out.println("Are you a Customer or staff");
        String S=(sc.next()).toUpperCase();
        if(S.equals("STAFF"))
        {
            System.out.println("\n Here is the current status of all the seats\n");
            object.TableStatus();
            System.out.println("Do you want to initialize all of them at once: Y/N\n");
            if((sc.next().toUpperCase()).equals("Y"))
            {
                System.out.println("Are they all to be set occupied or not: 1/0\n");
                object.initialization(sc.nextInt());
                object.TableStatus();
            }
            System.out.println("Do you wish to change the status of any perticular seat? :: Y/N\n");
            if((sc.next().toUpperCase()).equals("Y"))
            {
                int flag=1;
                do
                {
                    System.out.println("Enter the Type of seat: 2/4/6/8");
                    int t=sc.nextInt();
                    System.out.println("Enter the seat no.");
                    int n=sc.nextInt();
                    System.out.println("Is it occupied or not: 1/0\n");
                    int o=sc.nextInt();
                    object.Update(t, n, o);
                    System.out.println("\n changes have been successfully made\n");
                    System.out.println("Do you want to update any other seat: Y/N\n");
                    if((sc.next().toUpperCase()).equals("Y"));
                    else
                    {
                        flag=0;
                        System.out.println("do you want to look at the status of the seats?: Y/N\n");
                        if((sc.next().toUpperCase()).equals("Y"))
                        {
                            object.TableStatus();
                            System.out.println("\n");
                        }
                    }
                }while(flag==1);
            }
            System.exit(1);
        }
        System.out.println("| Please choose the Type of Seat you want to book for your meal |\n");
        System.out.println("1> A nice 2 seater Table for a couple");
        System.out.println("2> A 4 seater for a small family or group of friends");
        System.out.println("3> A 6 seater for a big family");
        System.out.println("4> An 8 seater for a huge family or a large group\n");
        System.out.println(" Enter the serial no. of the type of seat you want to book");
        while(!validInput)
        { 
            if(sc.hasNextInt())
            {
                seatType=sc.nextInt();
                if(seatType<=4 && seatType>=1) 
                {
                    seatNo=object.occupancyCheck(seatType);
                    if(seatNo==0)
                    {
                    validInput=false;
                    System.out.println("\nSorry for the Inconvenience but there is no seat available of this type");
                    System.out.println("Please enter another seat Type serial no. \n");
                    }
                    else
                    {
                    System.out.println("\n Your seat has been booked");
                    System.out.println("your seat no. is "+seatNo+" of the requested seat Type\n");
                    validInput=true;
                    }
                }
                else
                {
                    System.out.println("\n!Invalid Entry, Please enter a valid serial no.!\n");
                }
            }   
        } 
        sc.close();
    }
}