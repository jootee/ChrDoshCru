<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Getting values 
		$id = $_POST['id'];
		$name = $_POST['name'];
		$cont = $_POST['cont'];
		$time = $_POST['time'];
		$date = $_POST['date'];
		$ford = $_POST['ford'];
		$image = $_POST['image'];
		
		//importing database connection script 
		require_once('dbConnect.php');
		
		//Creating sql query 
		$sql = "UPDATE lcf SET name = '$name', content = '$cont', time = '$time', date = '$date', ford = '$ford', image = '$image' WHERE user_id = $id;";
		
		//Updating database table 
		if(mysqli_query($con,$sql)){
			echo 'lcf Updated Successfully';
		}else{
			echo 'Could Not Update lcf Try Again';
		}
		
		//closing connection 
		mysqli_close($con);
	}


?>