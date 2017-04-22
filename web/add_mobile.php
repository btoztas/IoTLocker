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

  $token = $_POST['id'];
  $day = date("Y-m-d");
  $hour = date("H:i:s");

  $stmt = $connection->prepare("INSERT INTO mobile VALUES (:token, :day, :hour)");
  $stmt->bindParam(':token', $token);
  $stmt->bindParam(':day', $day);
  $stmt->bindParam(':hour', $hour);

  if($stmt->execute()){
    echo("<center>
            <h3> Added new mobile with token $token @ $day @ $hour</h3>
          </center>
        ");

  }else{
    echo("<center><h3>Something went wrong when trying to add new mobile with token $token @ $day @ $hour</h3></center>");
  }
  $connection = NULL;
?>
<center>
  <a href="index.php">Home</a>
</center>
