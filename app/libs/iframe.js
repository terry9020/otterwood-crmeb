// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------

let app = getApp();
/**
 * 点击事件，判断是否是isIframe页面
*/ 
export function goPage() {
	return new Promise(resolve => {
		if (app.globalData.isIframe == false) {
			resolve(true);
		}else{
			return false
		}
	});
}