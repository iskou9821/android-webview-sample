<?php
  $uid = $_POST['user_id'];
  $pwd = $_POST['password'];
  
  $token = md5($uid . '__' . $pwd . '__' . date());

  setcookie('test_auth_token', $token);
?>

<html>
  <head>
    <meta charset="utf-8">
    <title>login processed</title>
  </head>
  <body>
    <div>ログインぽい処理を実行しました</div>
    <form id="auth-token">
      <input id="user_name" type="hidden" value="<?php echo $uid; ?>" />
      <input id="user_token" type="hidden" value="<?php echo $token; ?>" />
    </form>
    <br/><br/> 
    <a href="./session_test.php">セッションテストページ</a>
  </body>
</html>