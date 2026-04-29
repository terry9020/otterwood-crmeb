// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------

import Layout from '@/layout';

const orderRouter = {
  path: '/order',
  component: Layout,
  redirect: '/order/index',
  name: 'Order',
  alwaysShow: true,
  meta: {
    title: '订单管理',
    icon: 'clipboard',
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/order/index'),
      name: 'OrderIndex',
      meta: { title: '订单管理' },
    },
  ],
};

export default orderRouter;
