package Seats;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OccupanyCheck extends staffTableUpdate
{
    public int occupancyCheck(int TypeOfSeat)
    {
        try (FileInputStream fis = new FileInputStream("Seats.txt");ObjectInputStream ois = new ObjectInputStream(fis))
        {
            Seats=(int[][])ois.readObject();
        }
        catch(IOException| ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        int flag=0;
        int j;
        for(j=0;j<20;j++)
        {
            if(Seats[TypeOfSeat-1][j]==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            Seats[TypeOfSeat-1][j]=1;

            try(FileOutputStream fos=new FileOutputStream("Seats.txt");ObjectOutputStream oos = new ObjectOutputStream(fos))
            {
                oos.writeObject(Seats);
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }

            return j+1; 
        }
        return 0;
    }   /*  TypeOfSeat=1 for 2 seater
            TypeOfSeat=2 for 4 seater
            TypeOfSeat=3 for 6 seater
            TypeOfSeat=4 for 8 seater
            it return the seat number if seat is available otherwise returns 0 */
}
