<template>
	<view class="content">
		<view class="">
			<uni-forms ref="form" label-position="left" label-width="80px">
				<uni-easyinput type="text" v-model="formData.name" placeholder="请输入活动名称" />
				<view class="">
				<uni-forms-item label="活动介绍" name="description" />
				<uni-easyinput type="text" v-model="formData.description" placeholder="请输入活动描述信息" />	
				</view>
				
				<uni-section :title="'报名截止时间:'+formData.single" sub-title="" type="line"></uni-section>
				<view class="">
					<uni-datetime-picker type="date" :clear-icon="false" v-model="formData.single"
						@maskClick="maskClick" @change="changeLog" />
				</view>

			</uni-forms>
		</view>


	</view>
</template>

<script>
	export default {
		data() {
			return {
				formData: {
					name: '',
					email: 'dcloud@email.com',
					description: '',
					single: '',
				}

			};
		},
		onLoad() {},
		methods: {}
	};
</script>

<style>
	.content {
		/* text-align: center; */
		/* height: 400upx; */
		/* margin-top: 200upx; */
		background-color: #fff;
		padding: 10px;
	}
</style>
