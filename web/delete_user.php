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


  $stmt = $connection->prepare("DELETE FROM checkin WHERE id = :id");
  $stmt->bindParam(':id', $id);

  if($stmt->execute()){
    echo("<center>
            <h3> Removed acesses with card ID $id</h3>
          </center>
        ");

  }else{
    echo("<center><h3>No stats for user $id</h3></center>");
  }

  $stmt = $connection->prepare("DELETE FROM user WHERE id = :id");
  $stmt->bindParam(':id', $id);

  if($stmt->execute()){
    echo("<center>
            <h3> Removed user with card ID $id</h3>
          </center>
        ");

  }else{
    echo("<center><h3>Something went wrong when trying to remove user id: $id</h3></center>");
    echo($connection->errorInfo());
  }





  $connection = NULL;
?>

<center>
  <a href="index.php">Home</a>
</center>
