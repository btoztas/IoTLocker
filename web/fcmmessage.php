<?

function send_notification ($tokens, $message)
{
  $notification = array(
    "sound" => "default",
    "body" => $message
  );
  $url = 'https://fcm.googleapis.com/fcm/send';
  $fields = array(
     'registration_ids' => $tokens,
     'notification' => $notification
    );
  $headers = array(
    'Authorization:key = AAAAblYwuUw:APA91bHUesEqXNoKwJsIotVG8KGlktftpocNib4d1tVBsE4304joTzoiYCkd2YQvUscerkanhcI-R_IJqRuwoysm97ceXaUZgFnzuNYBT-NgGtI_RPSRuixkfXC-rJXbJgurNMsyE3YU',
    'Content-Type: application/json'
    );
   $ch = curl_init();
     curl_setopt($ch, CURLOPT_URL, $url);
     curl_setopt($ch, CURLOPT_POST, true);
     curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
     curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
     curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
     curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
     curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
     $result = curl_exec($ch);
     if ($result === FALSE) {
         die('Curl failed: ' . curl_error($ch));
     }
     curl_close($ch);
     return $result;
}
?>
