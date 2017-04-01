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
        ID:<br><select name="id">

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
            $sql = "SELECT * FROM user";
            $result = $connection->query($sql);
            foreach ($result as $row) {
              $id = $row['id'];
              $name = $row['name'];
              echo("<option value=\"{$id}\">{$id} - {$name}</option>");
            }
            ?>
        </select><br>
        Date:<br><input type="date" name="day"><br>
        Time:<br><input type="time" name="hour"><br>
        <input type="submit" value="Add Check In">
      </form>

      <a href="get_data.php">Check Database</a>
    </center>
  </body>

</html>
