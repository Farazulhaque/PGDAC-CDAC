<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <script>
   /*  function search() {
      var ajax = new XMLHttpRequest();
      var inpname = document.getElementById("name").value;
      var url = "/AjaxFormedicineFind?Mname="+inpname;

      ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
        	//let res = ajax.responseText
			//let result = JSON.parse(res);
          document.getElementById("search-result").innerText=ajax.responseText;
        }
      };
      ajax.open("Post", url, true);
      ajax.send(null);
    } */
  </script>
  <body>
    <%@include file="../templates/sellerHeader.jsp" %>

    <!-- search button and text box -->
    <!-- search -->
    <!-- <div class="container mx-auto row my-4">
      <form class="d-flex input-group">
        <input
          class="form-control me-2"
          type="text"
          id="name"
          onkeyup="search()"
          placeholder="Search"
          aria-label="Search"
        />
        <div class="input-group-append">
          <button class="btn btn-primary" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </form>
    </div> -->

    <!-- Form -->
    <section class="container-fluid" id="UpdateSection">
      <div class="form-group container-fluid">
        <label for="MName">Medicine Name</label>
        
      </div>

   <!-- form for add quantity of medicine -->

       <form action="addQuant" method="post">
        <table class="table">
          <thead class="thead-light">
            <tr>
              <th scope="col">
                <div class="form-group">
                  <label for="Name">Medicine Name</label>
                  		<select class="form-control" name="medicineMaster"  id="MName" onchange="MedecineData()">
				<c:if test="${singleMedicine!=null }"> <option value="${singleMedicine.medicineId}">${singleMedicine.medicineName}</option> </c:if>
				<c:if test="${updateMedicine!=null }"> <option value="${updateMedicine.medicineMaster.medicineId}">${updateMedicine.medicineMaster.medicineName}</option> </c:if>
					          		          	
					          	
					          	<c:if test="${singleMedicine==null }">
					          		<option value="-1">---Select Medicine--</option>
						          <c:forEach var="item" items="${listOfMedicine}">
						            	<option value="${item.medicineId}">${item.medicineName}</option>
						          </c:forEach>
					            </c:if>
        				</select>
                </div>
              </th>
              <th scope="col">
                <div class="form-group">
                  <label for="Quantity">Quantity</label>
                  <input
                    type="number"
                    class="form-control"
                    name="qunatity"
                    value="${updateMedicine.qunatity }"
                    id="Quantity"
                    placeholder="10"
                  />
                </div>
              </th>
              <th scope="col">
                <div class="form-group">
                  <label for="Discount">Your Extra Discount</label>
                  <input
                    type="number"
                    class="form-control"
                    name="sellerDiscount"
                    value="${updateMedicine.sellerDiscount}"
                    id="Quantity"
                    placeholder="5%"
                  />
                </div>
              </th>
              <th scope="col">
                <div class="form-group">
                  <input type="submit" class="btn btn-success" value="Submit" />
                </div>
              </th>
            </tr>
          </thead>
        </table>
   </form>
  
   </section>

    <!-- list of medicine  -->

    <button
      class="btn btn-success btn-block my-5"
      data-toggle="collapse"
      data-target="#medicine-details"
    >
      Show Medicine List
    </button>

    <div class="collapse" id="medicine-details">
      <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">Medicine Name</th>
            <th scope="col">Salt</th>
            <th scope="col">type Of Sell</th>
            <th scope="col">MRP</th>
            <th scope="col">MediBox Selling Price</th>
            <th scope="col">Seller Shop Name</th>
            <th scope="col">Quantity</th>
            <th scope="col">your extra Discount</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="listM" items="${listOfSellerMedicine}">
            <tr>
              <th scope="row">${listM.medicineMaster.medicineName}</th>
              <td>${listM.medicineMaster.salt}</td>
              <td>${listM.medicineMaster.typeOfSell}</td>
              
              <td>${listM.medicineMaster.mrp}</td>
              <td>${(listM.medicineMaster.mrp)-5-(listM.sellerDiscount)}</td>
              <th>${listM.seller.shopName}</th>
              <td>${listM.qunatity}</td> 
              <td>${listM.sellerDiscount}</td> 
	          <td><a class="btn btn-success float-left" href="/updateMfrmLst?medId=${listM.sellerMediManagerId}">Update</a>  
	              <a class="btn btn-danger float-left" href="/deleteMfrmLst?medId=${listM.sellerMediManagerId}">Delete</a>  </td>  
                          
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <%@include file="../templates/sellerFooter.jsp" %>
  </body>
</html>
