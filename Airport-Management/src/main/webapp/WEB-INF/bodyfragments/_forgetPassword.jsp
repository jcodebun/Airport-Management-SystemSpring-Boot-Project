<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
<sf:form method="post" action="${pageContext.request.contextPath}/home/login/forgetPassword" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;" >
  <center><i class="fa fa-key" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Forgot Password</h5>
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <div class="col-md-15">
					<s:bind path="employeeId">
						<label for="inputEmail4" class="form-label">Employee Id</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Employee id" class="form-control" type="text" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	
	
				<div class="col-md-15">
					<s:bind path="secretAns1">
						<label for="inputEmail4" class="form-label">Security Question 1: Nickname?</label>
						<sf:input type="text" path="${status.expression}"
							placeholder="Enter Answer" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="col-md-15">
					<s:bind path="secretAns2">
						<label for="inputEmail4" class="form-label">Security Question 2: PetName ?</label>
						<sf:input type="text" path="${status.expression}"
							placeholder="Enter Answer" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="col-md-15">
					<s:bind path="secretAns3">
						<label for="inputEmail4" class="form-label">Security Question 3: Mobile first 3 No.</label>
						<sf:input type="text" path="${status.expression}"
							placeholder="Enter Answer" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="col-md-15">
					<s:bind path="login">
						<label for="inputEmail4" class="form-label">Email</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Email" class="form-control" />
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