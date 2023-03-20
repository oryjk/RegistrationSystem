<template>
	<view class="content">
		页面 - 1
		<view class="">
			<navigator url="/pages/tabbar/tabbar-2/tabbar-2" open-type="reLaunch" hover-class="navigator-hover">
				创建分组
			</navigator>
		</view>

		<view class="content">
			<navigator url="/pages/tabbar/tabbar-3/tabbar-3">
				谢谢谢谢
			</navigator>
		</view>
		<view class="">
			<navigator url="/pages/tabbar/tabbar-3/tabbar-3">跳转一下</navigator>
		</view>
		小程序的名称：{{title}}
		arr:{{arr[1]}}
		<view>obj:{{obj.name}}</view>
		---------------------------
		<image :src="picUrl" mode="aspectFill" @click="getPicUrl"></image>
		xxxxxxxxxxxxx
		<view v-for="(item,index) in picUrls" :key="index">
			index:{{index}} <image :src="item.url" mode="aspectFill" @click="getPicUrl"></image>
		</view>
		yyyyyyyyyyyyy
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '各种工具集合',
				arr: ["aaa", "bbb", 1, 2, 3],
				obj: {
					name: "zhangsan",
					age: 22
				},
				state: false,
				picUrl: "",
				picUrls: []
			};
		},
		onLoad() {
			this.getPicUrls()
		},
		methods: {
			getPicUrl() {
				uni.showLoading({
					title: "数据加载中……"
				})

				uni.request({
					url: "https://api.thecatapi.com/v1/images/search",
					timeout: 5000,
					success: (res) => {
						this.picUrl = res.data[0].url
						uni.hideLoading()
					},
					fail: (err) => {
						console.log("网络请求失败")
					},
					complete: () => {
						console.log("请求结束")
					}
				})
			},
			getPicUrls() {
				
				uni.showLoading({
					title: "数据加载中……"

				})
				uni.request({
					url: "https://api.thecatapi.com/v1/images/search",
					data:{
						limit:3
					},
					timeout: 5000,
					success: (res) => {
						this.picUrls = res.data
						uni.hideLoading()
					},
					fail: (err) => {
						console.log("网络请求失败")
					},
					complete: () => {
						console.log("请求结束")
					}
				})
			}
		}
	};
</script>

<style>
	.content {
		text-align: center;
		height: 400upx;
		margin-top: 200upx;
	}
</style>
