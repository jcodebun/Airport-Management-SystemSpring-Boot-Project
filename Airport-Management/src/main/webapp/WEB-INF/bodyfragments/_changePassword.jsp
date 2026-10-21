<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
<sf:form method="post" action="${pageContext.request.contextPath}/home/login/changepassword" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;" >
  <center><i class="fa fa-key" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Change Password</h5>
  
		<sf:hidden path="id"/>
		
		 
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
   
    <div class="col-md-15">
					<s:bind path="oldPassword">
						<label for="inputEmail4" class="form-label">Old Password</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Old passsword" class="form-control" type="password" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	
	
				<div class="col-md-15">
					<s:bind path="newPassword">
						<label for="inputEmail4" class="form-label">New Password</label>
						<sf:input type="password" path="${status.expression}"
							placeholder="Enter New Password" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="col-md-15">
					<s:bind path="confirmPassword">
						<label for="inputEmail4" class="form-label">Confirm Password</label>
						<sf:input type="password" path="${status.expression}"
							placeholder="Enter Confirm Password" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				
					<br>
				<div class="col-md-10" align="center">
					<input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset">
				</div>								
				
  </div>
</div>
</sf:form>
</div>