import {Message} from 'element-ui';
import {number2chinese} from './common';

// 默认配置
const optionsDefault = {
  /**
   * 表头数据 - 列属性
   * Array - 必填
   * {
   *    field,          // 列字段
   *    name,           // 表头名称
   *    style,          // 表头样式
   *    columnSize,     // 列宽 单位为 % - 默认 100%
   * }
   *
   */
  properties: [],
  /**
   * data
   * Array
   * {
   *    [表头字段]: T,
   * }
   */
  data: null,
  // 单据名
  // HTML 或 String
  // 例如：随货同行单
  title: '',
  // 订单号 - 必填
  orderNumber: '',
  // 单据创建时间
  // String - 必填
  // 格式必须为 xxxx-xx-xx
  createTime: '',
  // 制单人
  creator: '',
  //制单人所属科室
  billBranch: '',
  // 单据来源
  // HTML 或 String
  // 例如：供货单位、申领人
  fromWho: '',
  fromBranch: '',
  // 单据二维码
  qrcode: null,
  // 是否显示序号
  showIds: false,
  /**
   * 统计 - 累加 - 某条属性（必须为 number）
   * 一般为总价
   *
   * {
   *    val: '',      // 是否已有计算好的值，若没有则不填，可指定字段进行累加统计
   *    unit: '',     // 合计的单位，默认为 「元」
   *    field: '',    // 要累加的字段值（val 有值则不会累加统计）
   *    name: '',     // 对应的名字，默认为 「合计」
   *    colspan: 2,   // 字段名所占的单元格数，默认为 「2」
   *    showChinese: false, // 是否显示中文大写统计
   * }
   *
   */
  total: {},

  mulTotal: [],

  // header
  // HTML 或 String
  // 最上方的文字，例如医院名称、公司名称
  header: '临沂市河东区妇幼保健院',
  headerStyle: '',
  // 自定义 footer
  // HTML
  footer: '',
  // table item style
  formStyle: `border: 1px solid #000; padding: 5px 0; word-break: break-word;`,
  // table header style
  formHeaderStyle: `border: 1px solid #000; padding: 5px 0; word-break: break-word;`,
  // 序号列的宽度
  idsWidth: '2rem',
  // 文本对齐
  // center, left, right
  textAlign: 'center',

  // 空数据填充
  stuffing: '-',
  showStuffing:false,

};


const CONFIG = {
  a4: ['210mm', '297mm'],
  // 页边距 [上 右 下 左]
  pageMargin: ['0', '12.7mm', '12.7mm', '12.7mm'],
  // 二维码大小
  qrCodeSize: 70,
}

class PrintForm {

  options = {};
  _id = 1; // 起始序号
  _html = '';
  _class = 'print-form';  // 标识 div ，用于清除
  _iframe = null; // 当前 iframe
  _columnSize = '100%'; // 默认列宽
  _flagError = false;

  constructor(opts) {
    this.options = {...optionsDefault, ...opts};

    if (this.options.properties === null || this.options.length === 0) {
      console.error('表头为空');
      this.showMessage();
      return;
    }

    this.generateHtml();
  }

  /**
   * 生成 HTML 片段
   */
  generateHtml() {
    let page = 0;
    let flagStop = false; // 终止生成新页面

    if (this._html !== '') this._html = '';

    while (!flagStop) {
      flagStop = this.generateHtmlPage(page);
    }

    // 单据二维码
    if (this.options.qrcode) {
      this._html += `
        <script src="static/qrcode.min.js"></script>
        <script>
          var qrcode = new QRCode(document.getElementById("printFormQrCode"), {
            width : ${CONFIG.qrCodeSize},
            height : ${CONFIG.qrCodeSize}
          });
          qrcode.makeCode("${this.options.qrcode}");
        </script>
      `;
    }
  }

