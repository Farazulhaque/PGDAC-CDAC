<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    	<%@include file="../templates/sellerHeader.jsp" %>



		<div  id="medicine-details">
      <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">Medicine Name</th>
            <th scope="col">Salt</th>
            <th scope="col">type Of Sell</th>
           	<th scope="col">Manufacture</th>
            <th scope="col">MRP</th>
            <th scope="col">MediBox Selling Price</th>
           	<th scope="col">Manage Your stock</th>
            
          </tr>
        </thead>
        <tbody>
          <c:forEach var="listM" items="${listOfMedicine}">
            <tr>
              <th scope="row">${listM.medicineName}</th>
              <td>${listM.salt}</td>
              <td>${listM.typeOfSell}</td>
              <td>${listM.manufacture.manufactureName}</td>
              <td>${listM.mrp}</td>
              <td>${(listM.mrp)-10}</td>
              <td><a class="btn btn-success " href="/AddinurStock?mid=${listM.medicineId}"><i class="fas fa-plus"></i>Add Your stock</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>







   	<%@include file="../templates/sellerFooter.jsp" %>
 </body>
</html>