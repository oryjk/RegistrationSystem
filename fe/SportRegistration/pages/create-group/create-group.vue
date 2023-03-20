<template>

	<view>
		<view>about页面</view>
		<view class="content">
			<navigator url="/pages/tabbar/tabbar-1/tabbar-1">跳转到首页</navigator>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				picurl: ""
			}
		},
		methods: {

		},
		onLoad() {
			uni.request({
				url: "https://api.thecatapi.com/v1/images/search",
				success: (res) => {
					console.log(res.data[0].url)

				}
			})
		}
	}
</script>

<style>

</style>
