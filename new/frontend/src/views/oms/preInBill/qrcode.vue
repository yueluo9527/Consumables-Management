<template>
  <div>
    <div ref="print" id="printStyle">
      <div class="item"
           v-for="(item,index) in this.goodsData"
           :key="index">
        <h2>{{ item.qrCode }}</h2>
        <div class="qrcode-pic" ref=codeItem></div>
      </div>
    </div>
    <button @click="printCode">批量打印</button>
  </div>
</template>

<script>
import {fetchList} from '@/api/preInItem'
// 引入qrcodejs2
import QRCode from 'qrcodejs2';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
};
export default {
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      loading: false,
      listLoading: false,
      preInItem: null,
      goodsData: {},
    };
  },
  created() {
    this.getList();
  },
  //方法集合
  methods: {
    handleBatchPrintCode1() {
      //必须要等到页面加载完成，不然会报错
      this.$nextTick(() => {
        console.log("goodsData111: ", this.goodsData)
        this.goodsData.forEach((item, index) => {
          console.log("code111111: ")
          let code = item.code;
          console.log("code: ", code)
          this.$refs.codeItem[index].innerHTML = "";
          new QRCode(this.$refs.codeItem[index], {
            text: code, //二维码内容
            width: 200,
            height: 200,
            // colorDark: "#333333", //二维码颜色
            // colorLight: "#ffffff", //二维码背景色
          })
        })
      })
    },

    handleBatchPrintCode2() {
      //必须要等到页面加载完成，不然会报错
      this.$nextTick(() => {
        console.log("goodsData111: ", this.goodsData)
        console.log("code2222: ", this.goodsData.length)
        for (let i = 0; i < this.goodsData.length; i++) {

          let code = this.goodsData[i].qrCode;
          console.log("code111: ", code)
          this.$refs.codeItem[i].innerHTML = "";
          new QRCode(this.$refs.codeItem[i], {
            text: code, //二维码内容
            width: 200,
            height: 200,
            // colorDark: "#333333", //二维码颜色
            // colorLight: "#ffffff", //二维码背景色
          })
        }
      })
    },
    printCode() {
      setTimeout(() => {
        this.$print(this.$refs.print);
      }, 100)
    },
    getList() {
      this.listLoading = true;
      this.listQuery.keyword = 971621433258725;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.preInItem = response.data.list;
        this.total = response.data.total;
        this.goodsData = this.preInItem;

        //必须要等到页面加载完成，不然会报错
        this.$nextTick(() => {
          for (let i = 0; i < this.goodsData.length; i++) {

            let code = this.goodsData[i].qrCode;
            console.log("code111: ", code)
            this.$refs.codeItem[i].innerHTML = "";
            new QRCode(this.$refs.codeItem[i], {
              text: code, //二维码内容
              width: 300,
              height: 300,
              correctLevel: 3
              // colorDark: "#333333", //二维码颜色
              // colorLight: "#ffffff", //二维码背景色
            })
          }
        })
      });

    },
  },
};
</script>
<style>
@media print {
  #printStyle .item {
    margin: 10px;
  }

  #printStyle h2 {
    font-size: 30px;
  }
}
</style>

