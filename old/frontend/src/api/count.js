import request from '@/utils/request'

export function getCount(params) {
  return request({
    url: '/count/home',
    method: 'get',
    params: params,
    timeout: 999999,
  })
}
export function getHomeCount(params) {
  return request({
    url: '/count/homeCount',
    method: 'get',
    params: params,
    timeout: 999999,
  })
}
export function getChartPie(params) {
  return request({
    url: '/count/chartPie',
    method: 'get',
    params: params
  })
}
export function getChartBar(params) {
  return request({
    url: '/count/chartBar',
    method: 'get',
    params: params
  })
}
export function getChartBarTop(params) {
  return request({
    url: '/count/chartBarTop',
    method: 'get',
    params: params
  })
}

export function getChartLine(params) {
  return request({
    url: '/count/chartLine',
    method: 'get',
    params: params
  })
}
export function getBranch(username) {
  return request({
    url: '/count/getBranch/' + username,
    method: 'post'
  })
}
