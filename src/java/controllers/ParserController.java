/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Scanner;

public class ParserController {

    String Code;
    int index;
    boolean hasPrefix = true;

    public ParserController(String code) {
        Code = code.toUpperCase();
    }

    public String getPrefixCode() {
        String prefix = "";
        if (new Scanner(Character.toString(Code.charAt(0))).hasNextByte()) {
            hasPrefix = false;
            return prefix;
        }
        for (int i = 0; i < 3 && i < Code.length(); i++) {
            char x = Code.charAt(i);
            Scanner s = new Scanner(x + "");
            if (s.hasNextInt()) {
                if (Code.charAt(i - 1) == 'D') {
                    if (x == '1' || x == '0') {
                        prefix += x;
                    } else {
                        i--;
                    }
                } else {
                    i--;
                }
                index = i;
                return prefix;
            } else {
                prefix += x;

            }
        }
        index = 3;
        return prefix;
    }

    public String getNumber() {
        int i;
        if (hasPrefix) {
            i = index + 1;
        } else {
            i = index;
        }
        String number = "";
        if (index > 2) {
            index = 2;
        }
        for (; i < Code.length() && !new Scanner(Character.toString(Code.charAt(Code.length() - 1))).hasNextByte(); i++) {
            char x = Code.charAt(i);
            Scanner s = new Scanner(x + "");
            if (!s.hasNextInt()) {
                return number;
            } else {
                number += x;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        while (true) {
            ParserController p = new ParserController(new Scanner(System.in).next());
            System.out.println("Tax Code =" + p.Code);
            System.out.println("Prefix Code =" + p.getPrefixCode());
            System.out.println("Number =" + p.getNumber());
        }

    }
}
