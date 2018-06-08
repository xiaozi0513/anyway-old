layui.define("view", function (exports) {
  var $ = layui.jquery, //a
    laytpl = layui.laytpl, //i
    element = layui.element, //t
    config = layui.config, //l
    view = layui.view, //n
    device = layui.device(), //s
    _window = $(window), //r
    _body = $("body"), //o
    _container = $("#" + config.container),//u
    side_flexible_id = "LAY_app_flexible", //侧边伸缩按钮ID
    F = {
      //版本号
      version: '1.0.0',
      //请求
      req: view.req,
      //屏幕
      screen: function () {
        var width = _window.width;
        return width >= 1200 ? 3 : width >= 992 ? 2 : width >= 768 ? 1 : 0;
      },
      //退出
      exit: view.exit,
      //侧边伸缩
      sideFlexible: function (spread) {
        var a = _container,
          t = $("#"+side_flexible_id);
        "spread" === spread ? (t.removeClass("layui-icon-spread-left").addClass("layui-icon-shrink-right"),
        n<2?laytpl.addClass("layadmin-side-spread-sm"):laytpl.removeClass("layadmin-side-spread-sm"),
        laytpl.removeClass("layadmin-side-shrink")) : "???";
        layui.event.call(this, config.MOD_NAME, "side({*})",{status: spread});
      }
    };


  exports('admin', F);
});