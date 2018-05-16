<%-- 
    Document   : ErrorPage
    Created on : May 9, 2018, 10:16:16 PM
    Author     : muhammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Favicon -->
        <link rel="icon" href="resources/images/icon-gross-up.png" type="image/png">        
        <!-- Animate CSS -->
        <link rel="stylesheet" href="resources/css/animate.css" >
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" >
        <!-- Font Awesome CSS -->
        <link rel="stylesheet" href="fontawesome/css/fontawesome-all.min.css">
        <!-- Our CSS -->
        <link rel="stylesheet" href="resources/css/styles.css" >

        <title>Error - Payroll Software</title>     

    </head>
    <body>

        <nav class="navbar navbar-light navbar-expand-lg navbar-fixed-top" style="background-color:#0f5b8a;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Payroll Software</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/Payroll">Home</a></li>
                        <li><a href="#API">Web service API</a></li>
                        <li><a href="/Payroll/show-calculations.jsp">Calculations report</a></li>
                        <li><a href="#testimonial4">About us</a></li>
                        <li><a data-toggle="modal" data-target="#contact" data-original-title>Contact us</a></li>
                    </ul>
                    <!--      <ul class="nav navbar-nav navbar-right">
                           <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                         </ul> -->
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>   
      <div class="container-fluid"> 
            <div class="container alert alert-danger">              
                <h3>We are sorry , but we couldn't handle this !</h3><br>
                <div class="row">
                    <div class="col-sm-12">
                        <p>
                       <strong>Check these cases :</strong>
                       <br>
                       1- Make sure you are enter the required inputs as stated in our site
                       <br>
                       2-There is an error happened while processing your request
                       <br>
                       3-You requested a page that doesn't exist
                       <br>
                        <br>
                        If you think that is a technical error feel free to contact us
                   </p>
                    </div>
                </div>
            </div>
        </div>
   
        <div class="container-fluid" id="API"> 
            <div class="container text-center">
                <h3>Web Service API</h3><br>
                <div class="row">
                    <div class="col-sm-12">
                        <p>We provide payroll services in a reliable web service API.
                                <br>To request the API send A POST/GET request to (oursite/Payroll/calculate.jsp?parameter=value&amp;parameter=value....).<br>The list of parameters that should be present to access the service successfully are listed in the following table.
                        </p>                   
                    </div>
                </div>
            </div>
        </div>

            <div class="container-fluid" id="parameters-table">
            <div class="container">                           
                <div class="row animated bounceInLeft">
                    <div class="col-md-8 col-md-offset-2">                        
                        <div class="well-sm">                         
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Parameter</th>
                                        <th>Meaning</th>
                                        <th>Type</th>                                      
                                    </tr>
                                </thead>
                                <tbody>                                   
                                     <tr>
                                        <td>payFrequency</td>
                                        <td>This parameter indicates the pay frequency that could be "week" or "month"</td>
                                        <td>String</td>                                        
                                    </tr>
                                    <tr>
                                        <td>payPeriod</td>
                                        <td>The position of the period in the year.</td>
                                        <td>intger</td>                                        
                                    </tr>
                                       <tr>
                                        <td>totalPayForPeriod</td>
                                        <td>The pay of the current pey.</td>
                                        <td>intger</td>                                        
                                    </tr>
                                     <tr>
                                        <td>totalPayToDate</td>
                                        <td>This parameter is the sum if all payment that happened in this tax year</td>
                                        <td>intger</td>                                        
                                    </tr>
                                     <tr>
                                        <td>taxCode</td>
                                        <td>This code could be provided from <a href="https://www.gov.uk/new-employee-tax-code/y" target="_blank">employee tax code on gov.uk</a></td>
                                        <td>String</td>                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <p class="text-center">The response is encoded in JSON and include all request parameters in addition to the following parameters.
                        </p>
                         <div class="col-md-12">                        
                        <div class="well-sm">                         
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Parameter</th>
                                        <th>Meaning</th>
                                        <th>Type</th>                                      
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Total Taxable Pay</td>
                                        <td>The amount of pay that is taxable.</td>
                                        <td>String</td>                                        
                                    </tr>
                                       <tr>
                                        <td>Due Tax</td>
                                        <td>The amount of pay that is discounted as taxes.</td>
                                        <td>String</td>                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>  
        </div> 
    </div>

 <div class="modal fade" id="contact" tabindex="-1" role="dialog" aria-labelledby="contactLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="panel-title" id="contactLabel"><span class="glyphicon glyphicon-info-sign"></span> Any questions? Feel free to contact us.</h4>
                    </div>
                    <form action="#" method="post" accept-charset="utf-8">
                    <div class="modal-body" style="padding: 5px;">
                          <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6" style="padding-bottom: 10px;">
                                    <input class="form-control" name="firstname" placeholder="Firstname" type="text" required autofocus />
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6" style="padding-bottom: 10px;">
                                    <input class="form-control" name="lastname" placeholder="Lastname" type="text" required />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12" style="padding-bottom: 10px;">
                                    <input class="form-control" name="email" placeholder="E-mail" type="text" required />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12" style="padding-bottom: 10px;">
                                    <input class="form-control" name="subject" placeholder="Subject" type="text" required />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <textarea style="resize:vertical;" class="form-control" placeholder="Message..." rows="6" name="comment" required></textarea>
                                </div>
                            </div>
                        </div>  
                        <div class="panel-footer" style="margin-bottom:-14px;">
                            <input type="submit" class="btn btn-success" value="Send"/>
                                <!--<span class="glyphicon glyphicon-ok"></span>-->
                            <input type="reset" class="btn btn-danger" value="Clear" />
                                <!--<span class="glyphicon glyphicon-remove"></span>-->
                            <button style="float: right;" type="button" class="btn btn-default btn-close" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

    <!-- About us -->


    
