import request from '@/utils/request'

export function getQr(id) {
  return request({
    url: `/consumable/consumable-in/qr/get/${id}`,
    method: 'get'
  })
}
