<?php
if(isset($_POST["encoded_string"])){
 	
 	$id = $_POST["id"];
	$encoded_string = $_POST["encoded_string"];
	$image_name = $_POST["image_name"];
	
	$decoded_string = base64_decode($encoded_string);
	
	$path = 'images/'.$image_name;
	
	$file = fopen($path, 'wb');
	
	$is_written = fwrite($file, $decoded_string);
	fclose($file);
	
	if($is_written > 0) {
		
		echo ($id);
		$query = "INSERT INTO `attachmentimage` (productImageName, artisanid) VALUES('" . $image_name . "', '" . $id . "')";
		$conn = mysqli_connect('localhost', 'root', '','artisan-profiling');
		$result = mysqli_query($conn, $query) ;
		
		if($result){
			echo "data uploaded successfully!";
		}else{
			echo "failed";
		}
		
		mysqli_close($conn);
	}
 }
?>
