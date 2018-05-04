<!DOCTYPE html>
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <script src="/js/jquery-1.12.3.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <style type="text/css">
    #msg {
        height: 400px;
        overflow-y: auto;
    }
    #userName {
        width: 200px;
    }
    #logout {
        display: none;
    }
    </style>
    <title>webSocket测试</title>
</head>
<body>
    <div class="container">
        <div class="page-header" id="tou">webSocket及时聊天Demo程序</div>
        <p class="text-right" id="logout">
            <button class="btn btn-danger" id="logout-btn">退出</button>
        </p>
        <div class="well" id="msg"></div>
        <div class="col-lg">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="发送信息..." id="message"> <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="send"
                        disabled="disabled">发送</button>
                </span>
            </div>
            <div class="input-group">
                <input id="userName" type="text" class="form-control" name="userName" placeholder="输入您的用户名" />
                <button class="btn btn-default" type="button" id="connection-btn">建立连接</button>
            </div>
            <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
    </div>
    <script type="text/javascript">
    $(function() {
        var websocket;
        $("#connection-btn").bind("click", function() {
            var userName = $("#userName").val();
            if (userName == null || userName == "") {
                alert("请输入您的用户名");
                return;
            }
            connection(userName);
        });
        function connection(userName) {
            var host = window.location.host;
            if ('WebSocket' in window) {
                websocket = new WebSocket("ws://" + host +
                    "/webSocketServer/" + userName);
            } else if ('MozWebSocket' in window) {
                websocket = new MozWebSocket("ws://" + host +
                    "/webSocketServer/" + userName);
            }
            websocket.onopen = function(evnt) {
                $("#tou").html("链接服务器成功!")
                $("#send").prop("disabled", "");
                $("#connection-btn").prop("disabled", "disabled");
                $("#logout").show();
            };
            websocket.onmessage = function(evnt) {
                $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
            };
            websocket.onerror = function(evnt) {
                $("#tou").html("报错!")
            };
            websocket.onclose = function(evnt) {
                $("#tou").html("与服务器断开了链接!");
                $("#send").prop("disabled", "disabled");
                $("#connection-btn").prop("disabled", "");
                $("#logout").hide();
            }
        }
        function send() {
            if (websocket != null) {
                var $message = $("#message");
                var data = $message.val();
                if (data == null || data == "") {
                    return;
                }
                websocket.send(data);
                $message.val("");
            } else {
                alert('未与服务器链接.');
            }
        }
        $('#send').bind('click', function() {
            send();
        });
        $(document).on("keypress", function(event) {
            if (event.keyCode == "13") {
                send();
            }
        });
        $("#logout-btn").on("click", function() {
            websocket.close(); //关闭TCP连接
        });
    });
    </script>
</body>
</html>