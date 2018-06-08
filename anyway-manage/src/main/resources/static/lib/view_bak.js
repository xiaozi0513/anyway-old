layui.define(['laytpl', 'layer', 'config'], function (exports) {
  var $ = layui.jquery,//t
    laytpl = layui.laytpl,//n
    layer = layui.layer,//a
    config = layui.config,//r
    device = (layui.device(), layui.hint()),//o
    //创建对象
    module = function (_id) {//i
      return new main(_id);
    },
    default_id = "LAY_app_body",//s
    main = function (_id) {//d
      this.id = _id;
      this.container = $("#" + (_id || default_id));
    };

  //加载中
  module.loading = function (obj) {
    obj.append(this.elemLoad = $('<i class="layui-anim layui-anim-rotate layui-anim-loop layui-icon layui-icon-loading layadmin-loading"></i>'));
  };
  //加载完成
  module.removeLoad = function () {
    this.elemLoad && this.elemLoad.remove();
  };
  //退出
  module.exit = function (f) {
    layui.data(config.tableName, {
      key: config.request.tokenName,
      remove: !0
    });
    f && f();
  };
  //请求
  module.req = function () {
    $.ajax()
  };

  exports('view', module);
});