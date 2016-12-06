<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<spring:url value="/resources/img" var="img" />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/plugins" var="plugins" />
<spring:url value="/resources/less" var="less" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />

<c:set var="req" value="${pageContext.request}" />

<c:set var="baseURL" value="${req.scheme}://${req.serverName}${req.contextPath}" />

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
<head>
    <title>Eduardo Crestani</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="expires" content = "${expireDate}" />
    <meta http-equiv="content-language" content="pt-br, en-US" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Eduardo Crestani's resume">
    <meta name="author" content="Eduardo Crestani">    
    <link rel="shortcut icon" href="${img}/favicon.ico">  
    <link href='${css}/google-fonts.css' rel='stylesheet' type='text/css'>
    <!-- Global CSS -->
    <link rel="stylesheet" href="${plugins}/bootstrap/css/bootstrap.min.css">   
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="${plugins}/font-awesome/css/font-awesome.css">
    
    <!-- Theme CSS -->  
    <link id="theme-style" rel="stylesheet" href="${css}/styles.css">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head> 

<body>
    <div class="wrapper">
        <div class="sidebar-wrapper">
            <div class="profile-container">
                <img src="${images}/profile.png" alt="" class="img-circle"/>
                <h1 class="name">${cv.cv.name}</h1>
                <h3 class="tagline">${cv.cv.role}</h3>
            </div><!--//profile-container-->
            
            <div class="contact-container container-block">
                <ul class="list-unstyled contact-list">
                
				<c:forEach items="${cv.person.contact}" var="contact">
				    <c:if test="${fn:containsIgnoreCase(contact.type, 'email')}">
						<li class="email"><i class="fa fa-envelope"></i><a href="mailto:${contact.text}">${contact.label}</a></li>
				    </c:if>
				    <c:if test="${fn:containsIgnoreCase(contact.type, 'telefone')}">
				       <li class="phone"><i class="fa fa-phone"></i><a href="tel:${contact.text}">${contact.label}</a></li>
				    </c:if>           
				    <c:if test="${fn:containsIgnoreCase(contact.type, 'github')}">
				         <li class="github"><i class="fa fa-github"></i><a href="${contact.text}" target="_blank">${contact.label}</a></li>
				    </c:if>
				    <c:if test="${fn:containsIgnoreCase(contact.type, 'twitter')}">
				        <li class="twitter"><i class="fa fa-twitter"></i><a href="${contact.text}" target="_blank">${contact.label}</a></li>
				    </c:if>
				        <c:if test="${fn:containsIgnoreCase(contact.type, 'linkedin')}">
				        <li class="linkedin"><i class="fa fa-linkedin"></i><a href="${contact.text}" target="_blank">${contact.label}</a></li>
				    </c:if>
				    
				</c:forEach>
                
                      </ul>
            </div><!--//contact-container-->
            <div class="education-container container-block">
                <h2 class="container-block-title">${cv.cv.educationTitle}</h2>
                
                
               <c:forEach items="${cv.cv.education}" var="education">

                <div class="item">
                    <h4 class="degree">${education.courseName}</h4>
                    <h5 class="meta">${education.institutionName}</h5>
                    <div class="time">${education.fromDateF} - ${education.toDateF}</div>
                </div><!--//item-->
                
                
               </c:forEach>

            </div><!--//education-container-->
            
            <div class="languages-container container-block">
                <h2 class="container-block-title">${cv.cv.languageTitle}</h2>
                <ul class="list-unstyled interests-list">
                
               <c:forEach items="${cv.cv.language}" var="language">
                
                 <li>${language.name} <span class="lang-desc">(${language.languageProficiency})</span></li>
                
               </c:forEach>

                </ul>
            </div><!--//interests-->
            
            <div class="interests-container container-block">
                <h2 class="container-block-title">${cv.cv.interestsTitle}</h2>
                <ul class="list-unstyled interests-list">
                
                 <c:forEach items="${cv.cv.interest}" var="interest">
                                  <li>${interest.name}</li>
                 </c:forEach>
       
                </ul>
            </div><!--//interests-->
            
        </div><!--//sidebar-wrapper-->
        
        <div class="main-wrapper">
        


        <div style="position:relative;right:-80%;margin-top:-1%;width:30%;height:62px;">
        
          <c:if test="${empty param['idiom'] or param['idiom'] != 'ENGLISH'}">
	            <a href="${baseURL}/?idiom=ENGLISH"> <img src="${img}/english-version.png"/></a>
	            <a href="${baseURL}/?idiom=ENGLISH">english version</a>
          </c:if>
          
          <c:if test="${param['idiom']=='ENGLISH'}">
	            <a href="${baseURL}/?idiom=PORTUGUES"> <img src="${img}/portuguese-version.png"/></a> 
	            <a href="${baseURL}/?idiom=PORTUGUES">portuguese version</a>
          </c:if>
          
        </div>

            
            <section class="section summary-section">
                <h2 class="section-title"><i class="fa fa-user"></i>${cv.cv.careerProfileTitle}</h2>
                <div class="summary">
                    <p>${cv.cv.careerProfileText}</p>
                </div><!--//summary-->
            </section><!--//section-->
            
            <section class="section experiences-section">
                <h2 class="section-title"><i class="fa fa-briefcase"></i>${cv.cv.experiencesTitle}</h2>
              
	           <c:forEach items="${cv.cv.experience}" var="experience">
	                 
	              <div class="item">
	                    <div class="meta">
	                        <div class="upper-row">
	                            <h3 class="job-title">${experience.roleTitle}</h3>
	                            <div class="time">${experience.fromDateF} - 
		                            <c:if test="${experience.untilNow}">
		                             	${experience.untilNowIdiom}
		                            </c:if>
		                            <c:if test="${not experience.untilNow}">
		                             	${experience.toDateF}
		                            </c:if>
	                           </div>
	                        </div><!--//upper-row-->
	                        <div class="company">${experience.company}</div>
	                    </div><!--//meta-->
	                    <div class="details">
	               				${experience.text}
	                    </div><!--//details-->
	                </div><!--//item-->
	                 
	                
	           </c:forEach>
              
            </section><!--//section-->
            
            <!-- 
            <section class="section projects-section">
                <h2 class="section-title"><i class="fa fa-archive"></i>Projects</h2>
                <div class="intro">
                    <p>You can list your side projects or open source libraries in this section. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum et ligula in nunc bibendum fringilla a eu lectus.</p>
                </div>
                <div class="item">
                    <span class="project-title"><a href="#hook">Velocity</a></span> - <span class="project-tagline">A responsive website template designed to help startups promote, market and sell their products.</span>
                    
                </div>
                <div class="item">
                    <span class="project-title"><a href="http://themes.3rdwavemedia.com/website-templates/responsive-bootstrap-theme-web-development-agencies-devstudio/" target="_blank">DevStudio</a></span> - 
                    <span class="project-tagline">A responsive website template designed to help web developers/designers market their services. </span>
                </div>
                <div class="item">
                    <span class="project-title"><a href="http://themes.3rdwavemedia.com/website-templates/responsive-bootstrap-theme-for-startups-tempo/" target="_blank">Tempo</a></span> - <span class="project-tagline">A responsive website template designed to help startups promote their products or services and to attract users &amp; investors</span>
                </div>
                <div class="item">
                    <span class="project-title"><a href="hhttp://themes.3rdwavemedia.com/website-templates/responsive-bootstrap-theme-mobile-apps-atom/" target="_blank">Atom</a></span> - <span class="project-tagline">A comprehensive website template solution for startups/developers to market their mobile apps. </span>
                </div>
                <div class="item">
                    <span class="project-title"><a href="http://themes.3rdwavemedia.com/website-templates/responsive-bootstrap-theme-for-mobile-apps-delta/" target="_blank">Delta</a></span> - <span class="project-tagline">A responsive Bootstrap one page theme designed to help app developers promote their mobile apps</span>
                </div>
            </section>
            
             -->
            
            <section class="skills-section section">
                <h2 class="section-title"><i class="fa fa-rocket"></i>${cv.cv.skillsTitle}</h2>
                <div class="skillset">        
                    
                    <c:forEach items="${cv.cv.skill}" var="skill">
                        <div class="item">
	                        <h3 class="level-title">${skill.name}</h3>
	                        <div class="level-bar">
	                            <div class="level-bar-inner" data-level="${skill.percent}%">
	                            </div>                                      
	                        </div><!--//level-bar-->                                 
	                    </div><!--//item-->
                    </c:forEach>
                    
                </div>  
            </section><!--//skills-section-->
            
        </div><!--//main-body-->
    </div>
 
    <footer class="footer">
        <div class="text-center">
                <!--/* This template is released under the Creative Commons Attribution 3.0 License. Please keep the attribution link below when using for your own project. Thank you for your support. :) If you'd like to use the template without the attribution, you can check out other license options via our website: themes.3rdwavemedia.com */-->
                <small class="copyright">Designed by <a href="http://themes.3rdwavemedia.com" target="_blank">Xiaoying Riley</a></small>
        </div><!--//container-->
    </footer><!--//footer-->
 
    <!-- Javascript -->          
    <script type="text/javascript" src="${plugins}/jquery-1.11.3.min.js"></script>  
    <script type="text/javascript" src="${plugins}/bootstrap/js/bootstrap.min.js"></script>    
    <!-- custom js -->
    <script type="text/javascript" src="${js}/main.js"></script>       
    
    <script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-88351650-1', 'auto');
		  ga('send', 'pageview');

	</script>
         
</body>
</html> 

