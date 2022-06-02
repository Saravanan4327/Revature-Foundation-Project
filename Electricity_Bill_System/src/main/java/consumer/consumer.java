package consumer;

import jdbc_connection.connection;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class consumer extends connection {
    //public static Connection con=null;
    public static Scanner sc = new Scanner(System.in);

    public static void insertConsumerRecord() throws Exception{

        String id;
        String name;
        BigInteger phonenumber;
        String address;

        System.out.println("Enter inputs");
        int userInput = sc.nextInt();
        for (int i=1;i<=userInput; i++){

            System.out.println(sc.nextLine() + "Enter id --> ");
            id = sc.nextLine();
            System.out.println("Enter name --> ");
            name = sc.nextLine();
            System.out.println("Enter phonenumber --> ");
            phonenumber = sc.nextBigInteger();
            System.out.println(sc.nextLine() +"Enter  address --> ");
            address = sc.nextLine();

            String query1 = "insert into consumer values(" + "\"" +id+ "\""+ "," + "\"" +name+  "\""  + "," + "\"" + phonenumber + "\"" + "," + "\"" + address + "\"" + ")";

            Statement pre =  con.createStatement();
            pre.executeUpdate(query1);
        }
        System.out.println("****** Inserted successfully  *******");

    }

    public static void selectConsumerRecord() throws Exception{
        System.out.println("Enter consumer Id  -->");
        String cId = sc.next();
        String query2 = "select * from consumer where consumer_Id="+"\""+cId+"\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query2);
        System.out.println("******  Consumer Details  ****");
        while(rs.next()) {
            String ConsumerId = rs.getString("Consumer_Id");
            System.out.print(ConsumerId + " | ");
            String ConsumerName = rs.getString("Consumer_Name");
            System.out.print(ConsumerName + " | ");
            String phoneNumber = rs.getString("Phone_Number");
            System.out.print(phoneNumber+ " | ");
            String address = rs.getString("Address");
            System.out.print(address+ " | ");
            System.out.println();
        }


    }
    public static  void deleteConsumerRecord() throws Exception{
        String query3 = "Delete from consumer";
        Statement pre =  con.createStatement();
        pre.executeUpdate(query3);
        System.out.println("****** Deleted successfully  *******");

    }



}
