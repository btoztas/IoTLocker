<?php
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
      echo("ACCESS_AUTHORIZED
            <center>
              <h3> Added new checkin: id $id @ $day @ $hour</h3>
            </center>
          ");

    }else{
      echo("ACCESS_DENIED
            <center><h3>Something went wrong adding new checkin: id $id @ $day @ $hour</h3></center>");
    }

  }else{

    echo("ACCESS_DENIED
          <center><h3>UNAUTHORIZED USER - SENDING ALERT</center>");

    $id = 1;
    $description = "UNAUTHORIZED USER";

    $stmt = $connection->prepare("INSERT INTO alert VALUES (:id, :day, :hour, :description)");
    $stmt->bindParam(':id', $id, PDO::PARAM_INT);
    $stmt->bindParam(':day', $day);
    $stmt->bindParam(':hour', $hour);
    $stmt->bindParam(':description', $description);


    if($stmt->execute()){
      echo("<center>
              <h3> Added new alert: id $id @ $day @ $hour @ $description</h3>
            </center>
          ");

    }else{
      echo("<center><h3>Something went wrong when trying to add new alert: id $id @ $day @ $hour @ $description</h3></center>");
      echo($connection->errorInfo());
    }

    // TODO: Send Alert to FIREBASE

  }
  $connection = NULL;
?>

<center>
  <a href="index.php">Home</a>
</center>
