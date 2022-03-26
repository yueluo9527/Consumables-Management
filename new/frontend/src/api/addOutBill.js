import request from '@/utils/request'

export function createOutBillItem(data) {
  return request({
    url: '/outBill/create',
    method: 'post',
    data: data
  })
}
