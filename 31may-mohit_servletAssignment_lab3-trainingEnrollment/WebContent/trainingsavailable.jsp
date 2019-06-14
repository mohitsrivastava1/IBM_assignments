<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trainings Available</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<body>

  <table class="table">

  <thead class="thead-dark">

    <tr>

      

      <th scope="col">Training ID</th>

      <th scope="col">Training Name</th>

      <th scope="col">Available Seats</th>

      <th scope="col"></th>

    </tr>

  </thead>

  



<%

   try{

	   //DatabaseService dbService = new DatabaseService();
	   
	   Class.forName("com.mysql.jdbc.Driver");

	   Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/31may-trainingenrollment", "root", "");
 
	   String query = "Select * from training";

	   Statement stmt=dbCon.createStatement();

	   ResultSet rs=stmt.executeQuery(query);
	   

	   while(rs.next())

	   {

	   %>

	   <tbody>

       <tr>

         <td><%= rs.getInt("training_id") %></td>

         <td><%= rs.getString("training_name") %></td>

         <td id = "seats<%=rs.getInt("training_id")%>"><%=rs.getInt("available_seats") %></td>

         <td><button class ="btn btn-primary" onclick = "loadTable(<%= rs.getInt("training_id")%>)">Enroll</button></td>

       </tr>

       </tbody>

	   <%



	   }

	   %>

	       </table>

	       <%


   }catch(SQLException e){
	   

   }

%>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">



function loadTable(id){

	varS = "seats"+id;

	$('#'+varS).load("enroll?id="+id,function(responseValue, statusValue, xhr){

	});

}



</script>

</body>

</html>