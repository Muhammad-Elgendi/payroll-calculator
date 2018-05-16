window.onload = function pageLoaded() {
    changePeriod();
};
window.onscroll = function () {
    scrollFunction()
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("back-to-top").style.display = "block";
    } else {
        document.getElementById("back-to-top").style.display = "none";
    }
}
function showCalculateFields() {
    // Get the checkbox
    var checkBox = document.getElementById("CalculateHours/Rate");

    // If the checkbox is checked, display the output text
    if (checkBox.checked == true) {

        document.getElementById("payField").style.display = "none";
        document.getElementById("hour-rate-fields").style.display = "block";
        document.getElementById("b-Hours/No").required = true;
        document.getElementById("b-Rate").required = true;
        document.getElementById("pay").required = false;
   
    }
}

function changePeriod() {
    var select = document.getElementById("Pay-Frequency");
    var disselect = document.getElementById("Pay-Period");
    var selectedValue = select.options[select.selectedIndex].value;
    if (selectedValue == "month") {
        disselect.options.length = 0;
        var year = new Date().getFullYear();
        var myOptions = {
            1: 'Month 01 ( 26-03-' + year + ' to 25-04-' + year + ' )',
            2: 'Month 02 ( 26-04-' + year + ' to 25-05-' + year + ' )',
            3: 'Month 03 ( 26-05-' + year + ' to 25-06-' + year + ' )',
            4: 'Month 04 ( 26-06-' + year + ' to 25-07-' + year + ' )',
            5: 'Month 05 ( 26-07-' + year + ' to 25-08-' + year + ' )',
            6: 'Month 06 ( 26-08-' + year + ' to 25-09-' + year + ' )',
            7: 'Month 07 ( 26-09-' + year + ' to 25-10-' + year + ' )',
            8: 'Month 08 ( 26-10-' + year + ' to 25-11-' + year + ' )',
            9: 'Month 09 ( 26-11-' + year + ' to 25-12-' + year + ' )',
            10: 'Month 10 ( 26-12-' + year + ' to 25-01-' + (year + 1) + ' )',
            11: 'Month 11 ( 26-01-' + (year + 1) + ' to 25-02-' + (year + 1) + ' )',
            12: 'Month 12 ( 26-02-' + (year + 1) + ' to 25-03-' + (year + 1) + ' )'
        };
        for (var index in myOptions) {
            disselect.options[disselect.options.length] = new Option(myOptions[index], index);
        }
    } else if (selectedValue == "week") {
        disselect.options.length = 0;
        var year = new Date().getFullYear();
        var myOptions = {
            1: 'Week 01 ( 06-04-' + year + ' to 12-04-' + year + ' )',
            2: 'Week 02 ( 13-04-' + year + ' to 19-04-' + year + ' )',
            3: 'Week 03 ( 20-04-' + year + ' to 26-04-' + year + ' )',
            4: 'Week 04 ( 27-04-' + year + ' to 03-05-' + year + ' ) ',
            5: 'Week 05 ( 04-05-' + year + ' to 10-05-' + year + ' )',
            6: 'Week 06 ( 11-05-' + year + ' to 17-05-' + year + ' )',
            7: 'Week 07 ( 18-05-' + year + ' to 24-05-' + year + ' )',
            8: 'Week 08 ( 25-05-' + year + ' to 31-05-' + year + ' )',
            9: 'Week 09 ( 01-06-' + year + ' to 07-06-' + year + ' )',
            10: 'Week 10 ( 08-06-' + year + ' to 14-06-' + year + ' )',
            11: 'Week 11 ( 15-06-' + year + ' to 21-06-' + year + ' )',
            12: 'Week 12 ( 22-06-' + year + ' to 28-06-' + year + ' )',
            13: 'Week 13 ( 29-06-' + year + ' to 05-07-' + year + ' )',
            14: 'Week 14 ( 06-07-' + year + ' to 12-07-' + year + ' )',
            15: 'Week 15 ( 13-07-' + year + ' to 19-07-' + year + ' )',
            16: 'Week 16 ( 20-07-' + year + ' to 26-07-' + year + ' )',
            17: 'Week 17 ( 27-07-' + year + ' to 02-08-' + year + ' )',
            18: 'Week 18 ( 03-08-' + year + ' to 09-08-' + year + ' )',
            19: 'Week 19 ( 10-08-' + year + ' to 16-08-' + year + ' )',
            20: 'Week 20 ( 17-08-' + year + ' to 23-08-' + year + ' )',
            21: 'Week 21 ( 24-08-' + year + ' to 30-08-' + year + ' )',
            22: 'Week 22 ( 31-08-' + year + ' to 06-09-' + year + ' )',
            23: 'Week 23 ( 07-09-' + year + ' to 13-09-' + year + ' )',
            24: 'Week 24 ( 14-09-' + year + ' to 20-09-' + year + ' )',
            25: 'Week 25 ( 21-09-' + year + ' to 27-09-' + year + ' )',
            26: 'Week 26 ( 28-09-' + year + ' to 04-10-' + year + ' )',
            27: 'Week 27 ( 05-10-' + year + ' to 11-10-' + year + ' )',
            28: 'Week 28 ( 12-10-' + year + ' to 18-10-' + year + ' )',
            29: 'Week 29 ( 19-10-' + year + ' to 25-10-' + year + ' )',
            30: 'Week 30 ( 26-10-' + year + ' to 01-11-' + year + ' )',
            31: 'Week 31 ( 02-11-' + year + ' to 08-11-' + year + ' )',
            32: 'Week 32 ( 09-11-' + year + ' to 15-11-' + year + ' )',
            33: 'Week 33 ( 16-11-' + year + ' to 22-11-' + year + ' )',
            34: 'Week 34 ( 23-11-' + year + ' to 29-11-' + year + ' )',
            35: 'Week 35 ( 30-11-' + year + ' to 06-12-' + year + ' )',
            36: 'Week 36 ( 07-12-' + year + ' to 13-12-' + year + ' )',
            37: 'Week 37 ( 14-12-' + year + ' to 20-12-' + year + ' )',
            38: 'Week 38 ( 21-12-' + year + ' to 27-12-' + year + ' )',
            39: 'Week 39 ( 28-12-' + year + ' to 03-01-' + (year + 1) + ' )',
            40: 'Week 40 ( 04-01-' + (year + 1) + ' to 10-01-' + (year + 1) + ' )',
            41: 'Week 41 ( 11-01-' + (year + 1) + ' to 17-01-' + (year + 1) + ' )',
            42: 'Week 42 ( 18-01-' + (year + 1) + ' to 24-01-' + (year + 1) + ' )',
            43: 'Week 43 ( 25-01-' + (year + 1) + ' to 31-01-' + (year + 1) + ' )',
            44: 'Week 44 ( 01-02-' + (year + 1) + ' to 07-02-' + (year + 1) + ' )',
            45: 'Week 45 ( 08-02-' + (year + 1) + ' to 14-02-' + (year + 1) + ' )',
            46: 'Week 46 ( 15-02-' + (year + 1) + ' to 21-02-' + (year + 1) + ' )',
            47: 'Week 47 ( 22-02-' + (year + 1) + ' to 28-02-' + (year + 1) + ' )',
            48: 'Week 48 ( 01-03-' + (year + 1) + ' to 07-03-' + (year + 1) + ' )',
            49: 'Week 49 ( 08-03-' + (year + 1) + ' to 14-03-' + (year + 1) + ' )',
            50: 'Week 50 ( 15-03-' + (year + 1) + ' to 21-03-' + (year + 1) + ' )',
            51: 'Week 51 ( 22-03-' + (year + 1) + ' to 28-03-' + (year + 1) + ' )',
            52: 'Week 52 ( 29-03-' + (year + 1) + ' to 04-04-' + (year + 1) + ' )'
        };
        for (var index in myOptions) {
            disselect.options[disselect.options.length] = new Option(myOptions[index], index);
        }
    }
}

