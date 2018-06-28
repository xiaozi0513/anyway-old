layui.config({
  base: "/"
}).extend({
  index: 'lib/index' //主入口模块
}).use('index', function () {
  var $ = layui.$,
    element = layui.element;
  console.log("开始加载菜单...");
  //加载菜单
  $.ajax({
    url: '/json/menu',
    type: 'GET',
    data: {},
    dataType: 'json',
    success: function (res) {
      showMenu(res.data);
    }
  });
  var showMenu = function (strData) {
    var data;
    if (typeof(strData) == "string") {
      var data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
    } else {
      data = strData;
    }
    var ulHtml = '';
    for (var i = 0; i < data.length; i++) {
      ulHtml += '<li data-name="home" class="layui-nav-item">';
      //判断是否有子菜单
      if (data[i].children != undefined && data[i].children.length > 0) {
        ulHtml += '<a href="javascript:;" lay-tips="'+data[i].name+'" lay-direction="2">';
        ulHtml += '<i class="layui-icon layui-icon-app"></i>';
        ulHtml += '<cite>'+data[i].name+'</cite>';
        ulHtml += '</a>';
        ulHtml = navBar(data[i].children, ulHtml);
      } else {
        //没有子菜单，给菜单加上跳转链接
        //判断是否跳转到单独页面
        if (data[i].target == "_blank") {
          ulHtml += '<a lay-href="' + data[i].url + '" lay-tips="' + data[i].name + '" lay-direction="2" target="' + data[i].target + '">';
        } else {
          ulHtml += '<a lay-href="' + data[i].url + '" lay-tips="' + data[i].name + '" lay-direction="2">';
        }
        //判断图标的显示
        //todo
        ulHtml += '<i class="layui-icon layui-icon-app"></i>';
        ulHtml += '<cite>' + data[i].name + '</cite>';
      }
    }
    console.log(ulHtml);
    $("#LAY-system-side-menu").append(ulHtml);
    element.init();  //初始化页面元素
  };

  navBar = function (data, ulHtml) {
    ulHtml += '<dl class="layui-nav-child">';
    for (var i=0; i<data.length; i++){
      ulHtml += '<dd>';
      if (data[i].children != undefined && data[i].children.length > 0){
        ulHtml += '<a href="javascript:;">'+data[i].name+'</a>';
        ulHtml = navBar(data[i].children, ulHtml);
      }else{
        ulHtml += '<a lay-href="'+data[i].url+'">'+data[i].name+'</a>';
      }
      ulHtml += '</dd>';
    }
    ulHtml += '</dl>';

    return ulHtml;
  }
});