<div id="testimonial4" class="carousel slide testimonial4_indicators testimonial4_control_button thumb_scroll_x swipe_x" data-ride="carousel" data-pause="hover" data-interval="5000" data-duration="2000">
        <div class="testimonial4_header">
            <h4>About Us</h4>
        </div>
        <ol class="carousel-indicators">
            <li data-target="#testimonial4" data-slide-to="0" class="active"></li>
            <li data-target="#testimonial4" data-slide-to="1"></li>
            <li data-target="#testimonial4" data-slide-to="2"></li>
            <li data-target="#testimonial4" data-slide-to="3"></li>
            <li data-target="#testimonial4" data-slide-to="4"></li>
            <li data-target="#testimonial4" data-slide-to="5"></li>
            <li data-target="#testimonial4" data-slide-to="6"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <div class="testimonial4_slide">
                    <img src="resources/images/Writting.jpg" class="img-circle img-responsive" />
                    <h4>Muhammad Elgendi</h4>
                    <p>Computer Science student at Faculty of computer and information systems - Menofiya University.</p>                    
                </div>
            </div>
            <div class="item">
                <div class="testimonial4_slide">
                    <img src="resources/images/Writting.jpg" class="img-circle img-responsive" />
                    <h4>Maged Rashed</h4>
                    <p>Computer Science student at Faculty of computer and information systems - Menofiya University.</p>
                  
                </div>
            </div>
            <div class="item">
                <div class="testimonial4_slide">
                    <img src="resources/images/Writting.jpg" class="img-circle img-responsive" />
                    <h4>Ammar Elshaar</h4>
                      <p>Computer Science student at Faculty of computer and information systems - Menofiya University.</p>
                    
                </div>
            </div>
            <div class="item">
                <div class="testimonial4_slide">
                    <img src="resources/images/Writting.jpg" class="img-circle img-responsive" />
                    <h4>Mohamed Elkholy</h4>
                      <p>Computer Science student at Faculty of computer and information systems - Menofiya University.</p>
                    
                </div>
            </div>
            <div class="item">
                <div class="testimonial4_slide">
                    <img src="resources/images/Writting.jpg" class="img-circle img-responsive" />
                    <h4>Mohamed Hesham</h4>
                      <p>Computer Science student at Faculty of computer and information systems - Menofiya University.</p>
                    
                </div>
            </div>
            <div class="item">
                <div class="testimonial4_slide">
                    <img src="resources/images/Writting.jpg" class="img-circle img-responsive" />
                    <h4>Mohamed Ashraf</h4>
                      <p>Computer Science student at Faculty of computer and information systems - Menofiya University.</p>
                    
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#testimonial4" role="button" data-slide="prev">
            <span class="fa fa-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#testimonial4" role="button" data-slide="next">
            <span class="fa fa-chevron-right"></span>
        </a>
    </div>


    <footer class="container-fluid text-center">
        <p>Made with <i class="fas fa-heart" style="color: #e74c3c;"></i> </p>

    </footer>
    <a id="back-to-top" href="#" class="btn btn-primary btn-lg back-to-top" role="button" title="Click to return on the top page" data-toggle="tooltip" data-placement="right"><span class="glyphicon glyphicon-chevron-up"></span></a>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="resources/js/jquery-3.3.1.slim.min.js"></script>
    <!-- <script src="resources/js/popper.min.js"></script> -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- Our js -->
    <!-- <script src="resources/js/calculator.js"></script> -->
    <script type="text/javascript">
        window.onload = function pageLoaded() {
            window.scrollTo(0, 0);
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
    </script>
</body>
</html>