function validate() {
    var x,x2,x3,x4,x5,text, flag;
    flag = true;
    text="";

    if (document.getElementById("payField").style.display == "none") {
    	   // Get the value of the input field with id="numb"
        x = document.getElementById("Total-Gross").value;
        x2 = document.getElementById("b-Hours/No").value;
        x3 = document.getElementById("b-Rate").value;
        x4 = document.getElementById("o-Hours/No").value;
        x5 = document.getElementById("o-Rate").value;

        // If x is Not a Number 
        if (isNaN(x)) {
            text += "<br>Please , Enter a vaild number in \"Total Gross To Date\" feild";
            flag = false;
        }
        if (isNaN(x2)) {
            text += "<br>Please , Enter a vaild number in \"Basic Hours/No\" feild";
            flag = false;
        }
        if (isNaN(x3)) {
            text += "<br>Please , Enter a vaild number in \"Basic Rate\" feild";
            flag = false;
        }
        if (x4 !== "" || x5 !== "") {
        	if (isNaN(x4)) {
            text += "<br>Please , Enter a vaild number in \"Overtime Hours/No\" feild";
            flag = false;
        	}
	        if (isNaN(x5)) {
	            text += "<br>Please , Enter a vaild number in \"Overtime Rate\" feild";
	            flag = false;
	        }
        }
    } else {


        // Get the value of the input field with id="numb"
        x = document.getElementById("Total-Gross").value;
        x2 = document.getElementById("pay").value;

        // If x is Not a Number 
        if (isNaN(x)) {
            text += "<br>Please , Enter a vaild number in \"Total Gross To Date\" feild";
            flag = false;
        }
        if (isNaN(x2)) {
            text += "<br>Please , Enter a vaild number in \"Total Pay For Period\" feild";
            flag = false;
        }
    }
    if (flag) {
    	document.getElementById("error-monitor").style.display = "none";
        sendRequest();
    } else {
        document.getElementById("errormsg").innerHTML = text;
        document.getElementById("error-monitor").style.display = "block";
        document.getElementById('error-monitor').scrollIntoView();
    }
}

