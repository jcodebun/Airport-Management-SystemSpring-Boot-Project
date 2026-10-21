<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2">
<sf:form method="post" action="${pageContext.request.contextPath}/home/login/plane" modelAttribute="form"><br/>
<div class="card card-centered" style="width: 45rem; color: #5bc0de; font-family: sans-serif;">
  <center><i class="fas fa-fighter-jet" aria-hidden="true" style='font-size:48px;color:#5bc0de'></i></center>
  <div class="card-body" >
    <h5 class="card-title" align="center">Register Plane</h5>
    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    <div class="col-md-15">
					<s:bind path="modelNumber">
						<label for="inputEmail4" class="form-label">Model Number</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Model Number" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	<div class="col-md-15">
					<s:bind path="purchaseDate">
						<label for="inputEmail4" class="form-label">Purchase Date</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Purchase date" id="datepicker"  class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	<div class="col-md-15">
					<s:bind path="lastServiceDate">
						<label for="inputEmail4" class="form-label">Last Service Date</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Last Service date" id="datepicker1" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	<div class="col-md-15">
					<s:bind path="price">
						<label for="inputEmail4" class="form-label">Price</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Price"  class="form-control" />
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