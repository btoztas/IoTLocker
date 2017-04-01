<html>
  <body>
    <center>
      <h1>Data Saved</h1>

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
  echo("<h2>Registered Users</h2>");
  $sql = "SELECT * FROM user";
  $result = $connection->query($sql);
  echo("{$result->rowCount()} results");
  echo("<table border=\"1\"><tr><th>ID</th><th>Name</th></tr>");
  foreach ($result as $row) {
    $id = $row['id'];
    $name = $row['name'];
    echo("<tr><td>{$id}</td><td>{$name}</td></tr>");
  }
  echo("</table>");

  echo("<h2>Check Ins</h2>");
  $sql = "SELECT * FROM checkin NATURAL JOIN user";
  $result = $connection->query($sql);
  echo("{$result->rowCount()} results");
  echo("<table border=\"1\"><tr><th>ID</th><th>Name</th><th>Date</th><th>Hour</th></tr>");
  foreach ($result as $row) {
    $id = $row['id'];
    $name = $row['name'];
    $day = $row['day'];
    $hour = $row['hour'];
    echo("<tr><td>{$id}</td><td>{$name}</td><td>{$day}</td><td>{$hour}</td></tr>");
  }
  echo("</table>");

  $connection = NULL;
?>
      <a href="insert.php">Home</a>
    </center>
  </body>
</html>
