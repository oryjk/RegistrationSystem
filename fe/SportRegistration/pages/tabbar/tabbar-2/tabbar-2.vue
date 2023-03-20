<template>
	<view class="content">
		页面 - 2
		<navigator url="/pages/tabbar/tabbar-1/tabbar-1" open-type="reLaunch">跳回第一页</navigator>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style>
	.content {
		text-align: center;
		height: 400upx;
		margin-top: 200upx;
	}
</style>
