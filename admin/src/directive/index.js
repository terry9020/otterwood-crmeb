// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------

import hasRole from './permission/hasRole';
import hasPermi from './permission/hasPermi';
import dialogDrag from './dialog/drag';
import dialogDragWidth from './dialog/dragWidth';
import dialogDragHeight from './dialog/dragHeight';
import copy from './copy/copy';

const install = function (Vue) {
  Vue.directive('hasRole', hasRole);
  Vue.directive('hasPermi', hasPermi);
  Vue.directive('dialogDrag', dialogDrag);
  Vue.directive('dialogDragWidth', dialogDragWidth);
  Vue.directive('dialogDragHeight', dialogDragHeight);
  Vue.directive('copy', copy);
};

if (window.Vue) {
  window['hasRole'] = hasRole;
  window['hasPermi'] = hasPermi;
  Vue.use(install); // eslint-disable-line
}

export default install;
