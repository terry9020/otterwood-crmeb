<template>
  <el-dialog
    :close-on-click-modal="false"
    :visible.sync="modals"
    title="发送货"
    class="order_box"
    :before-close="handleClose"
    width="900px"
  >
    <el-form
      ref="formItem"
      v-loading="loading"
      :model="formItem"
      label-width="130px"
      @submit.native.prevent
      :rules="rules"
    >
      <el-form-item label="选择类型：">
        <el-radio-group
          v-model="formItem.deliveryType"
          :disabled="isEdit"
          @change="changeRadioType(formItem.deliveryType)"
          required
        >
          <el-radio label="express">发货</el-radio>
          <el-radio label="send">送货</el-radio>
          <el-radio label="fictitious">虚拟</el-radio>
        </el-radio-group>
      </el-form-item>
      <!--发货-->
      <div v-if="formItem.deliveryType === 'express'">
        <el-form-item label="发货类型：">
          <el-radio-group
            :disabled="isEdit"
            v-model="formItem.expressRecordType"
            @change="changeRadio(formItem.expressRecordType)"
          >
            <el-radio label="1">手动填写</el-radio>
            <!-- 电子面单打印（一号通功能已移除，暂时隐藏） -->
            <!-- <el-radio label="2" v-if="checkPermi(['admin:order:sheet:info'])">电子面单打印</el-radio> -->
          </el-radio-group>
        </el-form-item>
        <!--手动填写-->
        <template v-if="formItem.expressRecordType === '1'">
          <el-form-item label="快递公司名称：" prop="expressName">
            <el-select v-model="formItem.expressCode" filterable clearable placeholder="请选择快递公司">
              <el-option v-for="item in express" :key="item.id" :label="item.name" :value="item.code" />
            </el-select>
          </el-form-item>
          <el-form-item label="快递单号：" prop="expressNumber">
            <el-input v-model="formItem.expressNumber" placeholder="请输入快递单号" />
          </el-form-item>
        </template>
      </div>
      <!--送货-->
      <div v-if="formItem.deliveryType === 'send'">
        <el-form-item label="送货人姓名：" prop="deliveryName">
          <el-input v-model="formItem.deliveryName" placeholder="请输入送货人姓名" />
        </el-form-item>
        <el-form-item label="送货人电话：" prop="deliveryTel">
          <el-input v-model="formItem.deliveryTel" placeholder="请输入送货人电话" />
        </el-form-item>
      </div>
      <!--虚拟-->
      <div v-if="formItem.deliveryType === 'fictitious'">
        <el-alert title="虚拟发货：订单将直接变为已发货状态，请谨慎操作！" type="warning" :closable="false" />
      </div>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="handleClose">取 消</el-button>
      <el-button type="primary" @click="handleSubmit('formItem')">确 定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { sendApi } from '@/api/order';
import { checkPermi } from '@/utils/permission';

const validatePhone = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('请输入电话号码'));
  } else {
    const reg = /^1[3456789]\d{9}$/;
    if (reg.test(value)) {
      callback();
    } else {
      callback(new Error('请输入正确的电话号码'));
    }
  }
};

export default {
  props: {
    expressListNormal: {
      type: Array,
      default: () => [],
    },
    expressListElec: {
      type: Array,
      default: () => [],
    },
    orderDetail: {
      type: Object,
      default: () => {},
    },
    orderId: {
      type: [String, Number],
      default: '',
    },
  },
  data() {
    return {
      modals: false,
      formItem: {
        deliveryType: 'express',
        expressRecordType: '1',
        expressName: '',
        expressCode: '',
        expressNumber: '',
        deliveryName: '',
        deliveryTel: '',
      },
      rules: {
        expressName: [{ required: true, message: '请输入快递公司名称', trigger: 'blur' }],
        expressCode: [{ required: true, message: '请选择快递公司', trigger: 'change' }],
        expressNumber: [{ required: true, message: '请输入快递单号', trigger: 'blur' }],
        deliveryName: [{ required: true, message: '请输入送货人姓名', trigger: 'blur' }],
        deliveryTel: [{ required: true, validator: validatePhone, trigger: 'blur' }],
      },
      expressType: 'normal',
      loading: false,
      express: [], //物流公司
      isEdit: false, //是否是编辑
    };
  },
  watch: {
    orderDetail: {
      handler: function (val) {
        if (val) {
          this.loading = true;
          this.isEdit = true;
          this.getExpressDetail(val);
        } else {
          this.isEdit = false;
          this.loading = false;
        }
      },
      immediate: false,
      deep: true,
    },
  },
  mounted() {
    this.express = this.expressListNormal;
  },
  methods: {
    checkPermi,
    // 切换发货类型
    changeRadioType(type) {
      if (type === 'express') {
        this.formItem.expressRecordType = '1';
      }
    },
    // 切换发货方式（电子面单已移除，保留方法以防旧数据）
    changeRadio(type) {
      // 电子面单功能已移除
    },
    // 获取发货详情
    getExpressDetail(val) {
      if (val.deliveryType === 'express') {
        this.formItem.deliveryType = 'express';
        this.formItem.expressRecordType = val.expressRecordType || '1';
        this.formItem.expressCode = val.deliveryCode;
        this.formItem.expressNumber = val.deliveryId;
        this.formItem.expressName = val.deliveryName;
      } else if (val.deliveryType === 'send') {
        this.formItem.deliveryType = 'send';
        this.formItem.deliveryName = val.deliveryName;
        this.formItem.deliveryTel = val.deliveryTel;
      } else if (val.deliveryType === 'fictitious') {
        this.formItem.deliveryType = 'fictitious';
      }
    },
    // 提交发货
    handleSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let data = {
            orderId: this.orderId,
            deliveryType: this.formItem.deliveryType,
          };
          if (this.formItem.deliveryType === 'express') {
            data.expressRecordType = this.formItem.expressRecordType;
            if (this.formItem.expressRecordType === '1') {
              data.expressCode = this.formItem.expressCode;
              data.expressName = this.formItem.expressName;
              data.expressNumber = this.formItem.expressNumber;
            }
          } else if (this.formItem.deliveryType === 'send') {
            data.deliveryName = this.formItem.deliveryName;
            data.deliveryTel = this.formItem.deliveryTel;
          }
          sendApi(data).then((res) => {
            this.$message.success('发货成功');
            this.handleClose();
            this.$emit('submitFail');
          });
        } else {
          return false;
        }
      });
    },
    // 关闭弹窗
    handleClose() {
      this.modals = false;
      this.$refs.formItem.resetFields();
      this.isEdit = false;
      this.formItem = {
        deliveryType: 'express',
        expressRecordType: '1',
        expressName: '',
        expressCode: '',
        expressNumber: '',
        deliveryName: '',
        deliveryTel: '',
      };
    },
  },
};
</script>

<style scoped lang="scss">
.order_box {
  ::v-deep .el-dialog__body {
    padding: 20px;
  }
}
</style>
