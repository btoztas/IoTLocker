<?php
  include 'fcmmessage.php';
  $host = "db.ist.utl.pt";
  $user = "ist179069";
  $pass = "qpaq9059";
  $dsn = "mysql:host=$host;dbname=$user";
  try {
    $connection = new PDO($dsn, $user, $pass);
  }catch(PDOException $exception){
    echo("<p>Error: ");
    echo($exception->getMessage());
    echo("</p>");
    exit();
  }

  $id = (int) $_POST['id'];
  $day = date("Y-m-d");
  $hour = date("H:i:s");

  if($id == 1){
    $description = "UNAUTHORIZED USER";
  }elseif($id == 2){
    $description = "DOOR OPEN NO AUTH";
  }elseif($id == 3){
    $description = "UNUSUAL LIGHT LEVEL";
  }else{
    echo("WRONG ID");
    exit();
  }

  $stmt = $connection->prepare("INSERT INTO alert VALUES (:id, :day, :hour, :description)");
  $stmt->bindParam(':id', $id, PDO::PARAM_INT);
  $stmt->bindParam(':day', $day);
  $stmt->bindParam(':hour', $hour);
  $stmt->bindParam(':description', $description);


  if($stmt->execute()){
    echo("ADDED ALERT");

  }else{
    echo("<center><h3>Something went wrong when trying to add new alert: id $id @ $day @ $hour @ $description</h3></center>");
    echo($connection->errorInfo());
  }

  $sql = "SELECT token FROM mobile";
  $result = $connection->query($sql);
  foreach ($result as $row) {
    echo($row["token"]);
    $tokens[] = $row["token"];
  }

	$message_status = send_notification($tokens, $description);
	//echo $message_status;



  $connection = NULL;



?>
