<?php
		$con=mysqli_connect("localhost","id14527893_root","grB8e0[@rJ[\OOi=","id14527893_artisansprofiling");

		
		$a =$_GET["id"];
		$p = $_GET["exp"];

		$st=$con->prepare("UPDATE `artisan` SET `experience`=? WHERE `id`=?");
		$st->bind_param("ss", $p, $a);
		$st->execute();

		echo "data uploaded successfully!";
?>