  /**
   * 生成页面
   * @param {int} page 页码
   * @return {boolean} 是否停止继续生成新页面
   */
  generateHtmlPage(page) {
    this._html += `
      <div
        id="printFormDiv${page}"
        style="
          padding: ${CONFIG.pageMargin[0]} ${CONFIG.pageMargin[1]} ${CONFIG.pageMargin[2]} ${CONFIG.pageMargin[3]}
        ">
    `;

    // 1级标题
    this._html += `
      <div
        style="
          font-weight: bold;
          font-size: 1.6rem;
          text-align: center;
          ${this.options.headerStyle ? this.options.headerStyle : ''}"
      >${this.options.header}</div>
    `;

    // 2级标题
    this._html += `
      <div style="margin-top: .5rem; text-align: center; font-size: 1.6rem;">
        ${this.options.title}
      </div>
    `;

    // 单据二维码
    if (this.options.qrcode && page === 0) {
      this._html += `<div id="printFormQrCode" style="position: absolute; top: 0;"></div>`;
    }

    /** start: 顶部基本信息 */
    let textCreateTime = `制单时间：${this.options.createTime}`;

    // 单据编号
    this._html += `
      <div style="margin-top: .8rem; text-align: right;">
        单据编号：
        <span style="color: red;">
          NO${this.options.orderNumber ? this.options.orderNumber : this.options.stuffing}
        </span>
      </div>
    `;
    // 来源和创建时间
    if (this.options.billBranch === '中心库') {
      this._html += `
        <div style="margin-top: .3rem; display: flex; justify-content: space-between;">
         <div style="margin-top: .3rem;">申请科室：${this.options.fromBranch}</div>
        <div>${this.options.fromWho}</div>
        <div>${textCreateTime}</div>
      </div>
      `;
    } else {
      this._html += `
      <div style="margin-top: .3rem; display: flex; justify-content: space-between;">
        <div>${this.options.fromWho}</div>
        <div>${textCreateTime}</div>
      </div>
    `;
    }

    /** end: 顶部基本信息 */

    this._html += `<table style="width: 100%; margin-top: .5rem; table-layout: fixed;" border="1" cellspacing="0">`;


    /** start: 表头 */
    this._html += `<thead style="display: table-header-group;">`;
    // 显示序号
    if (this.options.showIds) {
      this._html += `<th style="${this.options.formHeaderStyle}; width: ${this.options.idsWidth};">序号</th>`;
    }
    if (this.options.showStuffing){
      this.options.stuffing = ' ';
    }
    for (let i = 0; i < this.options.properties.length; i++) {
      this._html += `
        <th
          style="
            ${this.options.formHeaderStyle ? this.options.formHeaderStyle : ''};
            ${this.options.properties[i].style ? this.options.properties[i].style : ''};
            width: ${this.options.properties[i].columnSize ? this.options.properties[i].columnSize : this._columnSize};"
        >${this.options.properties[i].name}</th>`;
    }
    this._html += `</thead>`;
    /** end: 表头 */


    /** start: 表行数据 */
    this._html += `<tbody>`;
    if (this.options.data !== null) {
      for (let i = 0; i < this.options.data.length; i++) {
        this._html += `<tr>`;

        // 显示序号
        if (this.options.showIds) {
          this._html += `
            <td
              style="${this.options.formStyle};
                width: ${this.options.idsWidth};
                text-align: ${this.options.textAlign}"
            >
              ${this._id}
            </td>
          `;

          this._id++;
        }

        const rowData = this.options.data[i];
        let textData = null;

        // 只打印表头中存在的字段
        for (let j = 0; j < this.options.properties.length; j++) {
          const property = this.options.properties[j];

          textData = rowData[property.field] ? rowData[property.field] : this.options.stuffing;

          this._html += `
            <td
              style="
                ${this.options.formStyle ? this.options.formStyle : ''};
                width: ${property.columnSize ? property.columnSize : this._columnSize};
                text-align: ${this.options.textAlign};"
            >${textData}</td>
          `;
        }

        this._html += `</tr>`;
      }

      // 合计某个属性
      if (Object.keys(this.options.total).length > 0 && this.options.total.showChinese) {
        let __total = 0;
        let __totalChinese = '';  // 统计 - 中文大写

        // 已传入计算好的值，则无需累加操作
        if (this.options.total.val) {
          __total = this.options.total.val;
        } else {
          for (let i = 0; i < this.options.data.length; i++) {
            __total += this.options.data[i][this.options.total.field];
          }
        }
        __total = __total.toFixed(2)

        const __totalName = this.options.total.name ? this.options.total.name : '合计';
        const __unit = this.options.total.unit ? this.options.total.unit : '元';
        const __colspanName = this.options.total.colspan ? this.options.total.colspan : 2;
        let __colspanVal = this.options.properties.length - __colspanName;
        let __colspanChinese = 0;

        if (this.options.showIds) __colspanVal++;

        // 统计 - 金额 - 中文大写
        if (this.options.total.showChinese) {
          __colspanVal = Math.ceil((this.options.properties.length - __colspanName) / 2);
          __colspanChinese = this.options.properties.length - __colspanName - __colspanVal;
          if (this.options.showIds) __colspanVal++;
        }

        this._html += `
          <tr>
            <td colspan="${__colspanName}" style="padding: .3rem; text-align: center;">${__totalName}</td>
            <td colspan="${__colspanVal}" style="padding: .3rem; text-align: center;">${__total} ${__unit}</td>
        `;

        if (__colspanChinese > 0) {
          __totalChinese = number2chinese(__total);

          this._html += `
            <td colspan="${__colspanChinese}" style="padding: .3rem; text-align: center;">${__totalChinese}</td>
          `;
        }
        this._html += '</tr>';
      }

      //展示试剂出入库统计中的合计
      if (this.options.mulTotal.length > 0) {
        const __totalName = '合计';
        const __colspanName = this.options.mulTotal.colspan ? this.options.mulTotal.colspan : 3;
        let __colspanVal = 1;
        this._html += `
          <tr>
           <td colspan="${__colspanName}" style="padding: .3rem; text-align: center;">${__totalName}</td>
        `;

        for (let i = 0; i < this.options.mulTotal.length; i++) {
          this._html += `
           <td colspan="${__colspanVal}" style="padding: .3rem; text-align: center;">${this.options.mulTotal[i]}</td>
        `;
        }
        this._html += '</tr>';
      }
    }

    this._html += `</tbody>`;
    /** end: 表行数据 */

    // this._html += `<tfoot style="display: table-footer-group; font-weight: bold">
    //   <tr>
    //       <td colspan="2" align="center" style="font-weight: bold; border: 3px double blue">每页都有的表尾</td>
    //   </tr>`;
    this._html += `</table>`;

    /** start: 底部数据 */
    this._html += `<div id="printFormFooter${page}">`;

    if (this.options.creator !== '') {
      this._html += `
        <div style="margin-top: .5rem;">制表人：${this.options.creator}</div>
      `;
    }



    this._html += this.options.footer;
    // todo 分页与总页码
    // this._html += `<div style="text-align: right; font-size: .8rem;">${page + 1} / <span id="printFormPageTotal${page}">1</span></div>`;
    this._html += `</div>`;
    /** 底部数据 */

    this._html += `</div>`;

    return true;
  }

