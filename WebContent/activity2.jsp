<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
    <meta charset="utf-8">
    <title>Your Name Here - Simple</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Icons -->
    <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css">  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css">
    <!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
    <!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->


    <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
<!--     <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css"> -->
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">
    <link href="styles/custom.css" rel="stylesheet" type="text/css">
   
   
    <style type="text/css" media="screen">
    /*Tooltip and Pointer CSS*/
    .ui-tooltip { position:absolute; z-index:9999; font-size:11pt; font-family:Calibri;  text-align:left }
    body .ui-tooltip { border-width:2px; }

    .ui-button { display: inline-block; position: relative; padding: 0; margin: 0; margin-right: .3em; text-decoration: none !important; cursor: pointer; text-align: center; zoom: 1; overflow: visible; }
    /*button text element */
    .ui-button .ui-button-text { display: block; line-height: 0.4;  }
    .ui-button-text-only .ui-button-text { padding: .3em .45em; }
    .limit { background: #F4CAD6; } 

    a:link,a:visited
    {
		color:#03c;
		text-decoration: none
    }

    a:hover 
    {
		color:#339;
		text-decoration:underline;
    }

    .splitline 
    { 
       border-top:1px solid green;
    }
    tr.rowbackgroundcolor .datecell
    {
        #background-color: #cccccc;
		#background-color: #cccccc;
		border-left:2px solid #999999;
		border-right:2px solid #FFFFFF;
    }
    tr:not(.rowbackgroundcolor)     .datecell
    {
        #background-color: #cccccc;
		#background-color: #cccccc;
		border-left:2px solid #FFFFFF;
		border-right:2px solid #999999;
    }
    
    .rowbackgroundcolor-select
    {
        background-color: #FFE178;
    }
    .select
    {
        background-color: #FFE178;
    }
    .gridview
    {
        border-color: #999999;
        border-style: solid;
        border-width: 1px;
        border-collapse: collapse;
        border-left-style: none;
        border-top-style: none;
    }
    #monthtag
    {
	position:absolute;
	background-color:lightgreen;
	color:MidnightBlue;
	
	top:-8px;
	left:16px;
	border-top: solid 1px #ccc;
	border-left: solid 1px #ccc;
	border-right: solid 1px #666;
	border-bottom: solid 1px #666;
	
	font-size:11px;
	font-weight:bold;
	line-height:14px;
    
	border-radius:5px;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	-webkit-text-size-adjust:none;
	width:32px;
	text-align:center;
    }
    
    .newcell
    {
        vertical-align:top;
        border-style:none;
        background-color:White;
        border-top-style:hidden;
        width:35px;
	position:relative;
    }

    .oldactivity
    {
	color:#888;	
    }
    .oldactivity A:link { color:#888;}
    .oldactivity A:visited { color:#888;}
    .oldactivity A:hover { color:#888;}
    .oldactivity A:active { color:#888;}
    


    ul#menubar
    {
        border:1px solid #5F5F5F;
        margin:0px;list-style:none;padding:2px;margin-bottom:10px;
        -moz-border-radius:5px;-webkit-border-radius:5px;border-radius:5px;
        -webkit-box-shadow: #666 0px 2px 3px;     /*陰影for Google Chrome、Safari*/
        -moz-box-shadow: #666 0px 2px 3px;     /*陰影for Firefox*/
        box-shadow: #666 0px 2px 3px;     /*陰影for IE*/
        background: #dedede;
        background-image: -webkit-gradient(linear, 0 0, 0 bottom, from(#FFFFFF), to(#dedede));    /*漸層色for Google Chrome、Safari*/
        background: -moz-linear-gradient(#FFFFFF, #dedede);     /*漸層色for Firefox*/ 
        display:block;float:left;
    }
    ul#menubar ul
    {
        text-align:right;
    }
    
    ul#menubar li.menubar
    {
	    height:30px;line-height:30px; width:240px;
	}
	ul#menubar li
	{
	    display:block;white-space:nowrap;float:left;border-style:none;
	}
	
    
</style>

<script>
  var date =new Date();
//这里的date 是你打开jsp页面的本地时间,和服务器时间是有区别的
</script>

<script>
    function select(obj) 
    {
        if (obj.className=="rowbackgroundcolor-select" || obj.className=="select") 
	{
        	if (obj.className=="rowbackgroundcolor-select")
            		obj.className="rowbackgroundcolor"
        	else
            		obj.className=""
    	} 
    	else
	{
		if (obj.className=="")
	        	obj.className="select"
		else
			obj.className="rowbackgroundcolor-select"
	}
    }
</script>
</head>
<body id="pageBody" style="zoom: 1;">
<div id="decorative2">
    <div class="container">

        <div class="divPanel topArea notop nobottom">
            <div class="row-fluid">
                <div class="span12">

                    <div id="divLogo" class="pull-left">
                        <a href="index.html" id="divSiteTitle">Your Name Here</a><br>
                        <a href="index.html" id="divTagLine">Your Tag Line Here</a>
                    </div>

                    <div id="divMenuRight" class="pull-right">
                    <div class="navbar">
                        <button type="button" class="btn btn-navbar-highlight btn-large btn-primary" data-toggle="collapse" data-target=".nav-collapse" data-original-title="">
                            NAVIGATION <span class="icon-chevron-down icon-white"></span>
                        </button>
                        <div class="nav-collapse collapse">
                            <ul class="nav nav-pills ddmenu">
                                <li class="dropdown"><a href="index.html">Home</a></li>
								<li class="dropdown active"><a href="about.html">About</a></li>
                                <li class="dropdown">
                                    <a href="page.html" class="dropdown-toggle">Page <b class="caret"></b></a>
                                    <ul class="dropdown-menu" style="display: none;">
                            <li><a href="full.html">Full Page</a></li>
                            <li><a href="2-column.html">Two Column</a></li>
                            <li><a href="3-column.html">Three Column</a></li>
							<li><a href="../documentation/index.html">Documentation</a></li>
							<li class="dropdown">
                            <a href="#" class="dropdown-toggle">Dropdown Item &nbsp;»</a>
                            <ul class="dropdown-menu sub-menu" style="display: none;">
                            <li><a href="#">Dropdown Item</a></li>
                            <li><a href="#">Dropdown Item</a></li>
                            <li><a href="#">Dropdown Item</a></li>
                            </ul>
                            </li>
                            </ul>
                                </li>
                                <li class="dropdown"><a href="gallery.html">Gallery</a></li>
                                <li class="dropdown"><a href="contact.php">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

<div id="contentOuterSeparator"></div>
<div class="container">

    <div class="divPanel page-content">

        <div class="breadcrumbs">
                <a href="index.html">Home</a> &nbsp;/&nbsp; <span>活動情報</span>
        </div> 
        
			<table>
			<thead>
			<tr><th></th><th>活動內容</th></tr>
			</thead>
			<tbody>			
			<tr>
				<td><img src="data:image/jpg;base64,${selectByPrimaryKey.picture1}"/></td>
				<td>${selectByPrimaryKey.content}</td>				
			</tr>
			</tbody>
			</table>
        <!--Edit Main Content Area here-->
        <div class="row-fluid">



        <div id="footerInnerSeparator"></div>
    </div>

</div>

<div id="footerOuterSeparator"></div>

<div id="divFooter" class="footerArea">

    <div class="container">

        <div class="divPanel">

            <div class="row-fluid">
                <div class="span3" id="footerArea1">
                
                    <h3>About Company</h3>

                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s.</p>
                    
                    <p> 
                        <a href="#" title="Terms of Use">Terms of Use</a><br>
                        <a href="#" title="Privacy Policy">Privacy Policy</a><br>
                        <a href="#" title="FAQ">FAQ</a><br>
                        <a href="#" title="Sitemap">Sitemap</a>
                    </p>

                </div>
                <div class="span3" id="footerArea2">

                    <h3>Recent Blog Posts</h3> 
                    <p>
                        <a href="#" title="">Lorem Ipsum is simply dummy text</a><br>
                        <span style="text-transform:none;">2 hours ago</span>
                    </p>
                    <p>
                        <a href="#" title="">Duis mollis, est non commodo luctus</a><br>
                        <span style="text-transform:none;">5 hours ago</span>
                    </p>
                    <p>
                        <a href="#" title="">Maecenas sed diam eget risus varius</a><br>
                        <span style="text-transform:none;">19 hours ago</span>
                    </p>
                    <p>
                        <a href="#" title="">VIEW ALL POSTS</a>
                    </p>

                </div>
                <div class="span3" id="footerArea3">

                    <h3>Sample Content</h3> 
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s. 
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s.
                    </p>

                </div>
                <div class="span3" id="footerArea4">

                    <h3>Get in Touch</h3>  
                                                               
                    <ul id="contact-info">
                    <li>                                    
                        <i class="general foundicon-phone icon"></i>
                        <span class="field">Phone:</span>
                        <br>
                        (123) 456 7890 / 456 7891                                                                      
                    </li>
                    <li>
                        <i class="general foundicon-mail icon"></i>
                        <span class="field">Email:</span>
                        <br>
                        <a href="mailto:info@yourdomain.com" title="Email">info@yourdomain.com</a>
                    </li>
                    <li>
                        <i class="general foundicon-home icon" style="margin-bottom:50px"></i>
                        <span class="field">Address:</span>
                        <br>
                        123 Street<br>
                        12345 City, State<br>
                        Country
                    </li>
                    </ul>

                </div>
            </div>

            <br><br>
            <div class="row-fluid">
                <div class="span12">
                    <p class="copyright">
                        Copyright © 2013 Your Company. All Rights Reserved.
                    </p>

                    <p class="social_bookmarks">
                        <a href="#"><i class="social foundicon-facebook"></i>&nbsp;Facebook</a>
			<a href=""><i class="social foundicon-twitter"></i>&nbsp;Twitter</a>
			<a href="#"><i class="social foundicon-pinterest"></i>&nbsp;Pinterest</a>
			<a href="#"><i class="social foundicon-rss"></i>&nbsp;Rss</a>
                    </p>
                </div>
            </div>
            <br>

        </div>

    </div>
    
</div>

<script src="scripts/jquery.min.js" type="text/javascript"></script> 
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>
<script src="scripts/ga.js" type="text/javascript"></script>



<script>
    $(function() {
        $("button").button().click(function( event ) {
                event.preventDefault();
            });
	$("button").tooltip({      track: true    });
    });
</script>



</body></html>