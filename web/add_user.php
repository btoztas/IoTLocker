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
  $name = $_POST['name'];

  $day = date("Y-m-d");
  $hour = date("H:i:s");

  $stmt = $connection->prepare("INSERT INTO user VALUES (:id, :name, :day, :hour)");
  $stmt->bindParam(':id', $id);
  $stmt->bindParam(':name', $name);
  $stmt->bindParam(':day', $day);
  $stmt->bindParam(':hour', $hour);

  if($stmt->execute()){
    echo("<center>
            <h3> Added new user $name with card ID $id @ $day @ $hour</h3>
          </center>
        ");

  }else{
    echo("<center><h3>Something went wrong</h3></center>");
  }
  $connection = NULL;
?>

<center>
  <a href="index.php">Home</a>
</center>
