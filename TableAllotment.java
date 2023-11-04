package Seats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TableAllotment 
{
    public int Seats[][]=new int[4][20];
        /*  In TypeOfSeat 
            The zeroth row shows the status of the 2 seater table tagged from 1 to 20
            The first row shows the status of the 4 seater table tagged from 1 to 20
            The second row shows the status of the 6 seater table tagged from 1 to 20
            The third row shows the status of the 8 seater table tagged from 1 to 20    
            If it is 1 it is occupied
            If it is 0 it is unoccupied */
    
    public void Seatfile()
    {
        try (FileInputStream fis = new FileInputStream("Seats.txt");ObjectInputStream ois = new ObjectInputStream(fis))
        {
            Seats=(int[][])ois.readObject();
        }
        catch(IOException| ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
        try(FileOutputStream fos=new FileOutputStream("Seats.txt");ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(Seats);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
       
    public void checkOut(int TypeOfSeat, int SeatNo)
    {
        System.out.println("Thankyou For Visiting");
        Seats[TypeOfSeat-1][SeatNo-1]=0;
    }
}