function submitform() {
//    console.log("I am there");
    var f = document.getElementsByTagName('form')[0];
    if (!f.checkValidity()) {
        document.getElementById('submit_handle').click();
    } else {
        validate();
    }
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function sendRequest() {
    if (document.getElementById("hour-rate-fields").style.display == "block") {
        var pay = (document.getElementById("b-Hours/No").value * document.getElementById("b-Rate").value)
                + (document.getElementById("o-Hours/No").value * document.getElementById("o-Rate").value);
        document.getElementById("hidden-pay").value = pay;


        //Send Request Using AJAX
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (request.status == 200 && request.readyState == 4) {
                // Process the response
               
                var response = JSON.parse(request.responseText);
                document.getElementById("Employer-Place").innerHTML = response["employerName"];
                document.getElementById("empname").innerHTML = response["employeeName"];
                document.getElementById("taxablepay").innerHTML = response["totalTaxablePay"];
                document.getElementById("payetax").innerHTML = response["TaxDue"];
                document.getElementById("netPay").innerHTML = response["totalPayForPeriod"] - response["TaxDue"];
                document.getElementById("taxcode").innerHTML = response["taxCode"];
                document.getElementById("processdate").innerHTML = new Date().toDateString();
                document.getElementById("totalpayment").innerHTML = response["totalPayForPeriod"];
                document.getElementById("totalgrosstd").innerHTML = response["totalPayToDate"];
                document.getElementById("payPeriod-Place").innerHTML = capitalizeFirstLetter(response["payFrequency"]) +" - "+response["payPeriod"];
                document.getElementById("result-table").style.display = "block";
                document.getElementById('result-table').scrollIntoView();
            }
        };
        request.open("POST", "calculator.jsp", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        var data = "employerName=" + document.getElementById("Employer-Name").value + "&" +
                "payFrequency=" + document.getElementById("Pay-Frequency").value + "&" +
                "payPeriod=" + document.getElementById("Pay-Period").value + "&" +
                "employeeName=" + document.getElementById("Employee-Name").value + "&" +
                "totalPayForPeriod=" + document.getElementById("hidden-pay").value + "&" +
                "taxCode=" + document.getElementById("Tax-Code").value + "&" +
                "totalPayToDate=" + document.getElementById("Total-Gross").value;
        request.send(data);
        request.onload = function () {
            console.log(request.responseText);
            var text = request.responseText;
               if(text.indexOf("error") !=-1){
                   // console.log("here u are !");
                   window.location.replace("http://localhost:8080/Payroll/error.jsp");
            }
        }
    } else {
        //Send Request Using AJAX
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (request.status == 200 && request.readyState == 4) {
                // Process the response
               
                var response = JSON.parse(request.responseText);
                document.getElementById("Employer-Place").innerHTML = response["employerName"];
                document.getElementById("empname").innerHTML = response["employeeName"];
                document.getElementById("taxablepay").innerHTML = response["totalTaxablePay"];
                document.getElementById("payetax").innerHTML = response["TaxDue"];
                document.getElementById("netPay").innerHTML = response["totalPayForPeriod"] - response["TaxDue"];
                document.getElementById("taxcode").innerHTML = response["taxCode"];
                document.getElementById("processdate").innerHTML = new Date().toDateString();
                document.getElementById("totalpayment").innerHTML = response["totalPayForPeriod"];
                document.getElementById("totalgrosstd").innerHTML = response["totalPayToDate"];
                document.getElementById("payPeriod-Place").innerHTML = capitalizeFirstLetter(response["payFrequency"]) +" - "+response["payPeriod"];
                document.getElementById("result-table").style.display = "block";
                document.getElementById('result-table').scrollIntoView();
            }
        };
        request.open("POST", "calculator.jsp", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        var data = "employerName=" + document.getElementById("Employer-Name").value + "&" +
                "payFrequency=" + document.getElementById("Pay-Frequency").value + "&" +
                "payPeriod=" + document.getElementById("Pay-Period").value + "&" +
                "employeeName=" + document.getElementById("Employee-Name").value + "&" +
                "totalPayForPeriod=" + document.getElementById("pay").value + "&" +
                "taxCode=" + document.getElementById("Tax-Code").value + "&" +
                "totalPayToDate=" + document.getElementById("Total-Gross").value;
        request.send(data);
        request.onload = function () {
            console.log(request.responseText);
            var text = request.responseText;
               if(text.indexOf("error") !=-1){
                   // console.log("here u are !");
                   window.location.replace("http://localhost:8080/Payroll/error.jsp");
            }
        }
    }
}