<?php

$con= mysqli_connect("localhost","root","","artisanprofile");
// if ($con->connect_error) {
// 	# code...
// 	die("connection has been failed".$con->connect_error);
// }

$id = $_GET["id"];
// $format = numfmt_create('ba', NumberFormatter::DECIMAL);
$bn = ["১","২","৩","৪","৫","৬","৭","৮","৯","০"];
$en = ["1","2","3","4","5","6","7","8","9","0"];
$number = 1;
// $number+=50;
// $number =  str_replace($en,$bn,$number);
// echo $number;
// $id = 166;

$query = "SELECT `name`, `phone`, `profilePicture`, `experience`, `district`, `addressLine1`, `addressLine2`, `pinCode`, `landMark` FROM `artisan` WHERE `id`=$id";

$result = mysqli_query($con,$query);

//$row = mysqli_fetch_array($result,MYSQLI_ASSOC);
    $count = mysqli_num_rows($result);

    if ($count > 0) {
    	  while($row = mysqli_fetch_array($result)) {
    		# code...
echo '<center><div style="font-size:26px;"> <b>নাম:</b> '.$row['name'].'</div><br>'.'<div style="font-size:22px;"><b>ফোন নম্বর:</b> '.$row['phone'].'</div><br><img src="'.$row['profilePicture'].'" height=450 width=300><br><div style="font-size:22px;"><b>অভিজ্ঞতা:</b> '.$row['experience'].' বছর <br>'.'<b>জেলা:</b> '.$row['district'].'<br>'.'<b>ঠিকানা: </b>'.$row['addressLine1'].','.'<br>'.$row['addressLine2'].'<br>'.'<b>পিন-কোড: </b> '.$row['pinCode'].'<br>'.'<b>ল্যান্ড মার্ক :</b> '.$row['landMark'].'</div>';
    	  
    	}
    }
    	
$query1 = "SELECT `productImageName` FROM `attachmentimage` WHERE `artisanid`=$id";
    	
    	$result1 = mysqli_query($con,$query1);

//$row = mysqli_fetch_array($result,MYSQLI_ASSOC);
    $count1 = mysqli_num_rows($result1);
    
    $query2 = "SELECT `audioUrl` FROM `attachmentAudio` WHERE `artisanid`=$id";
    $result2 = mysqli_query($con,$query2);

    if ($count1 > 0) {
    	  while($row1 = mysqli_fetch_array($result1)) {
    		# code...
$number =  str_replace($en,$bn,$number);
echo '<div style="font-size:20px;"><b><br>----পণ্যের ছবি '. $number.'----</b></div><br><img src="'.$row1['productImageName'].'" height=450 width=300><br>';
    		
    		$number =  str_replace($bn,$en,$number);
    		if($number==4){
    		    $number=0;
    		    $row2 = mysqli_fetch_array($result2);
    		    echo '<div style="font-size:20px;"><b>--আপনার রেকর্ড করা অডিও--</b></div><br><audio controls>
  <source src="'.$row2['audioUrl'].'" height=350 width=300></audio><br>';
    		
    		}
    		$number++;
    	}
    	

    }
    
    


//     $count2 = mysqli_num_rows($result2);

//     if ($count2 > 0) {
//     	  while($row2 = mysqli_fetch_array($result2)) {
//     		# code...
// echo '<div style="font-size:20px;"><b>--আপনার রেকর্ড করা অডিও--</b></div><br><audio controls>
//   <source src="'.$row2['audioUrl'].'" height=350 width=300></audio><br>';
    	  
//     	}
    	

//     }
?>

<html>
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth&display=swap" rel="stylesheet">
        <style>
            body{
                background-color: #eee;
                font-family: 'Amaranth',sans-serif;
            }
        </style>
    </head>
</html>