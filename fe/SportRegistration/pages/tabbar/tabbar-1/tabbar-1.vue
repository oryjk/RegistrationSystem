<template>
	<view class="container">
		<uni-section title="最近接龙" type="line" padding>
			<view v-for="(competition, index) in list" :key="index" class="uni-flex uni-column">
				<view class="uni-flex uni-row">
					<u-cell-group>
						<u-cell iconStyle="width: 120rpx;height: 120rpx;border-radius: 50%"
							titleStyle="color: #000000;font-weight:bloder" icon="../../../static/img/tabbar/me.png"
							:title="competition.name" center>

							<u-tag slot="value" text="进行中" shape="circle" type="success"></u-tag>

							<view slot="label" class="uni-flex uni-row">
								<u-tag text="报名" shape="circle" type="success"></u-tag>
								<text >{{competition.gameDate}}eeeeeeeeeeeeee</text>
						
							</view>
							
						</u-cell>
					
					</u-cell-group>


				</view>
				<u-line color="#2979ff"></u-line>

			</view>

		</uni-section>
	</view>

</template>

<script>
	export default {
		data() {
			return {

				list: ['暂时没有任何接龙'],


			};
		},
		onLoad() {
			let that = this
			let baseUrl = this.$serverHost + ':' + this.$port
			console.log(this.$serverHost + ':' + this.$port + "/api/competition/all")
			uni.request({
				url: baseUrl + "/api/competition/all",
				method: 'GET',
				success: (res) => {
					console.log(res.data)
					that.list = res.data
					console.log(that.list)
					console.log("that.list")
				}

			})
		},
		methods: {}
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

	.uni-flex {
		display: flex;
	}

	.uni-row {
		flex-direction: row;
	}

	.uni-column {
		flex-direction: column;

	}
</style>