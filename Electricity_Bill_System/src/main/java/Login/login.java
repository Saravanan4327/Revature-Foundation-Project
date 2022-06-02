package Login;

import consumer.consumer;

import java.sql.DriverManager;
import java.util.Scanner;

import static payment.bill.*;
import static payment.payment.*;

public class login extends consumer {
    public void signIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1  you are Admin  \nEnter 2 you are consumer " );
        int n = sc.nextInt();
        // Admin Operations
        if(n == 1){
            String adminUserName,adminPassword;
            System.out.print("Enter Username ");
            adminUserName = sc.next();
            System.out.print("Enter Password ");
            adminPassword = sc.next();
            if(adminUserName.equalsIgnoreCase("admin") && adminPassword.equalsIgnoreCase("founder")){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(url,username,password);
                    System.out.println("*** Hello Boss ***");
                    System.out.println("****  Select Operation  ****\n1.insert 2.Update amount 3.Delete 4.SelectAll 5.skip");
                    int query = sc.nextInt();
                    switch(query)
                    {
                        // inserting consumer & bill details by admin!!!
                        case 1:
                            System.out.println("Enter consumer Details ");
                            insertConsumerRecord();
                            System.out.println("Enter Bill Details ");
                            insertBillRecord();
                            break;
                        // generating bill amount by admin!!!
                        case 2:
                            System.out.println("Enter update to generate amount");
                            String update = sc.next();
                            if(update.equalsIgnoreCase("update")) {
                                amountUpdate();
                                break;
                            }
                        // deleting consumer & bill details by admin!!!
                        case 3:
                            System.out.println("Enter 1.delete consumer details 2.delete bill details");
                            int delete =sc.nextInt();
                            if(delete == 1) {
                                deleteConsumerRecord();
                                break;
                            }
                            if(delete == 2) {
                                deleteBillRecord();
                                break;
                            }
                        // selecting consumer & bill details by admin!!!
                        case 4:
                            System.out.println("Enter 1.consumer details 2.bill details 3.All details");
                            int select =sc.nextInt();
                            if(select == 1) {
                                selectConsumerRecord();
                                break;
                            }
                            if(select == 2){
                                selectBillRecord();
                                break;
                            }
                            if(select==3){
                                selectAllRecord();
                                break;
                            }
                        case 5:
                            skipOperation();
                            break;
                    }
                }
                catch (Exception e){
                    //throw new RuntimeException("Invalid Query");
                    e.printStackTrace();
                }

            }

        }
        //Consumer Operations
        if(n==2){

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Enter Username");
                String consumerUserName = sc.next();
                System.out.println("Hello " +consumerUserName);
                System.out.println("Enter 1.select 2.skip");
                int query = sc.nextInt();
                switch(query)
                {
                    case 1:
                        System.out.println("Enter 1.consumer details 2.bill details ");
                        int select =sc.nextInt();
                        if(select == 1) {
                            selectConsumerRecord();
                            break;
                        }
                        if(select == 2){
                            selectBillRecord();
                            break;
                        }

                    case 2:
                        skipOperation();
                        break;
                }
            }
            catch (Exception e){
                //throw new RuntimeException("Invalid Query");
                e.printStackTrace();
            }



        }

    }
}
