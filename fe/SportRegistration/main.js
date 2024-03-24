import App from './App.vue'

// #ifndef VUE3
import Vue from 'vue'
// Vue.use(uView)
uni.$u.config.unit = 'rpx'
console.log(uni.$u.config.v);
Vue.config.productionTip = false
/*Vue.prototype.$serverHost='http://localhost'*/
Vue.prototype.$serverHost='https://oryjk.cn'
Vue.prototype.$port='5678'
// Vue.prototype.$serverUrl='http://'+$serverHost+':'+$port
App.mpType = 'app'
const app = new Vue({
	...App
})
app.$mount()
// #endif

// #ifdef VUE3
import {
	createSSRApp
} from 'vue'
export function createApp() {
	const app = createSSRApp(App)
	return {
		app
	}
}
// #endif
