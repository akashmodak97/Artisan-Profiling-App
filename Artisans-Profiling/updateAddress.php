<?php
		$con=new mysqli("localhost","root","","artisan-profiling");

		$b = $_GET["district"];
		$c =$_GET["addressLine1"];
		$d = $_GET["addressLine2"];
		$e =$_GET["pinCode"];
		$f = $_GET["landMark"];
		$a =$_GET["id"];
		$x =$_GET["addressExp"];
		

		$st=$con->prepare("UPDATE `artisan` SET `district`=?, `addressLine1`=?, `addressLine2`=?, `pinCode`=?, `landMark`=? WHERE `id`=?");
		$st->bind_param("ssssss", $b, $c, $d, $e, $f, $a);
		$st->execute();

	

		echo "data uploaded successfully!";
?>
