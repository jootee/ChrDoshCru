<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$name = $_POST['name'];
		$cont = $_POST['cont'];
		$time = $_POST['time'];
		$date = $_POST['date'];
		$ford = $_POST['ford'];
		$image = $_POST['image'];
		
		//Creating an sql query
		$sql = "INSERT INTO ministers (name,content,time,date,ford,image) VALUES ('$name','$cont','$time','$date','$ford','$image')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'post Added Successfully';
		}else{
			echo 'Could Not Add poster';
		}
		
		//Closing the database 
		mysqli_close($con);
	}