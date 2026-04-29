<template>
  <div class="divBox">
    <el-card class="box-card">
      <el-button type="primary" v-hasPermi="['admin:system:config:clear:cache']" v-debounceClick="handleClear"
        >清除缓存</el-button
      >
    </el-card>
  </div>
</template>

<script>
// +---------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +---------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +---------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +---------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +---------------------------------------------------------------------
import { clearCacheApi } from '@/api/systemConfig';
export default {
  name: 'clearCache',
  methods: {
    handleClear() {
      clearCacheApi().then((response) => {
        this.$message.success('清除成功');
      });
    },
  },
};
</script>

<style scoped></style>
