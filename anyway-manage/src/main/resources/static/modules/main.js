layui.config({
  base: "/"
}).extend({
  index: 'lib/index' //主入口模块
}).use('index', function () {
  var $ = layui.$,
    element = layui.element;

  /**
   * 加载菜单
   */
  $.ajax({
    url: '/sys/menu/nav',
    type: 'GET',
    data: {},
    dataType: 'json',
    success: function (res) {
      loadMenu(res.data);
    }
  });

  function loadMenu(data) {
    if (typeof(data) == "string") {
      data = JSON.parse(data); //将字符串转换成Json对象
    }
    console.log(data);
    var ulHtml = '';
    for (var i = 0; i < data.length; i++) {
      ulHtml += '<li data-name="home" class="layui-nav-item">';
      //判断是否有子菜单
      if (data[i].children != undefined && data[i].children.length > 0) {
        ulHtml += '<a href="javascript:;" lay-tips="'+data[i].name+'" lay-direction="2">';
        ulHtml += '<i class="layui-icon layui-icon-app"></i>';
        ulHtml += '<cite>'+data[i].name+'</cite>';
        ulHtml += '</a>';
        ulHtml = loadChildMenu(data[i].children, ulHtml);
      } else {
        //没有子菜单，给菜单加上跳转链接
        if (data[i].target == "_blank") {
          ulHtml += '<a lay-href="' + data[i].url + '" lay-tips="' + data[i].name + '" lay-direction="2" target="' + data[i].target + '">';
        } else {
          ulHtml += '<a lay-href="' + data[i].url + '" lay-tips="' + data[i].name + '" lay-direction="2">';
        }
        ulHtml += '<i class="layui-icon layui-icon-app"></i>';
        ulHtml += '<cite>' + data[i].name + '</cite>';
      }
    }
    console.log(ulHtml);
    $("#LAY-system-side-menu").append(ulHtml);
    element.init();  //初始化页面元素
  };

  /**
   * 递归加载子菜单
   */
  function loadChildMenu(data, ulHtml) {
    ulHtml += '<dl class="layui-nav-child">';
    for (var i=0; i<data.length; i++){
      ulHtml += '<dd>';
      if (data[i].children != undefined && data[i].children.length > 0){
        ulHtml += '<a href="javascript:;">'+data[i].name+'</a>';
        ulHtml = loadChildMenu(data[i].children, ulHtml);
      }else{
        ulHtml += '<a lay-href="'+data[i].url+'">'+data[i].name+'</a>';
      }
      ulHtml += '</dd>';
    }
    ulHtml += '</dl>';

    return ulHtml;
  }
});