layui.define(function (exports) {
  var module = (layui.$, layui.layer, layui.laytpl, layui.setter, layui.view, layui.admin);
  module.events.logout = function () {
    module.req({
      url: '/sys/logout',
      type: 'get',
      data: {},
      done: function () {
        module.exit(function () {
          location.href = '/login.html'
        })
      }
    });
  };
  exports('common', {});
});