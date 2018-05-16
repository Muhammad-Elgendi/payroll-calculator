/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author muhammad
 */
public class Payroll {
    
    private String employerName;
    private String payFrequency;
    private int payPeriod;
    private String employeeName;
    private float totalPayForPeriod;
    private String taxCode;
    private float totalPayToDate;
    private float totalTaxablePay;
    private float TaxDue;
    private String created_on;

    public float getTotalTaxablePay() {
        return totalTaxablePay;
    }

    public void setTotalTaxablePay(float totalTaxablePay) {
        this.totalTaxablePay = totalTaxablePay;
    }

    public float getTaxDue() {
        return TaxDue;
    }

    public void setTaxDue(float TaxDue) {
        this.TaxDue = TaxDue;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public void setPayPeriod(int payPeriod) {
        this.payPeriod = payPeriod;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public void setTotalPayForPeriod(float totalPayForPeriod) {
        this.totalPayForPeriod = totalPayForPeriod;
    }

    public void setTotalPayToDate(float totalPayToDate) {
        this.totalPayToDate = totalPayToDate;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public int getPayPeriod() {
        return payPeriod;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public float getTotalPayForPeriod() {
        return totalPayForPeriod;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public float getTotalPayToDate() {
        return totalPayToDate;
    }
}