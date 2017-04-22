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
  echo("<h2>Deleted all records</h2>");
  $sql = "DELETE FROM checkin; DELETE FROM user";
  $result = $connection->query($sql);

?>
<center>
  <a href="index.php">Home</a>
</center>
