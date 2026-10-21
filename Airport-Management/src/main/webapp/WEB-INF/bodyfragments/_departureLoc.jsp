<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2">
<sf:form method="post" action="${pageContext.request.contextPath}/home/login/updatedeploc" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;">
  <center><i class="fas fa-warehouse" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Add Waypoints</h5>
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    <div class="col-md-15">
					<s:bind path="depLoc">
						<label for="inputEmail4" class="form-label">Departure Locations</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Departure Locations Name" class="form-control" />
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
