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
  echo("<table border=\"1\"><tr><th>ID</th><th>Name</th><th>Reg Day</th><th>Reg Hour</th><th>Remove</th></tr>");
  foreach ($result as $row) {
    $id = $row['id'];
    $name = $row['name'];
    $day = $row['regday'];
    $hour = $row['reghour'];
    echo("<tr><td>{$id}</td><td>{$name}</td><td>{$day}</td><td>{$hour}</td><td>

    <form action=\"delete_user.php\" method=\"POST\">
      <input type=\"hidden\" value=\"{$id}\" name=\"id\" />
      <input type=\"submit\" value=\"Remove\">
    </form>

    </td></tr>");
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

  echo("<h2>Alerts</h2>");
  $sql = "SELECT * FROM alert";
  $result = $connection->query($sql);
  echo("{$result->rowCount()} results");
  echo("<table border=\"1\"><tr><th>ID</th><th>Day</th><th>Hour</th><th>Description</th></tr>");
  foreach ($result as $row) {
    $id = $row['id'];
    $day = $row['day'];
    $hour = $row['hour'];
    $description = $row['description'];
    echo("<tr><td>{$id}</td><td>{$day}</td><td>{$hour}</td><td>{$description}</td></tr>");
  }
  echo("</table>");

  echo("<h2>Mobiles</h2>");
  $sql = "SELECT * FROM mobile";
  $result = $connection->query($sql);
  echo("{$result->rowCount()} results");
  echo("<table border=\"1\"><tr><th>Token</th><th>Reg Day</th><th>Reg Hour</th></tr>");
  foreach ($result as $row) {
    $token = $row['token'];
    $day = $row['regday'];
    $hour = $row['reghour'];
    echo("<tr><td>{$token}</td><td>{$day}</td><td>{$hour}</td></tr>");
  }
  echo("</table>");



  $connection = NULL;
?>
      <a href="index.php">Home</a>
      <a href="delete.php">Delete records</a>
    </center>
  </body>
</html>
