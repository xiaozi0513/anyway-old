layui.define('form', function (exports) {
  var $ = layui.$, form = layui.form;

  //校验
  form.verify({
    username: function (value, item) {
      if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
        return '用户名不能有特殊字符';
      }
      if (/(^\_)|(\__)|(\_+$)/.test(value)) {
        return '用户名首尾不能出现下划线\'_\'';
      }
      if (/^\d+\d+\d$/.test(value)) {
        return '用户名不能全为数字';
      }
    },
    pass: [/^[\S]{6,12}$/, "密码必须6-12位，且不能出现空格"]
  });

  //刷新验证码
  $("body").on("click", "#LAY-user-get-vercode", function () {
    $(this);
    this.src = "https://www.oschina.net/action/user/captcha?t=" + (new Date).getTime();
  });

  exports('login', {});
});