layui.define(function (exports) {
  var i = (layui.$, layui.layer, layui.laytpl, layui.setter, layui.view, layui.admin);
  i.events.logout = function () {
    i.req({
      url: "/sys/logout",
      type: "get",
      data: {},
      done: function () {
        i.exit(function () {
          location.href = "/login.html"
        });
      }
    });
  };
  exports("common", {});
});