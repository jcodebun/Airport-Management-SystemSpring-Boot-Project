<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2">
<sf:form method="post" action="${pageContext.request.contextPath}/home/login/flightlist" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;">
  <center><i class="fas fa-tasks" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Update Pre-Flight Mode Check List</h5>
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    <div class="col-md-15">
					<s:bind path="planeId">
						<label for="inputEmail4" class="form-label">Select Plane</label>
						<sf:select style="margin-bottom: 10px" class="form-control"
								path="${status.expression}">
								<sf:option value="-1" label="Select" />
								
								<sf:options itemLabel="modelNumber" itemValue="id" items="${planeList}" />
							</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
   <div class="col-md-15">
					<s:bind path="laptopPower">
						<label for="inputEmail4" class="form-label">Is Laptop Power?</label>
						<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${laptop_power}" />
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
	<div class="col-md-15">
					<s:bind path="laptopBattery">
						<label for="inputEmail4" class="form-label">Is Laptop Battery?</label>
						<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${laptop_battery}" />
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>			
	<div class="col-md-15">
					<s:bind path="missionPlanner">
						<label for="inputEmail4" class="form-label">Is Mission Plan?</label>
						<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${mission}" />
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
	<div class="col-md-15">
					<s:bind path="Motor">
						<label for="inputEmail4" class="form-label">Is Motor?</label>
						<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${motor}" />
								</sf:select>
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

<script>
    $(document).ready(function(){
      var date_input=$('input[name="date"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
</script>