layui.define(['laytpl', 'layer', 'element', 'util'], function (exports) {
  exports('config', {
    container: 'LAY_app', //容器ID
    base: layui.cache.base, //静态资源所在路径
    views: layui.cache.base + 'tpl', //动态模板所在目录
    entry: 'index', //默认视图文件名
    engine: '.html', //视图文件后缀
    pageTabs: true,  //是否开启页面选项卡功能。iframe版推荐开启

    name: 'anywayApp',
    tableName: 'layuiAdmin', //本地存储表名
    MOD_NAME: 'admin', //模块事件名

    debug: true, //是否开启调试模式。如开启，接口异常时会抛出异常 URL 等信息

    //自定义请求字段
    request: {
      tokenName: false //自动携带token的字段名（如：access_token）。可设置 false 不携带
    },

    //扩展的第三方模块
    extend: [
      'echarts', //echarts核心包
      'echartsTheme', //echarts主题
    ],

    //主题配置
    theme: {
      //内置主题配色方案
      color: [{
        main: '#20222A', //主题色
        selected: '#009688', //选中色
        alias: 'default' //默认别名
      },{
        main: '#344058',
        logo: '#1E9FFF',
        selected: '#1E9FFF',
        alias: 'ocean' //海洋
      }],

      //初识的颜色索引，对应上面的配色方案数组索引
      initColorIndex: 0
    }
  });
});