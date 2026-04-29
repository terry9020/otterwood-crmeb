// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------

import request from '@/utils/request';

/**
 * 角色详情
 */
export function getRoleById(pram) {
  return request({
    url: `/admin/system/role/info/${pram.roles}`,
    method: 'GET',
  });
}

/**
 * 菜单
 * @param pram
 */
export function menuListApi() {
  return request({
    url: '/admin/getMenus',
    method: 'GET',
  });
}
