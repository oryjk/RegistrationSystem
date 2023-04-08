<template>
	<view class="container">
		<uni-section title="最近接龙" type="line" padding>
			<scroll-view v-for="(competition, index) in list" :key="index">
				<view class="tag-view">
					{{competition.name}}
					{{competition.gameDate}}
					{{competition.venue}}
					{{competition.competitionStatement}}
				</view>

			</scroll-view>
		</uni-section>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
				list: ['暂时没有任何接龙']

			};
		},
		onLoad() {
			let that=this
			uni.request({
				url: "http://localhost:8080/api/competition/all",
				method: 'GET',
				success: (res) => {
					console.log(res.data)
					that.list=res.data
				}
			
			})
		},
		methods: {
			
		}
	};
</script>

<style>
	.container {
		/* text-align: center; */
		/* height: 400upx; */
		/* margin-top: 200upx; */
		background-color: #fff;
		padding: 10px;
	}
</style>