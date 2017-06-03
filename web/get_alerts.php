<?php
  $host = "db.ist.utl.pt";
  $user = "ist179069";
  $pass = "qpaq9059";
  $dsn = "mysql:host=$host;dbname=$user";
  try {
    $connection = new PDO($dsn, $user, $pass, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
  }catch(PDOException $exception){
    echo("<p>Error: ");
    echo($exception->getMessage());
    echo("</p>");
    exit();
  }
  $sql = "SELECT * FROM alert ORDER BY day DESC, hour DESC";
  if($stmt = $connection->prepare($sql))
  {
      $stmt->execute();
      $data = $stmt->fetchAll(PDO::FETCH_ASSOC);
      $stmt->closeCursor();

      header("content-type:application/json");
      echo("{\"alert\":");
      echo json_encode($data);
      echo("}");
      exit();

  }
?>
