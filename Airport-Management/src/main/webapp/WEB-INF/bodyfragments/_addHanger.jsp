<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2">
<sf:form method="post" action="${pageContext.request.contextPath}/home/login/hanger" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;">
  <center><i class="fas fa-warehouse" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Add Hangers</h5>
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    <div class="col-md-15">
					<s:bind path="hangerName">
						<label for="inputEmail4" class="form-label">Hanger Name</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Hanger Name" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
    <div class="col-md-15">
					<s:bind path="hangerModel">
						<label for="inputEmail4" class="form-label">Hanger Model</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Hanger Model" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	<div class="col-md-15">
					<s:bind path="hangerAddress">
						<label for="inputEmail4" class="form-label">Hanger Address</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Address"   class="form-control" />
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