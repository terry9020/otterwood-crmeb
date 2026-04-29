// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------
const path = require('path');
const files = require.context('./', false, /\.vue$/);

const modules = {};
files.keys().forEach((key) => {
  const name = path.basename(key, '.vue');
  modules[name] = files(key).default || files(key);
});
export default modules;
