package payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class payment extends bill {

    public static void amountUpdate() throws Exception {
        String query1 = "select units from bill";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);

        while (rs.next()) {
            int units = rs.getInt("Units");
            String amount;
            if (units >= 0 && units <= 100) {
                int amount1 = units;
                String update1 = "update bill set Amount=" + "\"" + amount1 + "\"" + "where Units=" + "\"" + units + "\"";
                PreparedStatement p1 = con.prepareStatement(update1);
                p1.executeUpdate();
                String sq1 = "select * from bill";
                Statement st1 = con.createStatement();
                ResultSet rt1 = st1.executeQuery(sq1);
                while (rt1.next()) {
                     amount = rt1.getString("Amount");
                }
            } else if (units >= 101 && units <= 200) {
                int amount2 = units * 10;
                String update2 = "update bill set Amount=" + "\"" + amount2 + "\"" + "where Units=" + "\"" + units + "\"";
                PreparedStatement p2 = con.prepareStatement(update2);
                p2.executeUpdate();
                String sq2 = "select * from bill";
                Statement st2 = con.createStatement();
                ResultSet rt2 = st2.executeQuery(sq2);
                while (rt2.next()) {
                     amount = rt2.getString("Amount");
                }
            } else if (units >= 201 && units <= 300) {
                int amount3 = units * 20;
                String update3 = "update bill set Amount=" + "\"" + amount3 + "\"" + "where Units=" + "\"" + units + "\"";
                PreparedStatement p3 = con.prepareStatement(update3);
                p3.executeUpdate();
                String sq3 = "select * from bill";
                Statement st3 = con.createStatement();
                ResultSet rt3 = st3.executeQuery(sq3);
                while (rt3.next()) {
                     amount = rt3.getString("Amount");
                }
            } else if (units >= 301 && units <= 400) {
                int amount4 = units * 30;
                String update4 = "update bill set Amount=" + "\"" + amount4 + "\"" + "where Units=" + "\"" + units + "\"";
                PreparedStatement p4 = con.prepareStatement(update4);
                p4.executeUpdate();
                String sq4 = "select * from bill";
                Statement st4 = con.createStatement();
                ResultSet rt4 = st4.executeQuery(sq4);
                while (rt4.next()) {
                     amount = rt4.getString("Amount");
                }
            } else {
                int amount5 = units*50;
                String update5 = "update bill set Amount=" + "\"" + amount5 + "\"" + "where Units=" + "\"" + units + "\"";
                PreparedStatement p5 = con.prepareStatement(update5);
                p5.executeUpdate();
                String sq5 = "select * from bill";
                Statement st5 = con.createStatement();
                ResultSet rt5 = st5.executeQuery(sq5);
                while (rt5.next()) {
                     amount = rt5.getString("Amount");
                }
            }

        }
        System.out.println("Updated Successfully");

    }
    public static void selectAllRecord() throws Exception{
        String query2 = "select consumer.Consumer_Id,consumer.Consumer_Name,consumer.Phone_Number,consumer.Address,bill.Bill_Number,bill.Units,bill.Amount,bill.Month,bill.Due_Month from consumer inner join bill On consumer.Consumer_ID=bill.Consumer_Id";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query2);
        System.out.println("*****  Consumer And Their Bill Details  *******");
        while(rs.next()){
            String ConsumerId = rs.getString("Consumer_Id");
            System.out.print(ConsumerId + " | ");
            String ConsumerName = rs.getString("Consumer_Name");
            System.out.print(ConsumerName + " | ");
            String phoneNumber = rs.getString("Phone_Number");
            System.out.print(phoneNumber+ " | ");
            String address = rs.getString("Address");
            System.out.print(address+ " | ");
            String billNumber = rs.getString("Bill_Number");
            System.out.print(billNumber + " | ");
            String units = rs.getString("Units");
            System.out.print(units+ " | ");
            String amount = rs.getString("Amount");
            System.out.print(amount+ " | ");
            String month = rs.getString("Month");
            System.out.print(month+ " | ");
            String dueMonth = rs.getString("Due_Month");
            System.out.print(dueMonth+ " | ");
            System.out.println();
        }

    }
    public  static void skipOperation(){
        System.out.println("*******   Thank You   *******");
    }
}
