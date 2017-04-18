<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>





<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Add product</h3>
	</div>
	<div class="panel-body">
		<div class="col-md-8 col-md-offset-2">

			<form:form name="addpform" method="post"
				action="${contextRoot}/admin/productAddition" commandName="product"
				enctype="multipart/form-data">
				<fieldset>

					<form:hidden path="pid" class="form-control"
						placeholder="Enter Product Id" value="${product.pid}" />

					<div class="form-group col-md-12">
						<form:label path="pname">Name: 
						</form:label>
						<form:input type="text" class="form-control" path="pname"
							placeholder="Product name" value="${product.pname}" />
					</div>


					<div class="form-group col-md-12">
						<form:label path="pprice">Price : 
						</form:label>
						<form:input path="pprice" type="text" class="form-control"
							placeholder="Prcie" value="${product.pprice}" />

					</div>


					<!-- <div class="form-group col-md-12">
						<form:label path="image">Upload image <span
								class="reqstar">&#42;</span>
						</form:label>
						<form:input type="file" path="image" />
					</div> -->
					
					<!-- File Button --> 
					<div class="form-group ">
					  <form:label class="col-md-4 control-label"  path="pimage" for="filebutton">Upload image</form:label>
					  <div class="col-md-4">
					    <form:input path="image" class="input-file" type="file" />
					  </div>
					</div>
					

					<div class="form-group col-md-12">
						<form:label path="pdescription">
                               Product details:
						</form:label>
						<form:textarea path="pdescription" class="form-control" rows="9"
							cols="25" required="true" placeholder="Product details"
							value="${product.pdescription}" />
					</div>

					<div class="form-group col-md-12">
						<button type="submit" class="btn btn-primary">Add</button>
					</div>

				</fieldset>



			</form:form>
		</div>
	</div>
</div> --%>




<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">

        
     <form:form class="form-horizontal" action="${contextRoot}/saveproduct" method="POST" commandName="product" enctype="multipart/form-data">

<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pid">Category ID</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="pid" placeholder="" class="form-control input-md" />
    
  </div>
</div>




<div class="form-group">
  <form:label class="col-md-4 control-label" for="textinput" path="pname">product name</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" path="pname" placeholder="" class="form-control input-md" />
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <form:label class="col-md-4 control-label" path="pdescription" for="textarea">description</form:label>
  <div class="col-md-4">                     
    <form:textarea class="form-control" id="textarea" path="pdescription" name="textarea"></form:textarea>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <form:label class="col-md-4 control-label"  path="pprice" for="textinput">price</form:label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text"  path="pprice" placeholder="" class="form-control input-md" />
    
  </div>
</div>


<!-- File Button --> 
<div class="form-group">
  <form:label class="col-md-4 control-label"  path="pimage" for="filebutton">Upload image</form:label>
  <div class="col-md-4">
    <form:input path="pimage" class="input-file" type="file" />
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">add</button>
  </div>
</div>


</form:form>

</div>