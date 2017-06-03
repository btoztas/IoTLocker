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

  $id = $_POST['id'];
  $day = date("Y-m-d");
  $hour = date("H:i:s");

  $sql = "SELECT * FROM user WHERE id = '$id'";
  $result = $connection->query($sql);

  if($result->rowCount()==1){

    $stmt = $connection->prepare("INSERT INTO checkin VALUES (:id, :day, :hour)");
    $stmt->bindParam(':id', $id);
    $stmt->bindParam(':day', $day);
    $stmt->bindParam(':hour', $hour);

    if($stmt->execute()){
      echo("ACCESS_AUTHORIZED");

    }else{
      echo("ACCESS_DENIED");
    }

  }else{

    echo("ACCESS_DENIED");

    $id = 1;
    $description = "UNAUTHORIZED USER";

    $stmt = $connection->prepare("INSERT INTO alert VALUES (:id, :day, :hour, :description)");
    $stmt->bindParam(':id', $id, PDO::PARAM_INT);
    $stmt->bindParam(':day', $day);
    $stmt->bindParam(':hour', $hour);
    $stmt->bindParam(':description', $description);


    if($stmt->execute()){

    }else{

    }

    $sql = "SELECT token FROM mobile";
    $result = $connection->query($sql);
    foreach ($result as $row) {
      echo($row["token"]);
      $tokens[] = $row["token"];
    }
  	$message_status = send_notification($tokens, $description);
  	//echo $message_status;

  }
  $connection = NULL;
?>
