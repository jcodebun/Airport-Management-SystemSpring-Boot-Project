<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-lg bg-info">

  <a class="navbar-brand" href="#" style="color: white; font-size: 26px; font-family: serif;">Airport Management</a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			
			<c:if test="${sessionScope.user != null}">
				<span class="navbar-text"
					style="color: white; font-size: 14px; font-variant-caps: petite-caps;">
					Hello,${sessionScope.user.firstName},(${sessionScope.user.roleName }) </span>
			</c:if>
			<c:if test="${sessionScope.user == null}">
				
			</c:if>
			</ul>
			
		</div>
    
  </div>
</nav>
<div class="shadow bg-body rounded">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/home"/>">Home <span class="sr-only">(current)</span></a>
      </li>
      
     <c:if test="${sessionScope.user != null}">
						<c:if test="${sessionScope.user.roleId == 1}">
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/plane"/>">Add Planes</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/manager/search"/>">Manager List</a></li>
								
									<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/plane/search"/>">Plane List</a></li>
								<li class="nav-item"><a class="nav-link "
								href="<c:url value="/home/login/pilot/search"/>">Pilot List</a></li>
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/hanger"/>">Add Hanger</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/hanger/search"/>">Hanger List</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/updateResources"/>">Update Resources</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/workschedule"/>">Add Work Schedule</a></li>
								
								
							
						</c:if>
						<c:if test="${sessionScope.user.roleId == 2}">
							<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/hanger/search"/>">Hanger List</a></li>
								
							
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/allothanger"/>">Allocate Hangers</a></li>
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/allothanger/search"/>">View Hanger Status</a></li>
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/ctl/help/search"/>">Help List</a></li>
								
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/flightlist/search"/>">View Pre-Flight Mode</a></li>
							<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/postflightlist/search"/>">Post CheckList</a></li>
								
									
							
							
						</c:if>
						<c:if test="${sessionScope.user.roleId == 3}">
							<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/updateFlightPlan"/>">Flight Plan</a></li>
							<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/updateFlightPlan/search"/>">Registered Flight Plan</a></li>
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/ctl/help"/>">Help</a></li>
								
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/ctl/help/search"/>">Help Report</a></li>
							
							<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/viewWorkSchedule/search"/>">Work Schedules</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/flightlist"/>">Pre-Flight Mode</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/flightlist/search"/>">Pre-Flight Mode List</a></li>
							<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/postflightlist"/>">Post Mode</a></li>
								<li class="nav-item "><a class="nav-link "
								href="<c:url value="/home/login/postflightlist/search"/>">Post CheckList</a></li>
						</c:if>
       </c:if>
    </ul>
    
  </div>
  <ul class="nav justify-content-end">
				<c:if test="${sessionScope.user != null}">

					<li class="nav-item "><a class="nav-link "
						style="padding: 6px; color: black;" href="<c:url value="/home/login/changepassword"/>">Change
							Password</a></li> 

					<li class="nav-item "><a class="nav-link"
						style="padding: 6px; color: black;" href="<c:url value="/home/login"/>">Logout</a></li>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<li class="nav-item "><a class="nav-link"
						style="padding: 6px;" href="<c:url value="/home/login"/>">SignIn</a></li>
					<li class="nav-item "><a class="nav-link "
						style="padding: 6px;" href="<c:url value="/home/signUp"/>">SignUp</a></li>
				</c:if>
			</ul>
</nav>
</div>