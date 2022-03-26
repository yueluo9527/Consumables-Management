import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/incident/list',
    method:'get',
    params:params
  })
}

export function fetchSimpleList(params) {
  return request({
    url:'/incident/simpleList',
    method:'get',
    params:params
  })
}

export function updateDeleteStatus(params) {
  return request({
    url:'/incident/update/deleteStatus',
    method:'post',
    params:params
  })
}

export function updateNewStatus(params) {
  return request({
    url:'/incident/update/newStatus',
    method:'post',
    params:params
  })
}

export function updateRecommendStatus(params) {
  return request({
    url:'/incident/update/recommendStatus',
    method:'post',
    params:params
  })
}

export function updatePublishStatus(params) {
  return request({
    url:'/incident/update/publishStatus',
    method:'post',
    params:params
  })
}

export function createIncident(data) {
  return request({
    url:'/incident/create',
    method:'post',
    data:data
  })
}

export function updateIncident(id,data) {
  return request({
    url:'/incident/update/'+id,
    method:'post',
    data:data
  })
}

export function getIncident(id) {
  return request({
    url:'/incident/updateInfo/'+id,
    method:'get',
  })
}

