<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reports</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
  <div class="container">
  <h1 class="pb-3 pt-3">Report Application</h1>
   <form:form action="search" modelAttribute="searching" method="POST"> 
  <table>
  <tr>
  <td>Plan Name:</td>
  <td>
  <form:select path="PlanName">
  <form:option value="">-select-</form:option>
  <form:options items="${names}"/>
  </form:select>
  </td>
  
  <td>Plan Status:</td>
  <td>
  <form:select path="planStatus">
  <form:option value="">-select-</form:option>
  <form:options items="${status}"/>
  </form:select>
  </td>
  
 <td>Gender:</td>
<td>
  <form:select path="Gender">
    <form:option value="">-select-</form:option>
    <form:option value="Male">Male</form:option>
    <form:option value="Female">Female</form:option>
  </form:select>
</td>

  </tr>
  
  <tr>
   <td>Start Date:</td>
  <td>
  <form:input path="StartDate" type="date" />
  </td>
 	
  <td>End Date:</td>
  <td>
  <form:input path="EndDate" type="date"/>
  </td>
  </tr>
  <tr>
  <td>
  <a href="/" class="btn btn-secondary">Reset</a>
  </td>
  <td>
  <input type="submit" value="Search"
   class="btn btn-primary"/>
  </td>
  </table>
  </form:form>
  <hr>
  <table class="table table-striped table-hover">
 <thead>
 <tr>
 <th>Sl.No</th>
 <th>Holder name</th>
 <th>gender</th>
 <th>plan name</th>
 <th>plan Status</th>
 <th>Start date</th>
 <th>End Date</th>
 <th>Benifit Amount</th>
 </tr>
 </thead> 
 <tbody>
 <c:forEach items="${plans}" var="plan" varStatus="index">
 <tr>
 <td>${index.count}</td>
 <td>${plan.CitizenName}</td>
 <td>${plan.CitizenGender}</td>
 <td>${plan.Plan_Name}</td>
 <td>${plan.Plan_Status}</td>
 <td>${plan.Plan_StartDate}</td>
 <td>${plan.Plan_EndDate}</td>
 <td>$Benefit_Amount}</td>
 </tr>
</c:forEach>
<c:if test=${empty plans }">
No Record
</c:if>
 </tbody>
  </table>
  <hr>
  Export :<a href="excel" > Excel</a>  <a href="pdf" >PDF</a>
  </div>
 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
         integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
  </body>
</html>