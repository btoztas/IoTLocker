<?php
	$file = 'test.html';
	$current = $_POST['word'];
	file_put_contents($file, $current);
?>
