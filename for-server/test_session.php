<?php
  $cookie_name = 'test_auth_token';
  $token = null;
  if (isset($_COOKIE[$cookie_name])) {
    $token = $_COOKIE[$cookie_name];
  } else {
    $token = 'トークンは設定されていません';
  }
?>

<html>
  <head>
    <meta charset="utf-8">
    <title>セッション確認</title>
  </head>
  <body>
     <div>セッションID:<?php echo $token; ?></div>
  </body>
</html>