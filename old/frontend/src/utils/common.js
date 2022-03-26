/**
 * 单位转换
 * px->mm 或 mm->px
 */
class UnitConversion {

  arrDPI = [];

  constructor() {
    this.arrDPI = [];

    if (window.screen.deviceXDPI) {
      this.arrDPI[0] = window.screen.deviceXDPI;
      this.arrDPI[1] = window.screen.deviceYDPI;
    } else {
      const tmpNode = document.createElement("DIV");
      tmpNode.style.cssText = "width: 1in; height: 1in; position: absolute; left: 0px; top: 0px; z-index: 99; visibility: hidden";
      document.body.appendChild(tmpNode);
      this.arrDPI[0] = parseInt(tmpNode.offsetWidth);
      this.arrDPI[1] = parseInt(tmpNode.offsetHeight);
      tmpNode.parentNode.removeChild(tmpNode);
    }
  }

  /**
   * px 转换为 mm
   * @param value
   * @returns {number}
   */
  px2mm(value) {
    const inch = value / this.arrDPI[0];
    // 1英寸 = 25.4mm
    const c_value = inch * 25.4;

    return c_value;
  }

  /**
   * mm 转换为 px
   * @param value
   * @returns {number}
   */
  mm2px(value) {
    // 1英寸 = 25.4mm
    const inch = value / 25.4;
    const c_value = inch * this.arrDPI[0];

    return c_value;
  }

}

/**
 * 金额，number -> Chinese
 * @param {number} val 金额
 * @returns
 */
function number2chinese(val) {
  const cnNums = new Array(
    '零',
    '壹',
    '贰',
    '叁',
    '肆',
    '伍',
    '陆',
    '柒',
    '捌',
    '玖'
  );

  const cnIntRadice = new Array('', '拾', '佰', '仟');  // 基本单位
  const cnIntUnits = new Array('', '万', '亿', '兆'); // 对应整数部分扩展单位
  const cnDecUnits = new Array('角', '分', '毫', '厘'); // 对应小数部分单位
  const cnInteger = '整'; // 整数金额时后面跟的字符
  const cnIntLast = '元'; // 整数完以后的单位

  // 最大处理的数字
  const maxNum = 999999999999999.9999;
  let integerNum; // 金额整数部分
  let decimalNum; // 金额小数部分

  // 输出的中文金额字符串
  let chineseStr = '';
  let parts; // 分离金额后用的数组，预定义
  if (val === '') {
    return '';
  }

  val = parseFloat(val);

  if (val >= maxNum) {
    // 超出最大处理数字
    return '超出最大处理数字';
  }

  if (val === 0) {
    chineseStr = cnNums[0] + cnIntLast + cnInteger;
    return chineseStr;
  }

  // 四舍五入保留两位小数,转换为字符串
  val = Math.round(val * 100).toString();
  integerNum = val.substr(0, val.length - 2);
  decimalNum = val.substr(val.length - 2);

  // 获取整型部分转换
  if (parseInt(integerNum, 10) > 0) {
    let zeroCount = 0;
    const IntLen = integerNum.length;
    for (let i = 0; i < IntLen; i++) {
      const n = integerNum.substr(i, 1);
      const p = IntLen - i - 1;
      const q = p / 4;
      const m = p % 4;
      if (n === '0') {
        zeroCount++;
      } else {
        if (zeroCount > 0) {
          chineseStr += cnNums[0];
        }
        // 归零
        zeroCount = 0;
        chineseStr += cnNums[parseInt(n)] + cnIntRadice[m];
      }

      if (m === 0 && zeroCount < 4) {
        chineseStr += cnIntUnits[q];
      }

    }

    chineseStr += cnIntLast;
  }

  // 小数部分
  if (decimalNum !== '') {
    const decLen = decimalNum.length;
    for (let i = 0; i < decLen; i++) {
      var n = decimalNum.substr(i, 1);
      if (n !== '0') {
        chineseStr += cnNums[Number(n)] + cnDecUnits[i];
      }
    }
  }

  if (chineseStr === '') {
    chineseStr += cnNums[0] + cnIntLast + cnInteger;
  } else if (decimalNum === '' || /^0*$/.test(decimalNum)) {
    chineseStr += cnInteger;
  }

  return chineseStr;

}

export {
  UnitConversion,
  number2chinese,
}
