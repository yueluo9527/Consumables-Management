import request from '@/utils/request'

export function createRefundItem(data) {
  return request({
    url: '/refund/create',
    method: 'post',
    data: data
  })
}
