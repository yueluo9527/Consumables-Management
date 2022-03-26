import request from '@/utils/request'

export function createOutItem(data) {
  return request({
    url: '/outBill/create',
    method: 'post',
    data: data
  })
}
