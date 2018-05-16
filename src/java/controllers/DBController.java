package controllers;

import configrations.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payroll;

public class DBController {

    Statement s;

    public double lookup_tableA(String type, int positionInYear, int code) throws ClassNotFoundException, SQLException {
//        try {
            s = DBConnection.getConnection().createStatement();
            if (type.equals("month")) {
                ResultSet resaultset = s.executeQuery("select * from month_" + positionInYear + " where Code =" + code + "");
                resaultset.beforeFirst();
                while (resaultset.next()) {
                    return resaultset.getDouble(2);
                }

            } else if (type.equals("week")) {
                ResultSet resaultset = s.executeQuery("select * from week" + positionInYear + " where Code =" + code + "");
                resaultset.beforeFirst();
                while (resaultset.next()) {
                    return resaultset.getDouble(2);
                }
            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        return 0;
    }

    public double lookup_threshold(Boolean isScotland, String typeOfPayment, int positionInYear) throws ClassNotFoundException, SQLException {
//        try {
            s = DBConnection.getConnection().createStatement();

            if (!isScotland) {

                if (typeOfPayment.equals("month")) {
                    ResultSet resaultset = s.executeQuery("select * from ukratemonthlypaid where month =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(2);
                    }

                } else if (typeOfPayment.equals("week")) {
                    ResultSet resaultset = s.executeQuery("select * from ukrateweeklypaid where week =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(2);
                    }
                }
            } else if (isScotland) {
                if (typeOfPayment.equals("month")) {
                    ResultSet resaultset = s.executeQuery("select * from scottichmonthlypaid where month =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(2);
                    }

                } else if (typeOfPayment.equals("week")) {
                    ResultSet resaultset = s.executeQuery("select * from scottichweeklypaid where week =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(2);
                    }
                }
            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        return 0;
    }

    public double lookup_tableC(Boolean isScotland, String typeOfPayment, int positionInYear, int column) throws ClassNotFoundException, SQLException {
//        try {
            s = DBConnection.getConnection().createStatement();
            
             if (!isScotland) {

                if (typeOfPayment.equals("month")) {
                    ResultSet resaultset = s.executeQuery("select * from cmonthlypaid where month =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(column);
                    }

                } else if (typeOfPayment.equals("week")) {
                    ResultSet resaultset = s.executeQuery("select * from cweeklypaid where week =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(column);
                    }
                }
            } else if (isScotland) {
                if (typeOfPayment.equals("month")) {
                    ResultSet resaultset = s.executeQuery("select * from cscottichmonthlypaid where month =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(column);
                    }

                } else if (typeOfPayment.equals("week")) {
                    ResultSet resaultset = s.executeQuery("select * from cscottichweeklypaid where week =" + positionInYear + "");
                    resaultset.beforeFirst();
                    while (resaultset.next()) {
                        return resaultset.getDouble(column);
                    }
                }
            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        return 0;
    }
    
    
    public void insert_payroll(Payroll payroll) throws ClassNotFoundException, SQLException {
//        try {
            s = DBConnection.getConnection().createStatement();           


            s.executeUpdate("insert into calculations (employerName,payFrequency,payPeriod,employeeName,totalPayForPeriod,taxCode,"
                    + "totalPayToDate,totalTaxablePay,TaxDue,created_on) values ('"
                    + payroll.getEmployerName()+ "','" + payroll.getPayFrequency()+ "'," + payroll.getPayPeriod()+ ",'" + payroll.getEmployeeName()+ "',"
                    + payroll.getTotalPayForPeriod()+ ",'" + payroll.getTaxCode()+ "'," + payroll.getTotalPayToDate()+ 
                    "," + payroll.getTotalTaxablePay()+ "," + payroll.getTaxDue()+ ",'" + payroll.getCreated_on()+ "')");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
    }
    
    public ArrayList<Payroll> getAll_payroll() throws ClassNotFoundException, SQLException {
        ArrayList<Payroll> payrolls = new ArrayList<Payroll>();

//        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from calculations");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                Payroll p = new Payroll();
                p.setEmployerName(resaultset.getString(2));
                p.setPayFrequency(resaultset.getString(3));
                p.setPayPeriod(resaultset.getInt(4));
                p.setEmployeeName(resaultset.getString(5));
                p.setTotalPayForPeriod(resaultset.getFloat(6));
                p.setTaxCode(resaultset.getString(7));
                p.setTotalPayToDate(resaultset.getFloat(8));
                p.setTotalTaxablePay(resaultset.getFloat(9));
                p.setTaxDue(resaultset.getFloat(10));
                p.setCreated_on(resaultset.getString(11));
                payrolls.add(p);
            }
//        } catch (SQLException ex) {
//             ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//             ex.printStackTrace();   
//        }
        return payrolls;
    }



}
