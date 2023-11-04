package Seats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class staffTableUpdate extends TableAllotment
{
    public void TableStatus()
    {   
        try (FileInputStream fis = new FileInputStream("Seats.txt");ObjectInputStream ois = new ObjectInputStream(fis))
        {
            Seats=(int[][])ois.readObject();
        }
        catch(IOException| ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        int s=2;
        System.out.print("            ");
        for(int i=1;i<=20;i++)
        {
            if(i<10)
            System.out.print("  "+i+"    ");
            else
            System.out.print("  "+i+"   ");
        }
        System.out.println("\n");
        for(int i=0;i<4;i++,s=s+2)
        {
            System.out.print(s+" seater : ");
            for(int j=0;j<20;j++)
            {
                System.out.print("  ["+Seats[i][j]+"]  ");
            }
            System.out.println("\n");
        }
    }// displays the occupancy of Seats
    public void Update(int t,int n,int o)
    {
        try (FileInputStream fis = new FileInputStream("Seats.txt");ObjectInputStream ois = new ObjectInputStream(fis))
        {
            Seats=(int[][])ois.readObject();
        }
        catch(IOException| ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        switch(t)
        {
            case 2:t=0;break;
            case 4:t=1;break;
            case 6:t=2;break;
            case 8:t=3;break;
        }
        Seats[t][n-1]=o;

        try(FileOutputStream fos=new FileOutputStream("Seats.txt");ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(Seats);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void initialization(int n)
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<20;j++)
            {
                Seats[i][j]=n;
            }
        }
        
        try(FileOutputStream fos=new FileOutputStream("Seats.txt");ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(Seats);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }    //  to initialize the seats
}
