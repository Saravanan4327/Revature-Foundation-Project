package payment;

import consumer.consumer;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.Statement;

public class bill extends consumer {

    public static  void  insertBillRecord() throws Exception{
        BigInteger billNumber;
        String consumerId;
        BigInteger units;
        BigInteger amount;
        String month;
        String dueMonth;
        System.out.println("Enter inputs");
        int billInput = sc.nextInt();
        for(int i=1;i<=billInput;i++)
        {

            System.out.println("Enter billNumber  -->");
            billNumber = sc.nextBigInteger();
            System.out.println(sc.nextLine() + "Enter consumerId  -->");
            consumerId = sc.nextLine();
            System.out.println("Enter Units  -->");
            units = sc.nextBigInteger();
            System.out.println("Enter Amount  -->");
            amount = sc.nextBigInteger();
            System.out.println(sc.nextLine() +"Enter month  -->");
            month = sc.nextLine();
            System.out.println("Enter dueMonth  -->");
            dueMonth = sc.nextLine();
            String query1 = "insert into bill values(" + "\"" +billNumber+ "\"" +"," +"\"" +consumerId+ "\""+ "," + "\"" +units+ "\"" +","+ "\"" +amount+ "\""+ ","+"\"" +month+ "\"" +"," + "\"" +dueMonth+ "\"" +")";
            Statement pre =  con.createStatement();
            pre.executeUpdate(query1);
        }
        System.out.println("******  Inserted successfully  *******");
    }

    public static  void  selectBillRecord() throws Exception{

        System.out.println("Enter consumer Id  -->");
        String cId = sc.next();
        String query2 = "select * from bill where consumer_Id="+"\""+cId+"\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query2);
        System.out.println("******  Bill Details  ****");
        while(rs.next()) {
            String billNumber = rs.getString("Bill_Number");
            System.out.print(billNumber + " | ");
            String units = rs.getString("Units");
            System.out.print(units + " | ");
            String amount = rs.getString("Amount");
            System.out.print(amount + " | ");
            String month = rs.getString("Month");
            System.out.print(month + " | ");
            String dueMonth = rs.getString("Due_Month");
            System.out.print(dueMonth + " | ");
            System.out.println();
        }

    }

    public static  void  deleteBillRecord() throws Exception{
        String query3 = "Delete from bill";
        Statement pre =  con.createStatement();
        pre.executeUpdate(query3);
        System.out.println("****** Deleted successfully  *******");
    }
}



