import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/collectDetail/list',
    method: 'get',
    params: params
  })
}

export function getCollectDetail(collectNo) {
  return request({
    url: '/collectDetail/' + collectNo,
    method: 'get'
  });
}

export function updateCollectDetail(id, data) {
  return request({
    url: '/collectDetail/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteCollectDetail(params) {
  return request({
    url: '/collectDetail/delete',
    method: 'post',
    params: params
  })
}

export function deleteCollectDetailItem(id) {
  return request({
    url: '/collectDetail/delete/' + id,
    method: 'post'
  })
}