  calculateHeight() {
    // todo 计算高度，实现分页
    // new UnitConversion().px2mm(value)
  }

  /**
   * 挂载代码片
   */
  mountHtml() {
    if (this._flagError) return;

    this.clearAll();

    let iframe = document.createElement('iframe');
    iframe.setAttribute('class', this._class);
    // iframe.setAttribute('style', 'width: 900px; height: 500px; margin-left: 300px;');
    iframe.setAttribute('style', 'position: absolute; width: 0; height: 0; left: -500px; top: -500px;');

    window.document.body.appendChild(iframe);
    iframe.contentWindow.document.write(this._html);
    iframe.contentWindow.document.body.style.margin = '0';

    this._iframe = iframe;
  }

  /**
   * 打印
   */
  async toPrint() {
    if (this._flagError) return;

    this.mountHtml();

    // 需要等待二维码生成
    if (this.options.qrcode) {
      const _divQrCode = this._iframe.contentWindow.document.querySelector("#printFormQrCode");

      await this._waitGenerateQrcode(_divQrCode);
    }

    this._iframe.contentWindow.print();

    this._iframe.parentNode.removeChild(this._iframe);
    this._iframe = null;
    // this.clearAll();
  }

  /**
   * 等待二维码生成
   */
  _waitGenerateQrcode(_divQrCode) {

    return new Promise(resolve => {
      setTimeout(() => {
        resolve();
      }, 300);
    });
    // const _this = this;

    // if (!this._iframe) return;

    // if (_divQrCode.getAttribute('title')) {
    //   this._iframe.contentWindow.print();
    //   return new Promise.resolve();
    // } else {
    //   setTimeout(() => {
    //     const rr  = _this._waitGenerateQrcode(_divQrCode);
    //     return _this._waitGenerateQrcode(_divQrCode);
    //   }, 100);
    // }

    // return new Promise(resolve => {
    //   if (_divQrCode.getAttribute('title')) {
    //     resolve();
    //   } else {
    //     setTimeout(() => {
    //       _this._waitGenerateQrcode(_divQrCode);
    //     }, 100);
    //   }
    // })
  }

  /**
   * 清除挂载的所有单据
   */
  clearAll() {
    const arrDom = document.body.querySelectorAll(`.${this._class}`);
    for (let i = 0; i < arrDom.length; i++) {
      window.document.body.removeChild(arrDom[i]);
    }

    this._iframe = null;
  }

  /**
   * 给用户的提醒
   */
  showMessage() {
    // 目前只用到 error
    this._flagError = true;
    Message.error('打印单数据处理错误，请联系管理员');
  }
}

export {
  PrintForm
}
