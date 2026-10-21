<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container" style="margin-top: 10%; margin-bottom: 20%">
  <div class="row">
  <div class="col-sm-4">
    <div class="card shadow" style="background-color: buttonhighlight;">
      <div class="card-body" align="center">
        <h5 class="card-title" style="font-family: serif; font-weight: bold;" >Add Way Points</h5>
        <p class="card-text"> A stopping point that is along a route in which a set of coordinates identify a point.</p>
        <a href="${pageContext.request.contextPath}/home/login/addwaypoints" class="btn btn-info">Waypoints</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card shadow" style="background-color: buttonhighlight;">
      <div class="card-body" align="center">
        <h5 class="card-title" style="font-family: serif; font-weight: bold;" >Departure Location</h5>
        <p class="card-text">The starting point of a line of thought or course of action.</p>
        <a href="${pageContext.request.contextPath}/home/login/adddepartureloc" class="btn btn-info">Departure Location</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 mb-5">
    <div class="card shadow" style="background-color: buttonhighlight;">
      <div class="card-body" align="center">
        <h5 class="card-title" style="font-family: serif; font-weight: bold;" >Destination Location</h5>
        <p class="card-text">Destination Location is a location where you want to lan.</p>
        <a href="${pageContext.request.contextPath}/home/login/adddestinationloc" class="btn btn-info">Destination Location</a>
      </div>
    </div>
  </div>
</div>
</div>


<%-- <!-- Modal  for Waypoints-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color:#17a2b8">
        <h5 class="modal-title" id="exampleModalLabel">Add Waypoints</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <sf:form method="post" action="${pageContext.request.contextPath}/home/login/updatewaypoints" modelAttribute="form"><br/>

    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    
	<div class="mb-3">
					<s:bind path="wapointsName">
						<label for="inputEmail4" class="form-label">Waypoints</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Waypoints"   class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	
	
	<br>
				<div class="col-md-10" align="center">
					<!-- <input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset"> -->
				</div>								
				
  

      </div>
      <div class="modal-footer">
        <input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset">
      </div>
    </div>
    </sf:form>
  </div>
</div> --%>


<!-- Modal  for departure location-->
<%-- <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color:#17a2b8">
        <h5 class="modal-title" id="exampleModalLabel">Departure Location</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <sf:form method="post" action="${pageContext.request.contextPath}/home/login/updatedeploc" modelAttribute="form2"><br/>

    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    
	<div class="mb-3">
					<s:bind path="depLoc">
						<label for="inputEmail4" class="form-label">Departure Locations</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Departure Location"   class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	
	
	<br>
				<div class="col-md-10" align="center">
					<!-- <input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset"> -->
				</div>								
				
  

      </div>
      <div class="modal-footer">
        <input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset">
      </div>
    </div>
    </sf:form>
  </div>
</div> --%>

<!-- Modal  for destination location-->
<%-- <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color:#17a2b8" >
        <h5 class="modal-title" id="exampleModalLabel" >DestinationLocation</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <sf:form method="post" action="${pageContext.request.contextPath}/home/login/updatedesloc" modelAttribute="form3"><br/>

    <br>
    <b><%@ include file="businessMessage.jsp"%></b>
    <sf:hidden path="id"/>
    
	<div class="mb-3">
					<s:bind path="destinationLoc">
						<label for="inputEmail4" class="form-label">Destination Locations</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Destination Location"   class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
	</div>
	
	
	<br>
				<div class="col-md-10" align="center">
					<!-- <input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset"> -->
				</div>								
				
  

      </div>
      <div class="modal-footer">
        <input type="submit" name="operation"
						class="btn btn-info pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-info pull-right"
						value="Reset">
      </div>
    </div>
    </sf:form>
  </div>
</div> --%>