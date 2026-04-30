<template>
  <div class="layout-footer mt15">
    <div class="layout-footer-warp"></div>
  </div>
</template>

<script>
export default {
  name: 'layoutFooter',
  data() {
    return {};
  },
};
</script>

<style scoped lang="scss">
.layout-footer {
  width: 100%;
  display: flex;
  &-warp {
    margin: auto;
    color: var(--prev-color-text-secondary);
    text-align: center;
  }
}
</style>
