// +----------------------------------------------------------------------
// | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
// +----------------------------------------------------------------------
// | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
// +----------------------------------------------------------------------
// | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
// +----------------------------------------------------------------------
// | Author: OTTERWOOD Team <admin@otterwood.com>
// +----------------------------------------------------------------------

const state = {
  logs: [],
};

const mutations = {
  ADD_ERROR_LOG: (state, log) => {
    state.logs.push(log);
  },
  CLEAR_ERROR_LOG: (state) => {
    state.logs.splice(0);
  },
};

const actions = {
  addErrorLog({ commit }, log) {
    commit('ADD_ERROR_LOG', log);
  },
  clearErrorLog({ commit }) {
    commit('CLEAR_ERROR_LOG');
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
