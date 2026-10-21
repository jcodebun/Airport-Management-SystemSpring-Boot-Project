<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
<sf:form method="post" action="${pageContext.request.contextPath}/ctl/help" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;" >
  <center><i class="fas fa-question" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Help</h5>
    <sf:hidden path="id"/> 
   
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <div class="col-md-15">
					<s:bind path="issue">
						<label for="inputEmail4" class="form-label">Issue</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Issue" class="form-control" type="text" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
    <div class="col-md-15">
					<s:bind path="description">
						<label for="inputEmail4" class="form-label">Description</label>
						<sf:textarea  path="${status.expression}"
							placeholder="Enter Description" class="form-control" type="text"/>
						
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	
	<c:if test="${sessionScope.user.roleId == 2}">
				<div class="col-md-6">
					<s:bind path="ansQuery">
						<label for="inputEmail4" class="form-label">Resolve Query</label>
						<sf:textarea rows="3" cols="10" path="${status.expression}"
							placeholder="Enter Answer" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</c:if>
				
				
				
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