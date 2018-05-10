package controllers;

import configrations.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBController {

    Statement s;

    public double lookup_tableA(String type, int positionInYear, int code) {
        try {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public double lookup_threshold(Boolean isScotland, String typeOfPayment, int positionInYear) {
        try {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public double lookup_tableC(Boolean isScotland, String typeOfPayment, int positionInYear, int column) {
        try {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
