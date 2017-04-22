<html>

  <body>
    <center>
      <h1>Insert new user</h1>
      <form action="add_user.php" method="POST">
        Name:<br><input type="text" name="name"><br>
        ID:<br><input type="text" name="id"><br>
        <input type="submit" value="Add User">
      </form>

      <h1>Insert new check in</h1>
      <form action="add_checkin.php" method="POST">
        ID:<br><input type="text" name="id"><br>
        <input type="submit" value="Add Check In">
      </form>

      <h1>Insert new alert</h1>
      <form action="add_alert.php" method="POST">
        ID:<br><input type="text" name="id"><br>
        <input type="submit" value="Add Alert">
      </form>

      <h1>Insert new mobile</h1>
      <form action="add_mobile.php" method="POST">
        ID:<br><input type="text" name="id"><br>
        <input type="submit" value="Add Mobile">
      </form>

      <a href="get_data.php">Check Database</a>

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
        echo("<table border=\"1\"><tr><th>ID</th><th>Name</th><th>Reg Day</th><th>Reg Hour</th></tr>");
        foreach ($result as $row) {
          $id = $row['id'];
          $name = $row['name'];
          $day = $row['regday'];
          $hour = $row['reghour'];
          echo("<tr><td>{$id}</td><td>{$name}</td><td>{$day}</td><td>{$hour}</td></tr>");
        }
        echo("</table>");
      ?>
    </center>


  </body>

</html>
