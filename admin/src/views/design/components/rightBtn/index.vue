<template>
  <div class="btn-box" style="display: none">
    <el-button type="primary" @click="handleSubmit('formInline')" style="text-align: center; width: 60%"
      >确定</el-button
    >
  </div>
</template>

<script>
// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------
import { mapState, mapMutations, mapActions } from 'vuex';
export default {
  name: 'rightBtn',
  props: ['activeIndex', 'configObj'],
  methods: {
    // 右侧确认保存配置
    handleSubmit(name) {
      let obj = {};
      obj.activeIndex = this.activeIndex;
      obj.data = this.configObj;
      this.add(obj);
    },
    ...mapMutations({
      add: 'mobildConfig/UPDATEARR',
    }),
  },
};
</script>

<style scoped></style>
