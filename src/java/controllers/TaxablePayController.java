package controllers;

import controllers.DBController;

public class TaxablePayController {

    /**
     * @Parms type -- payment type
     * @Parms codeNumber -- Adjustment Code
     *
     */
    String prefixCode;
    String type;
    int codeNumber;
    double totalPay;
    double pay;
    DBController dBController;
    boolean isScotland;
    int positionInYear;

    /**/
    /**
     * @param prefixCode like SBR D0 D1 ..
     * @param codeNumber like 431
     * @param type monthly or weekly
     * @param positionInYear week or month number
     * @param pay pay for this period
     * @param totalPayToDate total gross to date
     */
    public TaxablePayController(String prefixCode, int codeNumber, String type, String positionInYear, String pay, String totalPayToDate) {
        this.prefixCode = prefixCode;
        this.codeNumber = codeNumber;
        this.type = type;
        this.positionInYear = Integer.parseInt(positionInYear);
        this.pay = Double.parseDouble(pay);
        totalPay = this.pay + Double.parseDouble(totalPayToDate);
        isScotland = isScotland(prefixCode);
        dBController = new DBController();

    }

    public static boolean isScotland(String prefixCode) {
        return prefixCode.startsWith("S");
    }

    public double getTaxablePay() {
        if (!(isBasicRate() || isScottishBasicRate() || prefixCode.startsWith("D") || prefixCode.startsWith("SD"))) {
            int code = codeNumber;
            //Month amount in the figure 416.67
            //Week amount in the figure  96.16
            //1- step devide the code by 500

            double adjustmentAmount;
            if (code > 500) {
                int devidionProduct = code / 500;
                int devidsionReminder = code % 500;
                double figureAmount;
                if (type.equals("month")) {
                    figureAmount = positionInYear * 416.67;
                } else {
                    figureAmount = positionInYear * 96.16;
                }
                if (devidsionReminder == 0) {
                    //case 2
                    double valueOf500 = dBController.lookup_tableA(type, positionInYear, 500);
                    double value2 = (devidionProduct-1) * figureAmount;
                    adjustmentAmount = value2 + valueOf500;
                } else {
                    //case 1
                    double valueOfReminder = dBController.lookup_tableA(type, positionInYear, devidsionReminder);
                    double value2 = devidionProduct * figureAmount;
                    adjustmentAmount = value2 + valueOfReminder;
                }
            } else {
                adjustmentAmount = dBController.lookup_tableA(type, positionInYear, code);
            }
            double totalTaxablePay = totalPay - adjustmentAmount;
            return Math.floor(totalTaxablePay);
        } else if (isBasicRate() || isScottishBasicRate()) {
            return totalPay;
        }
        return 0;
    }

    public double getTaxDue() {
        double totalTaxablePay = (getTaxablePay() > 0) ? getTaxablePay() : totalPay;
        double col1Threshold = dBController.lookup_threshold(isScotland, type, positionInYear);

        if (totalTaxablePay <= col1Threshold) {
            //Use Table B To get Tax Due
            return totalTaxablePay * .20;
        } else {
            //Use Table C To get Tax Due
            double col1CTable = dBController.lookup_tableC(isScotland, type, positionInYear, 1);
            double col2CTable = dBController.lookup_tableC(isScotland, type, positionInYear, 2);
            if (totalTaxablePay > col1CTable && totalTaxablePay < col2CTable) {
                double col3CTable = dBController.lookup_tableC(isScotland, type, positionInYear, 3);
                double intialTax = (totalTaxablePay - col1CTable) * .40 + col3CTable;
                return (intialTax > 0.50 * pay) ? (0.50 * pay) : intialTax;
            } else if (totalTaxablePay > col2CTable) {
                double col4CTable = dBController.lookup_tableC(isScotland, type, positionInYear, 4);
                double col5CTable = dBController.lookup_tableC(isScotland, type, positionInYear, 5);
                double intialTax = (totalTaxablePay - col4CTable) * .45 + col5CTable;
                return (intialTax > 0.50 * pay) ? (0.50 * pay) : intialTax;
            }
        }
        return 0;
    }

    private boolean isBasicRate() {
        return prefixCode.equals("BR");
    }

    private boolean isScottishBasicRate() {
        return prefixCode.equals("SBR");
    }

    private boolean isHigherRate() {
        return prefixCode.equals("D0");
    }

    private boolean isAdditionalRate() {
        return prefixCode.equals("D1");
    }

    private boolean isScottishHigherRate() {
        return prefixCode.equals("SD0");
    }

    private boolean isScottishAdditionalRate() {
        return prefixCode.equals("SD1");
    }
}